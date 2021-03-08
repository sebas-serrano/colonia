package com.colonia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colonia.model.Alumno;
import com.colonia.service.AlumnoService;

@RestController
@RequestMapping(value="/api")
public class ColoniaController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("/")
	public String getAll(Model model) {
		return "index";
	}

	/**
	 * 
	 * Gestion de  Alumnos
	 * 
	 */
	@GetMapping("/listAlumnos")
	public String listAlumno(Model model) {
		model.addAttribute("alumnos", alumnoService.findAll());
		return "alumno/listAlumnos";
	}
	
	@GetMapping("/nuevoAlumno")
	public String getNuevoAlumnos(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
		return "alumno/nuevoAlumno";
	}
	
	@GetMapping("/getAlumno")
	public Alumno getNuevo(Model model) {
		Alumno alumno = new Alumno();
		//model.addAttribute("alumno", alumno);
		alumno.setApellido("APELIIDO");
		alumno.setDni("1212");
		return alumno;
	}
	
	@PostMapping("/guardarAlumno")
	public String guardar(@Valid Alumno alumno, BindingResult result) {
		if (result.hasErrors()) {
			return "alumno/nuevoAlumno";
		}
		alumnoService.saveAlumno(alumno);
		return "redirect:/listAlumnos";
	}

	@GetMapping("/editAlumno/{id}")
	public String editAlumno(@PathVariable(value="id") Integer idAlumno, Model model){
		Alumno alumno = alumnoService.findById(idAlumno);
		model.addAttribute("alumno", alumno);
		return "alumno/editAlumno";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid Alumno alumno, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	alumno.setId(id);
	    	return "alumno/nuevoAlumno";
	    }
	    alumnoService.saveAlumno(alumno);
	    return "redirect:/listAlumnos";
	}
	
	/**
	 * 
	 * Gestion de Pagos
	 * 
	 */
	@RequestMapping("/listPagos")
	public String listPagos(Model model) {
		model.addAttribute("alumnos", alumnoService.findAll());
		return "pagos/listPagos";
	}
	
	@RequestMapping("/editPagos/{id}")
	public String editPagos(@PathVariable(value="id") Integer idAlumno, Model model){
		Alumno alumno = alumnoService.findById(idAlumno);
		model.addAttribute("alumno", alumno);
		return "pagos/editPagos";
	}
		
	@RequestMapping("/guardarPago/{id}")
	public String savePagos(@PathVariable("id") Integer id, @Valid Alumno alumno, 
			  BindingResult result, Model model) {
		Alumno al = alumnoService.findById(id);
		al.setPagos(alumno.getPagos());
		alumnoService.saveAlumno(al);
		return "redirect:/listPagos";	
	}

}