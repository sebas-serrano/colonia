package com.colonia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.colonia.model.Grupo;
import com.colonia.model.Profesor;
import com.colonia.service.GrupoService;
import com.colonia.service.ProfesorService;
import com.colonia.service.SendMailService;

@Controller
public class GruposControler {
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private SendMailService sendMailService;
	
	@Autowired
	private ProfesorService profesorService;
	
	/**
	 * 
	 * Gestion de Grupos
	 * 
	 */
	@GetMapping("/listGrupos")
	public String listGrupo(Model model) {
		model.addAttribute("grupos", grupoService.findAll());
		return "grupo/listGrupos";
	}

	@GetMapping("/nuevoGrupo")
	public String getNuevoGrupo(Model model) {
		Grupo grupo = new Grupo(); 
		Profesor profesor = new Profesor();
		grupo.setProfesor(profesor);
		List<Profesor> listProfesores = profesorService.findAll();
		model.addAttribute("grupo", grupo);
		model.addAttribute("profesoresList", listProfesores);
		return "grupo/nuevoGrupo";
	}
	
	//confeccioGrupo
	@GetMapping("/confeccionGrupo")
	public String getConfeccionGrupo(Model model) {
		Grupo grupo = new Grupo(); 
		Profesor profesor = new Profesor();
		grupo.setProfesor(profesor);
		List<Profesor> listProfesores = profesorService.findAll();
		model.addAttribute("grupo", grupo);
		model.addAttribute("profesoresList", listProfesores);
		return "grupo/nuevoGrupo";
	}
	
	@PostMapping("/guardarGrupo")
	public String guardarGrupo(@Valid Grupo grupo, BindingResult result) {
		if (result.hasErrors()) {
			return "grupo/nuevoGrupo";
		}
		String id = grupo.getProfesor().getIdBuscado();
		Profesor profesor = profesorService.findById(Integer.valueOf(id)).get();
		grupo.setProfesor(profesor);
		grupoService.saveGrupo(grupo);
		return "redirect:/listGrupos";
	}
	
	@GetMapping("/editGrupo/{id}")
	public String editGrupo(@PathVariable(value="id") Integer idGrupo, Model model){
		Grupo grupo = grupoService.findById(idGrupo);
		model.addAttribute("grupo", grupo);
		return "grupo/editGrupo";
	}
	
	@PostMapping("/updateGrupo/{id}")
	public String updateGrupo(@PathVariable("id") Integer id, @Valid Grupo grupo, 
	  BindingResult result, Model model) {
	    grupoService.saveGrupo(grupo);
	    return "redirect:/listGrupos";
	}
	
	
	@GetMapping("/sendMail")
	public String sendMail() {
		//model.addAttribute("grupos", sendMailService.sendEmail());
		//return sendMailService.sendEmail("", "", "");
		return sendMailService.sendEmail2();
		
	}
	

}
