package interfaces;

import java.util.ArrayList;

import model.Expediente;

public interface ExpedienteInterface {

	// los métodos de mantenimiento
	// Registrar los datos del libro
	public int registrar(Expediente ex);
	
	
	// método para lista el contenido de las tablas
	public ArrayList<Expediente> listado();
	
	// método para lista el contenido de las tablas (expedientes revisados)
	public ArrayList<Expediente> listado(String situacion);

}
