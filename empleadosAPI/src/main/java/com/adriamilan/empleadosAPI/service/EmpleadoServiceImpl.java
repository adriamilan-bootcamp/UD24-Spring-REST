package com.adriamilan.empleadosAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriamilan.empleadosAPI.dao.EmpleadoDaoIface;
import com.adriamilan.empleadosAPI.dto.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoServiceIface {

	@Autowired
	EmpleadoDaoIface empleadoDaoIface;

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		return empleadoDaoIface.save(empleado);
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return empleadoDaoIface.findAll();
	}

	@Override
	public Empleado empleadoXID(Long id) {
		return empleadoDaoIface.findById(id).get();
	}

	@Override
	public List<Empleado> findByNombre(String nombre) {
		return empleadoDaoIface.findByNombre(nombre);
	}

	@Override
	public List<Empleado> findByApellido(String apellido) {
		return empleadoDaoIface.findByApellido(apellido);
	}

	@Override
	public List<Empleado> findByTrabajo(String trabajo) {
		return empleadoDaoIface.findByTrabajo(trabajo);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return empleadoDaoIface.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		empleadoDaoIface.deleteById(id);
	}
	
}
