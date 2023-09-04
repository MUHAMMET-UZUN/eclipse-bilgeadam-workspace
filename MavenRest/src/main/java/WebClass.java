import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path(value = "/")
public class WebClass {

	@GET
	@Path("hello")
	public String WebMethod() {
		return "hello javaee";
	}
}
