package controller;

import com.bilgeadam.jdbc.model.DersOgrenci;
import com.bilgeadam.jdbc.repository.DersOgrenciRepository;
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


@Path(value = "ders_ogrenci")
public class DersOgrenciController {
    private final DersOgrenciRepository dersOgrenciRepository = new DersOgrenciRepository();

    @POST
    @Path(value = "kaydet")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response kaydet(DersOgrenci dersOgrenci) throws Exception
    {
        if (dersOgrenciRepository.insert(dersOgrenci.getDERS_ID(),dersOgrenci.getOGR_ID(),dersOgrenci.getDEVAMSIZLIK(),
                dersOgrenci.getNOTE()))
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
        // localhost:8080/JakartaRest/ders_ogrenci/deletebyid?id=2
        boolean ret = dersOgrenciRepository.deleteById(id);
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
    public LinkedList<DersOgrenci> getall() throws Exception
    {
        // localhost:8080/JakartaRest/ders_ogrenci/getall

        return dersOgrenciRepository.selectAll();
    }

    @GET
    @Path(value = "getbyid/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public DersOgrenci getbyidpath(@PathParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ders_ogrenci/getbyid/1
        return dersOgrenciRepository.selectById(id);
    }

    @GET
    @Path(value = "getbyid")
    @Produces(value = MediaType.APPLICATION_JSON)
    public DersOgrenci getbyid(@QueryParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ders_ogrenci/getbyid?id=1

        return dersOgrenciRepository.selectById(id);
    }

    @GET
    @Path(value = "getbyidwithheader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public DersOgrenci getbyidwithheader(@HeaderParam(value = "id") Long id) throws Exception
    {
        // localhost:8080/JakartaRest/ders_ogrenci/getbyidwithheader

        return  dersOgrenciRepository.selectById(id);
    }
}
