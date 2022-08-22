package com.example.demo.controller;

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

import com.example.demo.dto.Cientificos;
import com.example.demo.dto.Proyecto;
import com.example.demo.service.CientificosServiceImpl;
import com.example.demo.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
	
	@GetMapping("/proyecto")
	public List<Proyecto> listarProyecto(){
		return proyectoServiceImpl.listarProyecto();
	}
	
	
	@PostMapping("/proyecto")
	public Proyecto salvarProyecto(@RequestBody Proyecto proyecto) {
		
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
	
	
	@GetMapping("/proyecto/{id}")
	public Proyecto ProyectoXID(@PathVariable(name="id") int id) {
		
		Proyecto Proyecto_xid= new Proyecto();
		
		Proyecto_xid=proyectoServiceImpl.proyectoXID(id);
		
		System.out.println("Proyecto XID: "+Proyecto_xid);
		
		return Proyecto_xid;
	}
	
	@PutMapping("/proyecto/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")int id,@RequestBody Proyecto Proyecto) {
		
		Proyecto Proyecto_seleccionado= new Proyecto();
		Proyecto Proyecto_actualizado= new Proyecto();
		
		Proyecto_seleccionado= proyectoServiceImpl.proyectoXID(id);
		
		Proyecto_seleccionado.setNombre(Proyecto.getNombre());
		Proyecto_seleccionado.setAsignado(Proyecto.getAsignado());
		Proyecto_seleccionado.setHoras(Proyecto.getHoras());
		
		Proyecto_actualizado = proyectoServiceImpl.actualizarProyecto(Proyecto_seleccionado);
		
		System.out.println("El proveedor actualizado es: "+ Proyecto_actualizado);
		
		return Proyecto_actualizado;
	}
	
	@DeleteMapping("/proyecto/{id}")
	public void eleiminarProyecto(@PathVariable(name="id")int id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}
	
}
