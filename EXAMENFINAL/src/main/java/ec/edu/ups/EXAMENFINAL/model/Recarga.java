package ec.edu.ups.EXAMENFINAL.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recarga {

	@Id
    private int id;
    private String numeroTelefono;
    private String operador;
    private double monto;
    private Date fechaEmision;
    
    

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	@Override
	public String toString() {
		return "Recarga [id=" + id + ", numeroTelefono=" + numeroTelefono + ", operador=" + operador + ", monto="
				+ monto +"]";
	}
	
    
    
    
}