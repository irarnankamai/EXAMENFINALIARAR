package ec.edu.ups.EXAMENFINAL.negocio;

import java.util.List;

import ec.edu.ups.EXAMENFINAL.dao.RecargaDao;
import ec.edu.ups.EXAMENFINAL.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class GestionRecarga {

    @Inject
    private RecargaDao recargaDao;

    public String procesarRecarga(Recarga recarga) {
        if (validarRecarga(recarga)) {
            boolean transaccionExitosa = simulacionTransaccion(recarga);

            if (transaccionExitosa) {
                try {
                    recargaDao.insert(recarga);
                    return "Recarga exitosa";
                } catch (Exception e) {
                    return "Error al almacenar la recarga";
                }
            } else {
                return "La transacción de recarga ha fallado";
            }
        } else {
            return "Datos de recarga no válidos";
        }
    }

    public List<Recarga> obtenerTodasLasRecargas() {
        try {
            return recargaDao.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public String actualizarRecarga(Recarga recarga) {
        Recarga recargaExistente = recargaDao.read(recarga.getId());
        
        if (recargaExistente != null) {
            recargaDao.update(recarga);
            return "Recarga actualizada";
        } else {
            return "La recarga no existe";
        }
    }

    public String eliminarRecarga(int id) {
        Recarga recargaExistente = recargaDao.read(id);

        if (recargaExistente != null) {
            recargaDao.remove(id);
            return "Recarga eliminada";
        } else {
            return "La recarga no existe";
        }
    }

    private boolean validarRecarga(Recarga recarga) {
        return recarga.getNumeroTelefono() != null && !recarga.getNumeroTelefono().isEmpty()
                && recarga.getOperador() != null && !recarga.getOperador().isEmpty()
                && recarga.getMonto() > 0;
    }

    private boolean simulacionTransaccion(Recarga recarga) {
        return Math.random() < 0.8;
    }
}