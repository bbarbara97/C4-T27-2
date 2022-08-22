package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientificos;

public interface ICientificosService {

	//Metodos del CRUD
			public List<Cientificos> listarCientificos(); //Listar All 
			
			public Cientificos guardarCientificos(Cientificos cientificos);	//Guarda un Estudiante CREATE
			
			public Cientificos cientificosXID(int id); //Leer datos de un Estudiante READ
			
			public Cientificos actualizarCientificos(Cientificos cientificos); //Actualiza datos del estudiante UPDATE
			
			public void eliminarCientificos(int id);// Elimina el estudiante DELETE
}
