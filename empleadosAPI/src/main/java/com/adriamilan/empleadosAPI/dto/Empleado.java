package com.adriamilan.empleadosAPI.dto;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {
	
	// Atributos de la entidad Empleado
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="trabajo")
	private String trabajo;
	
	@Column(name="salario")
	private Double salario;
	
	// Constructores
	
	public Empleado() {}

	public Empleado(String trabajo) {
		super();
		
		Hashtable<String, Double> trabajos = iniTrabajos();
		this.trabajo = trabajo;
		this.salario = trabajos.get(trabajo);
	}
	
	public Empleado(String nombre, String apellido, String trabajo) {
		super();
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.trabajo = trabajo;
	}
	
	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param trabajo
	 * @param salario
	 */
	public Empleado(Long id, String nombre, String apellido, String trabajo, Double salario) {
		super();

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.trabajo = trabajo;
		this.salario = salario;
	}

	// Getters & Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Hashtable<String, Double> iniTrabajos() {
		
		Hashtable<String, Double> trabajos = new Hashtable<String, Double>();
		trabajos.put("Software Engineer", 54000.00);
		trabajos.put("Backend Developer", 32000.00);
		trabajos.put("Frontend Developer", 31000.00);
		trabajos.put("Marketing", 28000.00);
		trabajos.put("SEO", 27000.00);
		return trabajos;
	}
	
}
