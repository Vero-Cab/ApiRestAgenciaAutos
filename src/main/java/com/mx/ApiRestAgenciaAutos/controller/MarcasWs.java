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


import com.mx.ApiRestAgenciaAutos.model.Marcas;
import com.mx.ApiRestAgenciaAutos.service.MarcasServImp;


@RestController
@RequestMapping (path = "MarcasWs")
@CrossOrigin
public class MarcasWs {
	
	@Autowired
	MarcasServImp marcasImp;
	
	//http://localhost:9000/MarcasWs/listar
	@GetMapping(path ="listar")
	public List<Marcas> listar(){
		return marcasImp.listar();
	}
	// ResponseEntity es para enviar una respuesta del lado del servidor al cliente
	//http://localhost:9000/MarcasWs/guardar
	
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Marcas marca) {
		boolean response = marcasImp.guardar(marca);
		if(response == true)
			return new ResponseEntity<>("El Id y nombre ya se encuentran registrados", HttpStatus.OK);
	else 
		return new ResponseEntity<>(marca, HttpStatus.CREATED);		
	}

	
	//http://localhost:9000/MarcasWs/buscar
	@PostMapping(path = "buscar")
	public Marcas buscar(@RequestBody Marcas marca) {
		return marcasImp.buscar(marca.getIdMar());
	}
	
	//http://localhost:9000/MarcasWs/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Marcas marca){
		boolean response = marcasImp.editar(marca);
		if(response == true)
			return new ResponseEntity<>(marca,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("El IdMar no existe, ingresa otro" ,HttpStatus.OK);

	}
	//http://localhost:9000/MarcasWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Marcas marca) {
		boolean response = marcasImp.eliminar(marca);
		if (response == true)
			return new ResponseEntity<>(marca, HttpStatus.CREATED);
		else

			return new ResponseEntity<>("Id no existe para Eliminar, ingresa otro", HttpStatus.OK);
	}

}
