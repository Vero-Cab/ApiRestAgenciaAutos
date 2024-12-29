package com.mx.ApiRestAgenciaAutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestAgenciaAutos.model.Modelos;
import com.mx.ApiRestAgenciaAutos.service.ModelosServImp;

@RestController
@RequestMapping(path = "ModelosWs")
@CrossOrigin

public class ModelosWs {
@Autowired
ModelosServImp modeloImp;

//http://localhost:9000/ModelosWs/listar
@GetMapping(path = "listar")
public List<Modelos> listar(){
	return modeloImp.listar();
}

//http://localhost:9000/ModelosWs/guardar
@PostMapping(path = "guardar")
public ResponseEntity<?> guardar(@RequestBody Modelos modelo) {
	boolean response = modeloImp.guardar(modelo);
	if(response == true)
		return new ResponseEntity<>("El Id y nombre ya se encuentran registrados", HttpStatus.OK);
else 
	return new ResponseEntity<>(modelo, HttpStatus.CREATED);		
}

//http://localhost:9000/ModelosWs/buscar
	@PostMapping(path = "buscar")
	public Modelos buscar(@RequestBody Modelos modelo) {
		return modeloImp.buscar(modelo.getIdMod());
	}
	//http://localhost:9000/ModelosWs/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Modelos modelo){
		boolean response = modeloImp.editar(modelo);
		if(response == true)
			return new ResponseEntity<>(modelo,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("El Id no existe, ingrese otro", HttpStatus.OK);
	}
	//http://localhost:9000/ModelosWs/eliminar
	@PostMapping(path = "eliminar")
			public ResponseEntity<?> eliminar(@RequestBody Modelos modelo){
		boolean response = modeloImp.eliminar(modelo);
		if(response ==true)
			return new ResponseEntity<>(modelo, HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Id no existe para Eliminar, ingresa otro", HttpStatus.OK);
	}
	
	
	}
