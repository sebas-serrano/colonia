package com.colonia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.colonia.model.Profesor;
import com.colonia.service.ProfesorService;

@Controller
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	
	/**
	 * 
	 * Gestion de profesores
	 * 
	 */
	@GetMapping("/listProfesores")
	public String listProfesores(Model model) {
		model.addAttribute("profesores", profesorService.findAll());
		return "profesor/listProfesores";
	}

	@GetMapping("/nuevoProfesor")
	public String getNuevoProfesor(Model model) {
		Profesor profesor = new Profesor();
		model.addAttribute("profesor", profesor);
		return "profesor/nuevoProfesor";
	}


	@PostMapping("/guardarProfesor")
	public String guardarProfesor(@Valid Profesor profesor, BindingResult result) {
		if (result.hasErrors()) {
			return "profesor/nuevoProfesor";
		}
		if (profesor.getEsProfesor().equals("SI")) {
			profesor.setEsProfe(true);
		}else {
			profesor.setEsProfe(false);
		}
		profesorService.saveProfesor(profesor);
		return "redirect:/listProfesores";
	}

}
