package uzuzjmd.competence.owl.dao

import uzuzjmd.competence.owl.ontology.CompOntClass
import uzuzjmd.competence.owl.access.CompOntologyManager
import uzuzjmd.competence.owl.access.OntResult
import com.hp.hpl.jena.ontology.Individual
import com.hp.hpl.jena.ontology.OntClass
import uzuzjmd.competence.owl.access.MagicStrings
import uzuzjmd.competence.owl.access.CompOntologyAccess
import com.hp.hpl.jena.rdf.model.Property
import com.hp.hpl.jena.rdf.model.Statement

abstract case class CompetenceOntologySingletonDao(comp: CompOntologyManager, val compOntClass: CompOntClass, val identifier: String = null) extends Dao(comp) {
  val util = comp.getUtil()

  def persist(more: Boolean): OntResult = {
    var result: OntResult = null
    if (identifier == null) {
      result = util.accessSingletonResourceWithClass(compOntClass)
    } else {
      result = util.accessSingletonResource(identifier)
    }
    if (more) {
      persistMore
    }
    return result
  }

  /**
   * needs this override, because the definition is not placed at the level of the individual but the corresponding class
   */
  @Override
  def getPropertyPair(key: String): (Property, Statement) = {
    val literal = comp.getM().createProperty(CompOntologyAccess.encode(key));
    val prop: Statement = persist(false).getOntclass().getProperty(literal);
    return (literal, prop)
  }

  def createIndividual: Individual = {
    return persist(false).getIndividual()
  }

  def exists(): Boolean = {
    return util.getIndividualForString(MagicStrings.SINGLETONPREFIX + compOntClass.name()) != null
  }

  def getId: String = {
    return createIndividual.getLocalName()
  }
}