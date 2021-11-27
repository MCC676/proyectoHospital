package com.MCC.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MCC.demo.models.dao.ICitasDAO;
import com.MCC.demo.models.dao.IPacienteDAO;
import com.MCC.demo.models.entity.Citas;
import com.MCC.demo.models.entity.Paciente;

@Controller
@RequestMapping("citas")
public class CitasController {
	
	@Autowired
	private IPacienteDAO pacienteDAO;
	@Autowired
	private ICitasDAO citaDAO;
	
	@RequestMapping("/form/{pacienteId}")
	public String crear(@PathVariable(value = "pacienteId")Long pacienteId,
			Map<String, Object> model, RedirectAttributes flash) {
		
		Paciente paciente= pacienteDAO.buscarPaciente(pacienteId);		
		if(paciente==null) {
			flash.addAttribute("error","El paciente no existe en la base de datos");
			return "redirect:/pacientes/listar";
		}
		Citas cita=new Citas();
		cita.setPaciente(paciente);
		model.put("cita", cita);
		model.put("titulo", "Crear Cita");			
		return "citas/formulario";
	}
	@RequestMapping("/ver/{id}")
	public String ver(@PathVariable(value = "id")Long id,Model model, RedirectAttributes flash) {
		Citas cita = citaDAO.buscarCita(id);
		if(cita ==null) {
			flash.addFlashAttribute("error","La cita no fue programada");
			return "redirect:/pacientes/listar";
		}	
		
		model.addAttribute("cita", cita);
		return "citas/ver";
	}
}
