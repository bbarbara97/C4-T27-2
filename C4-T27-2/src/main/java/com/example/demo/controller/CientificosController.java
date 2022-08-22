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
import com.example.demo.service.CientificosServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificosController {

	@Autowired
	CientificosServiceImpl cientificosServiceImpl;
	
	@GetMapping("/cientificos")
	public List<Cientificos> listarCientificos(){
		return cientificosServiceImpl.listarCientificos();
	}
	
	
	@PostMapping("/cientificos")
	public Cientificos salvarCientificos(@RequestBody Cientificos cientificos) {
		
		return cientificosServiceImpl.guardarCientificos(cientificos);
	}
	
	
	@GetMapping("/cientificos/{id}")
	public Cientificos CientificosXID(@PathVariable(name="id") int id) {
		
		Cientificos Cientificos_xid= new Cientificos();
		
		Cientificos_xid=cientificosServiceImpl.cientificosXID(id);
		
		System.out.println("Cientificos XID: "+Cientificos_xid);
		
		return Cientificos_xid;
	}
	
	@PutMapping("/cientificos/{id}")
	public Cientificos actualizarCientificos(@PathVariable(name="id")int id,@RequestBody Cientificos Cientificos) {
		
		Cientificos Cientificos_seleccionado= new Cientificos();
		Cientificos Cientificos_actualizado= new Cientificos();
		
		Cientificos_seleccionado= cientificosServiceImpl.cientificosXID(id);
		
		Cientificos_seleccionado.setDni(Cientificos.getDni());
		Cientificos_seleccionado.setNomApels(Cientificos.getNomApels());
		Cientificos_seleccionado.setAsignado(Cientificos.getAsignado());
		
		Cientificos_actualizado = cientificosServiceImpl.actualizarCientificos(Cientificos_seleccionado);
		
		System.out.println("El cientifico actualizado es: "+ Cientificos_actualizado);
		
		return Cientificos_actualizado;
	}
	
	@DeleteMapping("/cientificos/{id}")
	public void eleiminarCientificos(@PathVariable(name="id")int id) {
		cientificosServiceImpl.eliminarCientificos(id);
	}
}
