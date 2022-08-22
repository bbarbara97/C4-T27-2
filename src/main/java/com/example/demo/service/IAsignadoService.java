package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Asignado;

public interface IAsignadoService {

	//Metodos del CRUD
			public List<Asignado> listarAsignado(); //Listar All 
			
			public Asignado guardarAsignado(Asignado asignado);	//Guarda un RegistroCurso CREATE
			
			public Asignado asignadoXID(int id); //Leer datos de un RegistroCurso READ
			
			public Asignado actualizarAsignado(Asignado asignado); //Actualiza datos del RegistroCurso UPDATE
			
			public void eliminarAsignado(int id);// Elimina el RegistroCurso DELETE
}
