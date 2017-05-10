package com.dromedicas.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dromedicas.domain.Condicionservicio;

@Stateless
public class CondicionservicioDaoImpl implements CondicionservicioDao {
	
	@PersistenceContext(name="PuntosFPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Condicionservicio> findAllCondicionservicios() {
		return em.createNamedQuery("Condicionservicio.findAll").getResultList();
	}

	@Override
	public Condicionservicio obtenerCondicionservicioById(Condicionservicio instance) {
		 return em.find(Condicionservicio.class, instance.getIdcondicioneservicio());
	}

	
	@Override
	public void insertCondicionservicio(Condicionservicio instance) {
		em.persist(instance);

	}

	@Override
	public void updateCondicionservicio(Condicionservicio instance) {
		em.merge(instance);

	}

	@Override
	public void deleteCondicionservicio(Condicionservicio instance) {
		em.merge(instance);
		em.remove(instance);

	}

}
