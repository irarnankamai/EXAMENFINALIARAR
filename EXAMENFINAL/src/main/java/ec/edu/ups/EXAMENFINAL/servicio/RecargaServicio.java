package ec.edu.ups.EXAMENFINAL.servicio;

import java.util.List;

import ec.edu.ups.EXAMENFINAL.model.Recarga;
import ec.edu.ups.EXAMENFINAL.negocio.GestionRecarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/recargas")
public class RecargaServicio {

    @Inject
    private GestionRecarga gestionRecarga;

    @POST
    @Path("/procesar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String procesarRecarga(Recarga recarga) {
        return gestionRecarga.procesarRecarga(recarga);
    }

    @GET
    @Path("/obtenerTodas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recarga> obtenerTodasLasRecargas() {
        return gestionRecarga.obtenerTodasLasRecargas();
    }

    @PUT
    @Path("/actualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String actualizarRecarga(Recarga recarga) {
        return "{\"mensaje\":\"" + gestionRecarga.actualizarRecarga(recarga) + "\"}";
    }

    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String eliminarRecarga(@PathParam("id") int id) {
        return "{\"mensaje\":\"" + gestionRecarga.eliminarRecarga(id) + "\"}";
    }
}