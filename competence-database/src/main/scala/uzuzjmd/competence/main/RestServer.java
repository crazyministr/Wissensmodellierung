package uzuzjmd.competence.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import uzuzjmd.competence.service.rest.CompetenceServiceRest;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class RestServer {

	final static String url = "http://localhost:8080/jersey";

	public static void main(String[] args) throws IllegalArgumentException,
			NullPointerException, IOException {

		final Map<String, String> params = new HashMap<String, String>();

		// ResourceConfig rc = new PackagesResourceConfig(
		// "de.unipotsdam.service.rest");
		// rc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
		// Boolean.TRUE);

		// ObjectMapper mapper = new ObjectMapper();
		// JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		// provider.setMapper(mapper);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					ResourceConfig config = new DefaultResourceConfig(
							CompetenceServiceRest.class);
					GrizzlyServerFactory.createHttpServer(RestServer.url);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();

		System.out.println("Press enter to exit");
		System.in.read();
	}

}