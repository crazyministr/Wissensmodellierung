package uzuzjmd.competence.liferay.reflexion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.ws.rs.core.MediaType;

import uzuzjmd.competence.liferay.util.SOAUtil;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@ManagedBean(name="LearningTemplatesFullSet")
public class LearningTemplatesFullSet implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private static Log _log = LogFactoryUtil
//			.getLog(LearningTemplatesFullSet.class);
//	
	@ManagedProperty("#{learningTemplates}")
	private List<String> learningTemplates;
	

	public List<String> getLearningTemplates() {
		return learningTemplates;
	}

	public void setLearningTemplates(List<String> learningTemplates) {
		this.learningTemplates = learningTemplates;
	}
	
	

	public List<String> complete(String query) {
		List<String> result = new ArrayList<String>();
//		_log.debug("auto-completing");
		Collection<String> tmp = Collections2.filter(learningTemplates, Predicates.containsPattern(query));	
		result.addAll(tmp);
		return result;		
	}
	
	@PostConstruct
	public void init() {
		learningTemplates = new ArrayList<String>();

		Client client = com.sun.jersey.api.client.Client.create();	
		WebResource webResource = client
				.resource(SOAUtil.getRestserverUrl() + "/competences/xml/learningtemplates");	
		StringList result = webResource.accept(MediaType.APPLICATION_XML)
				.get(StringList.class);
		for (String template : result.getData()) {
			learningTemplates.add(template);
		}				
	}


}