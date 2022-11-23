package com.idat.AlumnoMicroservicioIIIE.service;

import java.util.List;

import com.idat.AlumnoMicroservicioIIIE.dto.AlumnoDTO;
import com.idat.AlumnoMicroservicioIIIE.model.Alumno;

public interface AlumnoService {
	
	List<AlumnoDTO> listar();
	AlumnoDTO obtenerId(Integer id);
	void guardar(AlumnoDTO alumno);
	void eliminar(Integer id);
	void actualizar(AlumnoDTO alumno);
}
