package controller;


import com.bilgeadam.jdbc.model.Konu;
import com.bilgeadam.jdbc.repository.KonuRepository;
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

@Path(value = "konu")
public class KonuController {
    private final KonuRepository konuRepository = new KonuRepository();

    @POST
    @Path(value = "kaydet")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response kaydet(Konu konu) throws Exception
    {
        if (konuRepository.insert(konu.getNAME()))
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
        // localhost:8080/JakartaRest/konu/deletebyid?id=2
        boolean ret = konuRepository.deleteById(id);
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
    public LinkedList<Konu> getall() throws Exception
    {
        // localhost:8080/JakartaRest/konu/getall
        return konuRepository.selectAll();
    }

    @GET
    @Path(value = "getbyid/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getbyidpath(@PathParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/konu/getbyid/1
        return konuRepository.selectById(id);
    }

    @GET
    @Path(value = "getbyid")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getbyid(@QueryParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/konu/getbyid?id=1

        return konuRepository.selectById(id);
    }

    @GET
    @Path(value = "getbyidwithheader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getbyidwithheader(@HeaderParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/konu/getbyidwithheader

        return  konuRepository.selectById(id);
    }

}
