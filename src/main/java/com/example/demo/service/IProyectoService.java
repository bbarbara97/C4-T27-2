package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;

public interface IProyectoService {

	//Metodos del CRUD
			public List<Proyecto> listarProyecto(); //Listar All 
			
			public Proyecto guardarProyecto(Proyecto proyecto);	//Guarda un Estudiante CREATE
			
			public Proyecto proyectoXID(int id); //Leer datos de un Estudiante READ
			
			public Proyecto actualizarProyecto(Proyecto proyecto); //Actualiza datos del estudiante UPDATE
			
			public void eliminarProyecto(int id);// Elimina el estudiante DELETE
}
