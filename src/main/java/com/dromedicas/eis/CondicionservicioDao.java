package com.dromedicas.eis;

import java.util.List;

import com.dromedicas.domain.Condicionservicio;

public interface CondicionservicioDao {
	
	public List<Condicionservicio> findAllCondicionservicios();
	
	public Condicionservicio obtenerCondicionservicioById(Condicionservicio instance);
	
	public void insertCondicionservicio(Condicionservicio instance);
	
	public void updateCondicionservicio(Condicionservicio instance);
	
	public void deleteCondicionservicio(Condicionservicio instance);
	

}
