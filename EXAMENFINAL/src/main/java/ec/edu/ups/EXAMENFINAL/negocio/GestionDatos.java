package ec.edu.ups.EXAMENFINAL.negocio;

import java.util.Date;

import ec.edu.ups.EXAMENFINAL.dao.RecargaDao;
import ec.edu.ups.EXAMENFINAL.model.Recarga;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;


@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private RecargaDao daoRecarga;
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando");

		Recarga recarga1 = new Recarga();
		recarga1.setId(1);
		recarga1.setNumeroTelefono("0991234567");
		recarga1.setOperador("Movistar");
		recarga1.setMonto(10.0);
		daoRecarga.insert(recarga1);


		System.out.println("Datos de prueba ingresados");
	}
}