package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="proyectos")//en caso que la tabla sea diferente
public class Proyecto {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int id;
		@Column(name = "nombre")//no hace falta si se llama igual
		private String nombre;
		
		@OneToMany
	    @JoinColumn(name="id")
	    private List<Asignado> asignado;
		
		@Column(name = "horas")//no hace falta si se llama igual
		private int horas;

		//Constructores
		
		public Proyecto() {

		}

		public Proyecto(int id, String nombre, List<Asignado> asignado, int horas) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.asignado = asignado;
			this.horas = horas;
		}

		//Getters y Setters
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado")
		public List<Asignado> getAsignado() {
			return asignado;
		}

		public void setAsignado(List<Asignado> asignado) {
			this.asignado = asignado;
		}

		public int getHoras() {
			return horas;
		}

		public void setHoras(int horas) {
			this.horas = horas;
		}	

		//Metodo toString
		
		@Override
		public String toString() {
			return "Proyecto [id=" + id + ", nombre=" + nombre + ", asignado=" + asignado + ", horas=" + horas + "]";
		}	
		
}
