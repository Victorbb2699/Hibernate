package Test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import Entitys.*;
import HibernateUtil.HibernateUtil;

public class Pruebas {
	public static void main(String[] args) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		
		Query q = sesion.createQuery("");
		List<Residencias> a = q.getResultList();
		
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i).getCodResidencia());
			System.out.println(a.get(i).getNomResidencia());
			System.out.println(a.get(i).getCodUniversidad());
			System.out.println(a.get(i).getPrecioMensual());
			
			
			
		}

		
		
		/*	insert residencias
			
			res.setCodResidencia(1);
			res.setCodUniversidad("Ull");
			res.setNomResidencia("res");
			res.setComedor(true);
			res.setPrecioMensual(900);
			
			sesion.save(res);
			sesion.getTransaction().commit();
			*/
			
			
		/*	delete residencias
		 * sesion.delete(res);
			sesion.flush();
		 */
			
			
			/*update residencias
			 * 
			 * 
			 * */
		
		
	}

}
