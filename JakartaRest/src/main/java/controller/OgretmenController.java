package controller;

import java.util.LinkedList;

import com.bilgeadam.jdbc.model.Ogretmen;
import com.bilgeadam.jdbc.repository.OgretmenRepository;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Stateless // bu uygulama için olmasa da sorun olmaz
@Path(value = "ogretmen")
// localhost:9090/JakartaRest/ogretmen
public class OgretmenController
{
	private OgretmenRepository ogretmenRepository = new OgretmenRepository();

	@GET
	@Path(value = "getall")
	@Produces(value = MediaType.APPLICATION_JSON)
	public LinkedList<Ogretmen> getall() throws Exception
	{
		// localhost:9090/JakartaRest/ogretmen/getall
		LinkedList<Ogretmen> list = ogretmenRepository.selectAll();
		return list;
	}

	@GET
	@Path(value = "getbyid/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Ogretmen getbyidpath(@PathParam(value = "id") Long id) throws Exception
	{
		// localhost:9090/JakartaRest/ogretmen/getbyid/1
		Ogretmen ogretmen = ogretmenRepository.selectById(id);
		return ogretmen;
	}

	@GET
	@Path(value = "getbyid")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Ogretmen getbyid(@QueryParam(value = "id") Long id) throws Exception
	{
		// localhost:9090/JakartaRest/ogretmen/getbyid?id=1
		Ogretmen ogretmen = ogretmenRepository.selectById(id);
		return ogretmen;
	}

	@GET
	@Path(value = "getbyidwithheader")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Ogretmen getbyidwithheader(@HeaderParam(value = "id") Long id) throws Exception
	{
		// localhost:9090/JakartaRest/ogretmen/getbyidwithheader
		Ogretmen ogretmen = ogretmenRepository.selectById(id);
		return ogretmen;
	}
}