package com.dromedicas.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dromedicas.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext(name="PuntosFPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllUsuarios() {
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@Override
	public Usuario obtenerUsuarioById(Usuario instance) {
		return em.find(Usuario.class, instance.getIdusuario());
	}

	@Override
	public void insertUsuario(Usuario instance) {
		em.persist(instance);

	}

	@Override
	public void updateUsuario(Usuario instance) {
		em.merge(instance);

	}

	@Override
	public void deleteUsuario(Usuario instance) {
		em.merge(instance);
		em.remove(instance);

	}

}
