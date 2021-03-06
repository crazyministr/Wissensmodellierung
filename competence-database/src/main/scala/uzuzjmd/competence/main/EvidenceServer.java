package uzuzjmd.competence.main;

import java.io.IOException;

import javax.xml.ws.Endpoint;

import uzuzjmd.competence.evidence.service.EvidenceService;
import uzuzjmd.competence.evidence.service.LiferayEvidenceRestServiceImpl;
import uzuzjmd.competence.evidence.service.MoodleEvidenceRestServiceImpl;
import uzuzjmd.competence.evidence.service.rest.EvidenceServiceRestServerImpl;
import uzuzjmd.competence.evidence.service.rest.dto.ActivityEntry;
import uzuzjmd.competence.evidence.service.rest.dto.ActivityTyp;
import uzuzjmd.competence.evidence.service.rest.dto.UserTree;
import uzuzjmd.competence.owl.access.MagicStrings;
import uzuzjmd.competence.service.rest.ResponseCorsFilter;
import uzuzjmd.competence.view.xml.AbstractTreeEntry;
import uzuzjmd.competence.view.xml.AbstractXMLTree;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class EvidenceServer {

	public static void main(String[] args) throws IllegalArgumentException, NullPointerException, IOException {

		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Log4JLogger");
		System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");

		if (args.length == 3) {
			String liferayAdminName = args[0];
			String liferayAdminPassword = args[1];
			String liferayUrl = args[2];
			EvidenceService evidenceServiceImpl = new LiferayEvidenceRestServiceImpl(liferayAdminName, liferayAdminPassword, liferayUrl);
			publishServer(evidenceServiceImpl);
		} else if (args.length != 5 && args.length != 7) {
			System.out.println("Die Verwendung lautet java -jar EvidenceServerJar moodlename moodledb adminname adminpassword [adminlogin adminloginpassword] moodleurl"
					+ " \n oder liferayadminuser liferayadminpassword liferayurl (z.b. test test http://localhost:8080)");
		} else {
			String moodleurl = args[0];
			String moodledb = args[1];
			String adminname = args[2];
			String adminpassword = args[3];
			MagicStrings.MOODLEURL = args[args.length - 1];
			if (args.length == 7) {
				String adminlogin = args[4];
				String adminloginpassword = args[5];
				startServer(moodleurl, moodledb, adminname, adminpassword, adminlogin, adminloginpassword);
			} else {
				startServer(moodleurl, moodledb, adminname, adminpassword);
			}
		}

	}

	private static void startServer(String moodleurl, String moodledb, String adminname, String adminpassword, String adminlogin, String adminloginpassword) throws IOException {
		MoodleEvidenceRestServiceImpl evidenceServiceImpl = new MoodleEvidenceRestServiceImpl(moodleurl, moodledb, adminname, adminpassword, adminlogin, adminloginpassword);
		publishServer(evidenceServiceImpl);
	}

	private static void startServer(String moodleurl, String moodledb, String adminname, String adminpassword) throws IllegalArgumentException, NullPointerException, IOException {
		// start server
		final MoodleEvidenceRestServiceImpl evidenceServiceImpl = new MoodleEvidenceRestServiceImpl(moodleurl, moodledb, adminname, adminpassword);
		publishServer(evidenceServiceImpl);

	}

	private static void publishServer(final EvidenceService evidenceServiceImpl) throws IOException {
		EvidenceServiceRestServerImpl.evidenceService = evidenceServiceImpl;

		publishSoapServer(evidenceServiceImpl);
		publishRestServer();

		System.out.println("Press enter to exit");
		System.in.read();

		System.exit(1);
	}

	private static void publishRestServer() throws IOException {
		ResourceConfig resourceConfig = new DefaultResourceConfig(EvidenceServiceRestServerImpl.class, UserTree.class, AbstractTreeEntry.class, AbstractXMLTree.class, ActivityTyp.class,
				ActivityEntry.class);
		resourceConfig.getContainerResponseFilters().add(ResponseCorsFilter.class);
		GrizzlyServerFactory.createHttpServer(MagicStrings.RESTURL, resourceConfig);
		System.out.println("publishing rest server to to " + MagicStrings.RESTURL);
		System.out.println("Test this with2: " + MagicStrings.RESTURL + "/moodle" + "/activities/usertree/xml/{groupId bzw. Kursid}");
	}

	private static void publishSoapServer(final EvidenceService evidenceServiceImpl) {
		Endpoint.publish(MagicStrings.EVIDENCESERVICEENDPOINT, evidenceServiceImpl);
		System.out.println("publishing wsdl to " + MagicStrings.EVIDENCESERVICEENDPOINT);
	}

}
