package controller;


import com.bilgeadam.jdbc.model.Ogrenci;
import com.bilgeadam.jdbc.repository.OgrenciRepository;
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

@Path(value = "ogrenci")
public class OgrenciController {

    private final OgrenciRepository ogrenciRepository = new OgrenciRepository();


    @POST
    @Path(value = "kaydet")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response kaydet(Ogrenci ogr) throws Exception
    {

        if (ogrenciRepository.insert(ogr.getNAME(),ogr.getOGR_NUMBER(), ogr.getYEAR()))
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
        // localhost:8080/JakartaRest/ogrenci/deletebyid?id=2
        boolean ret = ogrenciRepository.deleteById(id);
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
    public LinkedList<Ogrenci> getall() throws Exception
    {
        // localhost:8080/JakartaRest/ogrenci/getall

        return ogrenciRepository.selectAll();
    }

    @GET
    @Path(value = "getbyid/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getbyidpath(@PathParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ogrenci/getbyid/1

        return ogrenciRepository.selectById(id);
    }

    @GET
    @Path(value = "getbyid")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getbyid(@QueryParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ogrenci/getbyid?id=1

        return ogrenciRepository.selectById(id);
    }

    @GET
    @Path(value = "getbyidwithheader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getbyidwithheader(@HeaderParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ogrenci/getbyidwithheader
        return ogrenciRepository.selectById(id);
    }
}
