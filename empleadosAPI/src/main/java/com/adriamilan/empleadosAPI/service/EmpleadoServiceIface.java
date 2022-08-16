package com.adriamilan.empleadosAPI.service;

import java.util.List;

import com.adriamilan.empleadosAPI.dto.Empleado;

public interface EmpleadoServiceIface {

	// Crud Methods
	
	public Empleado guardarEmpleado(Empleado empleado);
	
	public List<Empleado> listarEmpleados();
	
	public Empleado empleadoXID(Long id);
	
	public List<Empleado> findByNombre(String nombre);
	
	public List<Empleado> findByApellido(String apellido);
	
	public List<Empleado> findByTrabajo(String trabajo);

	public Empleado actualizarEmpleado(Empleado empleado);
	
	public void eliminarEmpleado(Long id);
	
}
