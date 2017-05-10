package com.dromedicas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.dromedicas.domain.Tipodocumento;

public class Test {
	
	static EntityManager em = null;
	static EntityTransaction tx = null;
	static EntityManagerFactory emf = null;
	
	
	public static void main(String[] args) {

		try {
			Logger log = Logger.getLogger("TestPuntosFarmanorte");

			log.debug("Preparando contexto de persistencia");
			
			emf = Persistence.createEntityManagerFactory("PuntosFPU");
			
			em = emf.createEntityManager();

			log.debug("Iniciando test Persona Entity con JPA");
			EntityTransaction tx = em.getTransaction();

			tx.begin();

			Tipodocumento tp = new Tipodocumento();
			tp.setDescripcion("Cedula de Extranjería");

			log.debug("Objeto a persistir: " + tp);

			em.persist(tp);
			
			tx.commit();

			log.debug("Objeto persistido: " + tp);

			log.debug("Fin test Persona Entity con JPA");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
