package controller;


import com.bilgeadam.jdbc.model.Ders;
import com.bilgeadam.jdbc.repository.DersRepository;
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
import java.util.LinkedList;

@Path(value = "ders")
public class DersController {
    private final DersRepository dersRepository = new DersRepository();
    @POST
    @Path(value = "kaydet")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response kaydet(Ders ders) throws Exception
    {
        if (dersRepository.insert(ders.getOGR_ID(), ders.getKONU_ID()))
        {
            return Response.ok("Başarı ile kaydedildi").build();
        }
        else
        {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Kaydedilemedi").build();
        }
    }

    @DELETE
    @Path(value = "deletebyid")
    public Response deletebyid(@QueryParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ders/deletebyid?id=2
        boolean ret = dersRepository.deleteById(id);
        if (ret)
        {
            return Response.ok("Başarı ile silindi").build();
        }
        else
        {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Silinemedi").build();
        }
    }

    @GET
    @Path(value = "getall")
    @Produces(value = MediaType.APPLICATION_JSON)
    public LinkedList<Ders> getall() throws Exception
    {
        // localhost:8080/JakartaRest/ders/getall
        return dersRepository.selectAll();
    }

    @GET
    @Path(value = "getbyid/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getbyidpath(@PathParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ders/getbyid/1
        return dersRepository.selectById(id);
    }

    @GET
    @Path(value = "getbyid")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getbyid(@QueryParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ders/getbyid?id=1

        return dersRepository.selectById(id);
    }

    @GET
    @Path(value = "getbyidwithheader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getbyidwithheader(@HeaderParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ders/getbyidwithheader

        return  dersRepository.selectById(id);
    }

}
