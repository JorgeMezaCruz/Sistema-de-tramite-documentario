package interfaces;

import java.util.ArrayList;

import model.Expediente;

public interface ExpedienteInterface {

	// los m�todos de mantenimiento
	// Registrar los datos del libro
	public int registrar(Expediente ex);
	
	
	// m�todo para lista el contenido de las tablas
	public ArrayList<Expediente> listado();
	
	// m�todo para lista el contenido de las tablas (expedientes revisados)
	public ArrayList<Expediente> listado(String situacion);

}
