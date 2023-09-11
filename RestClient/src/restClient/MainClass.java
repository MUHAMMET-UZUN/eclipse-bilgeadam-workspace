package restClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class MainClass {
	private static void main(String[] args) throws Exception {
		HttpClient httpClient = HttpClient.newHttpClient();
		String json = """
				{
						"IS_GICIK": true,
						"NAME": "elif"
				}
				""";
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/JakartaRest/ogretmen/kaydet"))
				.POST(BodyPublishers.ofString(json)).build();
		HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.err.println(httpResponse.body());
		// --------------------- //
		httpRequest = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/JakartaRest/ogretmen/getall"))
				.GET().build();
		httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.err.println(httpResponse.body());
		// jackson-databind kullanılırsa
		// ObjectMapper mapper = new ObjectMapper();
		// Ogretmen ogr = mapper.readValue(httpResponse.body(), Ogretmen.class);
	}
}
