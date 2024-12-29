package com.mx.ApiRestAgenciaAutos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE MODELOS_AUTOS(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR(80) NOT NULL,
TRANSMISION VARCHAR2(90) NOT NULL,
PRECIO NUMBER NOT NULL,
ID_MARCA NUMBER NOT NULL,
FOREIGN KEY (ID_MARCA)REFERENCES MARCAS_AUTOS(ID)
);*/

@Entity
@Table (name="MODELOS_AUTOS")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Modelos {
@Id
@Column(name="ID")
private Long idMod;

@Column(name="NOMBRE")
private String nombre;

@Column(name="TRANSMISION")
private String transmision;

@Column(name="PRECIO")
private Double precio;

//Cardinalidad-----Muchoos modelos pertenecen a una marca
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "ID_MARCA")
Marcas marca; //Este debe coincidir con la variable del mappedBy = "marca",

//fetch----  Indicamos como debe ser cargada la entidad
//fechtType.EAGER---- Indicamos que la relacion debe ser cargada al momento








	
	
	
}
