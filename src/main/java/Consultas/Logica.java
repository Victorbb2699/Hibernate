package Consultas;

import org.hibernate.Session;

import Entitys.Residencias;

public class Logica {
	
	public void EliminarResidencia(Session sesion) {
		
		Residencias residencias = new Residencias();
		sesion.beginTransaction();
	}

}
