package uzuzjmd.competence.owl.access;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import uzuzjmd.competence.console.util.LogStream;
import uzuzjmd.competence.owl.ontology.CompObjectProperties;
import uzuzjmd.competence.owl.ontology.CompOntClass;
import uzuzjmd.competence.owl.queries.CompetenceQueries;
import uzuzjmd.competence.owl.reasoning.ModelChangeListener;
import uzuzjmd.competence.owl.reasoning.RuleFactory;
import uzuzjmd.competence.owl.reasoning.SimpleRulesReasoner;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.tdb.TDB;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.vocabulary.ReasonerVocabulary;

public class CompOntologyManager {

	static final Logger logger = LogManager.getLogger(CompOntologyManager.class.getName());
	static LogStream logStream = new LogStream(logger, Level.TRACE);

	private CompOntologyAccess util;
	private OntModel m;
	private SimpleRulesReasoner rulesReasoner;
	private CompetenceQueries queries;
	private ModelChangeListener modelChangedListener;
	private Dataset dataset;

	/**
	 * should be singleton
	 */
	public CompOntologyManager() {
		this.queries = new CompetenceQueries(getM());
		this.util = new CompOntologyAccess(getM(), getQueries(), this);
	}

	public void startReasoning() {
		// init simple Rules Reasoner
		initReasoner();
		rulesReasoner.switchOnDebug();
		initRulesFactory(rulesReasoner);

		// apply rules whenever the model is changed
		this.modelChangedListener = new ModelChangeListener(rulesReasoner, this);

		// defaultmäßif ist derReasoner angeschaltet
		registerReasoner();
	}

	public Dataset getDataset() {
		return dataset;
	}

	public OntModel getM() {
		return this.m;
	}

	public void close() {
		dataset.commit();
		dataset.end();
	}

	public void unregisterReasoner() {
		m.unregister(modelChangedListener);
	}

	public void registerReasoner() {
		m.register(modelChangedListener);
	}

	private void initReasoner() {
		try {
			rulesReasoner = new SimpleRulesReasoner(this, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OntModel createBaseOntology() {
		begin();
		// m = this.util.initializeOntologyModel();
		initClasses();
		initObjectProperties();
		// init rulesReasoning and add standard rules
		// rulesReasoner = initRulesReasoning();

		logger.info("Base Ontology created");
		logger.setLevel(Level.DEBUG);
		// m.write(logStream);

		// TODO create Restrictions

		close();
		return getM();
	}

	private void initObjectProperties() {
		getUtil().createObjectProperty(CompOntClass.Learner, CompOntClass.Competence, CompObjectProperties.LearnerOf);
		getUtil().createObjectProperty(CompOntClass.Competence, CompOntClass.Learner, CompObjectProperties.LearnerOfInverse);
		getUtil().createObjectProperty(CompOntClass.Catchword, CompOntClass.Competence, CompObjectProperties.CatchwordOf);
		getUtil().createObjectProperty(CompOntClass.Competence, CompOntClass.Catchword, CompObjectProperties.CatchwordOfInverse);
		getUtil().createObjectProperty(CompOntClass.Evidence, CompOntClass.Competence, CompObjectProperties.EvidencOf);
		getUtil().createObjectProperty(CompOntClass.Competence, CompOntClass.Evidence, CompObjectProperties.EvidencOfInverse);
		getUtil().createObjectProperty(CompOntClass.Operator, CompOntClass.Competence, CompObjectProperties.OperatorOf);
		getUtil().createObjectProperty(CompOntClass.Operator, CompOntClass.Competence, CompObjectProperties.OperatorOfInverse);
		getUtil().createObjectProperty(CompOntClass.DescriptionElement, CompOntClass.CompetenceDescription, CompObjectProperties.DescriptionElementOf);
		getUtil().createObjectProperty(CompOntClass.CompetenceDescription, CompOntClass.DescriptionElement, CompObjectProperties.DescriptionElementOfInverse);
		getUtil().createObjectProperty(CompOntClass.CompetenceDescription, CompOntClass.Competence, CompObjectProperties.CompetenceDescriptionOf);
		getUtil().createObjectProperty(CompOntClass.Competence, CompOntClass.CompetenceDescription, CompObjectProperties.CompetenceDescriptionOfInverse);
		getUtil().createObjectProperty(CompOntClass.Competence, CompOntClass.CompetenceSpec, CompObjectProperties.SpecifiedBy);
		getUtil().createObjectProperty(CompOntClass.CompetenceSpec, CompOntClass.Competence, CompObjectProperties.SpecifiedByInverse);
		getUtil().createObjectProperty(CompOntClass.Competence, CompOntClass.Competence, CompObjectProperties.SimilarTo);
		getUtil().createObjectProperty(CompOntClass.CourseContext, CompOntClass.Competence, CompObjectProperties.CourseContextOf);
		getUtil().createObjectProperty(CompOntClass.CourseContext, CompOntClass.Competence, CompObjectProperties.CompulsoryOf);
		getUtil().createObjectProperty(CompOntClass.AbstractEvidenceLink, CompOntClass.CourseContext, CompObjectProperties.LinkOfCourseContext);
		getUtil().createObjectProperty(CompOntClass.EvidenceActivity, CompOntClass.AbstractEvidenceLink, CompObjectProperties.ActivityOf);
		getUtil().createObjectProperty(CompOntClass.User, CompOntClass.AbstractEvidenceLink, CompObjectProperties.UserOfLink);
		getUtil().createObjectProperty(CompOntClass.AbstractEvidenceLink, CompOntClass.User, CompObjectProperties.createdBy);
		getUtil().createObjectProperty(CompOntClass.User, CompOntClass.Comment, CompObjectProperties.UserOfComment);
		getUtil().createObjectProperty(CompOntClass.Comment, CompOntClass.AbstractEvidenceLink, CompObjectProperties.CommentOf);
		getUtil().createObjectProperty(CompOntClass.Role, CompOntClass.User, CompObjectProperties.RoleOf);
		getUtil().createObjectProperty(CompOntClass.Competence, CompOntClass.Competence, CompObjectProperties.PrerequisiteOf);
		getUtil().createObjectProperty(CompOntClass.Competence, CompOntClass.Competence, CompObjectProperties.NotPrerequisiteOf);
		getUtil().createObjectProperty(CompOntClass.User, CompOntClass.Competence, CompObjectProperties.NotAllowedToView);

		// getM().getObjectProperty(
		// MagicStrings.PREFIX + CompObjectProperties.SimilarTo)
		// .addProperty(RDF.type, OWL2.ReflexiveProperty);
	}

	private void initClasses() {
		for (CompOntClass compOntClass : CompOntClass.values()) {
			getUtil().createOntClass(compOntClass);
		}
	}

	/**
	 * Also creates a database, if it does not exist already If there already
	 * exist one, Nullpointer is thrown
	 * 
	 * @return
	 */
	public void begin() {
		dataset = TDBFactory.createDataset(MagicStrings.TDBLocationPath);
		dataset.begin(ReadWrite.WRITE);
		Model tdb = dataset.getDefaultModel();
		setM(ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF, tdb));

	}

	private SimpleRulesReasoner initRulesFactory(SimpleRulesReasoner rulesReasoner) {
		RuleFactory factory = new RuleFactory();
		for (String ruleString : factory.getRuleStringss()) {
			rulesReasoner.addRuleAsString(ruleString);
		}
		return rulesReasoner;
	}

	private void initializeOntologyModelInMemory() {
		setM(ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF));

	}

	public CompOntologyAccess getUtil() {
		return util;
	}

	public void setM(OntModel m) {
		this.m = m;
	}

	public SimpleRulesReasoner getRulesReasoner() {
		return rulesReasoner;
	}

	public CompetenceQueries getQueries() {
		return queries;
	}

	public void switchOffDebugg() {
		rulesReasoner.getReasoner().setParameter(ReasonerVocabulary.PROPtraceOn, false);
		SimpleRulesReasoner.logger.setLevel(Level.ERROR);
		SimpleRulesReasoner.logStream = new LogStream(logger, Level.ERROR);
	}

	public void sync() {
		TDB.sync(dataset);
	}

}
