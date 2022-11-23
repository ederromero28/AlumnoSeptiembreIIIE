package com.idat.AlumnoMicroservicioIIIE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AlumnoMicroservicioIIIE.dto.AlumnoDTO;
import com.idat.AlumnoMicroservicioIIIE.model.Alumno;
import com.idat.AlumnoMicroservicioIIIE.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public List<AlumnoDTO> listar() {
		// TODO Auto-generated method stub
		List<AlumnoDTO> listadto = new ArrayList<>();
		AlumnoDTO dto = null;
		
		for(Alumno alumno : alumnoRepository.findAll()) {
			dto = new AlumnoDTO();
			dto.setApe(alumno.getApellido());
			dto.setNom(alumno.getNombre());
			dto.setCod(alumno.getIdAlumno());
			listadto.add(dto);
		}
		return listadto;
		
	}

	@Override
	public AlumnoDTO obtenerId(Integer id) {
		// TODO Auto-generated method stub
		
		Alumno alumno = alumnoRepository.findById(id).orElse(null);
		AlumnoDTO dto = new AlumnoDTO();
		dto.setApe(alumno.getApellido());
		dto.setNom(alumno.getNombre());
		dto.setCod(alumno.getIdAlumno());
		
		return dto;
	}

	@Override
	public void guardar(AlumnoDTO alumno) {
		// TODO Auto-generated method stub
		
        Alumno alu = new Alumno();
        alu.setApellido(alumno.getApe());
        alu.setNombre(alumno.getNom());
        alu.setIdAlumno(alumno.getCod());
        
        alumnoRepository.save(alu);
	}

	@Override
	public void actualizar(AlumnoDTO alumno) {
		// TODO Auto-generated method stub
        Alumno alu = new Alumno();
        alu.setApellido(alumno.getApe());
        alu.setNombre(alumno.getNom());
        alu.setIdAlumno(alumno.getCod());
        
        alumnoRepository.saveAndFlush(alu);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
	}

}
