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

import com.example.demo.dto.Asignado;
import com.example.demo.service.AsignadoServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoController {

	@Autowired
	AsignadoServiceImpl asignadoServiceImpl;
	
	@GetMapping("/asignado")
	public List<Asignado> listarAsignado(){
		return asignadoServiceImpl.listarAsignado();
	}
	
	
	@PostMapping("/asignado")
	public Asignado salvarAsignado(@RequestBody Asignado asignado) {
		
		return asignadoServiceImpl.guardarAsignado(asignado);
	}
	
	
	@GetMapping("/asignado/{id}")
	public Asignado AsignadoXID(@PathVariable(name="id") int id) {
		
		Asignado Asignado_xid= new Asignado();
		
		Asignado_xid=asignadoServiceImpl.asignadoXID(id);
		
		System.out.println("Asignado XID: "+Asignado_xid);
		
		return Asignado_xid;
	}
	
	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name="id")int id,@RequestBody Asignado asignado) {
		
		Asignado Asignado_seleccionado= new Asignado();
		Asignado Asignado_actualizado= new Asignado();
		
		Asignado_seleccionado= asignadoServiceImpl.asignadoXID(id);
		
		
		Asignado_seleccionado.setCientificos(asignado.getCientificos());
		Asignado_seleccionado.setProyecto(asignado.getProyecto());
		
		Asignado_actualizado = asignadoServiceImpl.actualizarAsignado(Asignado_seleccionado);
		
		System.out.println("El asignado actualizado es: "+ Asignado_actualizado);
		
		return Asignado_actualizado;
	}
	
	@DeleteMapping("/asignado/{id}")
	public void eleiminarAsignado(@PathVariable(name="id")int id) {
		asignadoServiceImpl.eliminarAsignado(id);
	}
}
