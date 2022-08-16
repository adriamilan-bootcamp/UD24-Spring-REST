package com.adriamilan.empleadosAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adriamilan.empleadosAPI.dto.Empleado;
import com.adriamilan.empleadosAPI.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return empleadoServiceImpl.listarEmpleados();
	}
	
	@GetMapping("/empleados/{id}")
	public Empleado empleadoXID(@PathVariable(name="id") Long id) {
		return empleadoServiceImpl.empleadoXID(id);
	}
	
	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleado> findByNombre(@PathVariable(name="nombre") String nombre) {
		return empleadoServiceImpl.findByNombre(nombre);
	}
	
	@GetMapping("/empleados/apellido/{apellido}")
	public List<Empleado> findByApellido(@PathVariable(name="apellido") String apellido) {
		return empleadoServiceImpl.findByApellido(apellido);
	}
	
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleado> findByTrabajo(@PathVariable(name="trabajo") String trabajo) {
		return empleadoServiceImpl.findByTrabajo(trabajo);
	}
	
	@PostMapping("/empleado")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		Empleado empleadoAsalariado = new Empleado(empleado.getTrabajo());
		empleado.setSalario(empleadoAsalariado.getSalario());
		return empleadoServiceImpl.guardarEmpleado(empleado);
	}
	
	@PutMapping("/empleado/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id") Long id, @RequestBody Empleado empleado) {
		Empleado empleado_seleccionado = new Empleado();
		Empleado empleado_actualizado = new Empleado();
		Empleado empleado_asalariado = new Empleado(empleado.getTrabajo());
		
		empleado_seleccionado = empleadoServiceImpl.empleadoXID(id);
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellido(empleado.getApellido());
		empleado_seleccionado.setTrabajo(empleado.getTrabajo());
		empleado_seleccionado.setSalario(empleado_asalariado.getSalario());
		
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		return empleado_actualizado;
	}
	
	@DeleteMapping("/empleado/{id}")
	public void eliminarEmpleado(@PathVariable(name="id") Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}
	
}
