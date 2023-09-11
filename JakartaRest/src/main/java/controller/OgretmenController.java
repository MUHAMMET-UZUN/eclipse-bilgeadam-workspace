package controller;

import java.util.LinkedList;

import com.bilgeadam.jdbc.model.Ogretmen;
import com.bilgeadam.jdbc.repository.OgretmenRepository;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

// localhost:9090/JakartaRest/ogretmen
@Stateless
@Path(value = "ogretmen")
public class OgretmenController {

	private final OgretmenRepository ogretmenRepository = new OgretmenRepository();

	@POST
	@Path(value = "kaydet")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response kaydet(Ogretmen ogr) throws Exception {

		System.out.println(ogr);
//		 ogr değişkeni request body sinden gelir
		if (ogretmenRepository.insert(ogr.getNAME(), ogr.isIS_GICIK())) {
			return Response.ok("Başarı ile kaydedildi").build();
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Kaydedilemedi").build();
		}
	}

	@DELETE
	@Path(value = "deletebyid")
	public Response deletebyid(@QueryParam(value = "id") Long id) throws Exception {
		// localhost:8080/JakartaRest/ogretmen/deletebyid?id=2
		boolean ret = ogretmenRepository.deleteById(id);
		if (ret) {
			return Response.ok("Başarı ile silindi").build();
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Silinemedi").build();
		}
	}

	@GET
	@Path(value = "getall")
	@Produces(value = MediaType.APPLICATION_JSON)
	public LinkedList<Ogretmen> getall() throws Exception {
		// localhost:8080/JakartaRest/ogretmen/getall
		LinkedList<Ogretmen> list = ogretmenRepository.selectAll();
		return list;
	}

	@GET
	@Path(value = "getbyid/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Ogretmen getbyidpath(@PathParam(value = "id") Long id) throws Exception {
		// localhost:8080/JakartaRest/ogretmen/getbyid/1
		Ogretmen ogretmen = ogretmenRepository.selectById(id);
		return ogretmen;
	}

	@GET
	@Path(value = "getbyid")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Ogretmen getbyid(@QueryParam(value = "id") Long id) throws Exception {
		// localhost:8080/JakartaRest/ogretmen/getbyid?id=1
		Ogretmen ogretmen = ogretmenRepository.selectById(id);
		return ogretmen;
	}

	@GET
	@Path(value = "getbyidwithheader")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Ogretmen getbyidwithheader(@HeaderParam(value = "id") Long id) throws Exception {
		// localhost:8080/JakartaRest/ogretmen/getbyidwithheader
		Ogretmen ogretmen = ogretmenRepository.selectById(id);
		return ogretmen;
	}
}