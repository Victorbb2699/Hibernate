package Consultas;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtil.HibernateUtil;
import clases.Estancias;
import clases.Estudiantes;
import clases.ResidenciaObservacion;
import clases.Residencias;
import clases.Universidades;

public class Logica {

	public static void insertarResidencia(Residencias residencia) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = sesion.beginTransaction();

		sesion.save(residencia);

		transaction.commit();
		sesion.close();

	}

	public static void eliminarResidencia(Residencias residencia) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = sesion.beginTransaction();

		sesion.delete(residencia);

		transaction.commit();
		sesion.close();
	}

	public static void actualizarResidencia(Residencias residencia) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = sesion.beginTransaction();

		sesion.update(residencia);

		transaction.commit();
		sesion.close();

	}

	public static void insertarResidenciasobservacion(ResidenciaObservacion residenciasobservacion) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = sesion.beginTransaction();

		sesion.save(residenciasobservacion);

		transaction.commit();
		sesion.close();

	}

	public static void insertarUniversidad(Universidades universidad) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = sesion.beginTransaction();

		sesion.save(universidad);

		transaction.commit();
		sesion.close();

	}

	public static void insertarEstancia(Estancias estancia) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = sesion.beginTransaction();

		sesion.save(estancia);

		transaction.commit();
		sesion.close();

	}

	public static void insertarEstudiante(Estudiantes estudiante) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = sesion.beginTransaction();

		sesion.save(estudiante);

		transaction.commit();
		sesion.close();
	}

	@SuppressWarnings("unchecked")
	public static List<Residencias> getResidencias() {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = sesion.beginTransaction();

		Query query = sesion.createQuery("from residencias");
		List<Residencias> residencias = query.getResultList();

		transaction.commit();
		sesion.close();

		return residencias;
	}

	public static void visualizarResidenciasEstancias() {

	}
}
