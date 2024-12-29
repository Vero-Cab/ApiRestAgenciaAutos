package com.mx.ApiRestAgenciaAutos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.ApiRestAgenciaAutos.dao.MarcasDao;
import com.mx.ApiRestAgenciaAutos.model.Marcas;

@Service
public class MarcasServImp {

	@Autowired
	MarcasDao marcaDao;

	//MOSTRAR-LISTAR
	public List<Marcas> listar() {
		return marcaDao.findAll();
	}

	// GUARDAR:
	// HACER 2 VALIDACIONES CON EL ID Y NOMBRE QUE NO SE REPITAN
	// GUARDAR:
		// HACER 2 VALIDACIONES CON EL ID Y NOMBRE QUE NO SE REPITAN
		@Transactional
		public boolean guardar(Marcas marca) {
			boolean bandera = false;
			for (Marcas m : marcaDao.findAll()) {
				if(m.getIdMar().equals(marca.getIdMar())|| m.getNombre().equals(marca.getNombre())) {
					
					bandera = true;
					break;
				}
				
				}
			if (bandera == false)
				marcaDao.save(marca);
	return bandera;
				
			}


	// BUSCAR
	@Transactional(readOnly = true)
	public Marcas buscar(long idMar) {
		return marcaDao.findById(idMar).orElse(null);
	}

	// EDITAR
	// VALIDAR QUE EL ID EXISTA PARA EDITAR
	@Transactional
	public boolean editar(@RequestBody Marcas marca) {
		boolean bandera = false;
		for (Marcas m : marcaDao.findAll()) {
			if (m.getIdMar().equals(marca.getIdMar())) {
				marcaDao.save(marca);
				bandera = true;
				break;
			}
		}
		return bandera;
	}

// ELIMINAR
//VALIDAR QUE EL ID EXISTA PARA PODER ELIMINAR 
@Transactional
public boolean eliminar (@RequestBody Marcas marca) {
	boolean bandera = false;
	for(Marcas m : marcaDao.findAll()) {
		if(m.getIdMar().equals(marca.getIdMar())) {
			marcaDao.delete(marca);
			bandera = true;
			break;
		}
	}
	return bandera;
}
	

	
	
}
