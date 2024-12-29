package com.mx.ApiRestAgenciaAutos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.ApiRestAgenciaAutos.dao.ModelosDao;
import com.mx.ApiRestAgenciaAutos.model.Modelos;

@Service
public class ModelosServImp {

	@Autowired
	ModelosDao modeloDao;

	// MOSTRAR-LISTAR
	@Transactional
	public List<Modelos> listar() {
		return modeloDao.findAll();
	}
		// GUARDAR:
		// HACER 2 VALIDACIONES CON EL ID Y NOMBRE QUE NO SE REPITAN
		// Y EL ID
		@Transactional
		public boolean guardar(Modelos modelo) {
			boolean bandera = false;
			for (Modelos m : modeloDao.findAll()) {
				if(m.getIdMod().equals(modelo.getIdMod())|| m.getNombre().equals(modelo.getNombre())) {
					
					bandera = true;
					break;
				}
				
				}
			if (bandera == false)
				modeloDao.save(modelo);
	return bandera;	
			}
		
		// BUSCAR
		@Transactional(readOnly = true)
		public Modelos buscar(long idMod) {
			return modeloDao.findById(idMod).orElse(null);
		}
	
	//EDITAR 
	//VALIDAR QUE EL ID EXISTA PARA EDITAR
@Transactional
public boolean editar(@RequestBody Modelos modelo) {
	boolean bandera = false;
	for (Modelos m : modeloDao.findAll()) {
		if(m.getIdMod().equals(modelo.getIdMod())) {
			modeloDao.save(modelo);
			bandera = true;
			break;
		}	
	}
	return bandera;
	
}
	//ELIMINAR 
	//VALIDAR QUE EL ID EXISTA PARA PODER EDITAR
	
@Transactional
public boolean eliminar (@RequestBody Modelos modelo) {
	boolean bandera = false;
	for(Modelos m : modeloDao.findAll()) {
		if(m.getIdMod().equals(modelo.getIdMod())) {
			modeloDao.delete(modelo);
			bandera = true;
			break;
		}
	}
	return bandera;
}
	
	

}
