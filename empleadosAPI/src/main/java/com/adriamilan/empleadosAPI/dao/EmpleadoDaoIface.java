package com.adriamilan.empleadosAPI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adriamilan.empleadosAPI.dto.Empleado;

public interface EmpleadoDaoIface extends JpaRepository<Empleado, Long> {

	public List<Empleado> findByNombre(String nombre);
	
	public List<Empleado> findByApellido(String apellido);
	
	public List<Empleado> findByTrabajo(String trabajo);
	
}
