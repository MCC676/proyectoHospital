package com.MCC.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MCC.demo.models.dao.ICitasDAO;
import com.MCC.demo.models.dao.IPacienteDAO;
import com.MCC.demo.models.entity.Citas;
import com.MCC.demo.models.entity.Paciente;

@Controller
@RequestMapping("pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteDAO pacienteDAO;
	
	@Autowired
	private ICitasDAO citaDAO;
	
	
	@RequestMapping("/")
	public String index() {
		return "listar";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("pacientes",pacienteDAO.getPacientes());
		model.addAttribute("pagina", 1);
		return"pacientes/listar";
	}
	
	@RequestMapping("/form")
	public String crear(Map<String, Object> model) {
		Paciente paciente=new Paciente();
		model.put("crearForm", "Registrar Paciente");
		model.put("paciente", paciente);
		model.put("pagina", 2);
			return "pacientes/formulario";
	}
	@RequestMapping(value ="/form",method=RequestMethod.POST)
	public String guardar(Paciente paciente) {
		pacienteDAO.save(paciente);
		return "redirect:listar";
	}
	
	@RequestMapping("/form/{id}")
	public String editar(@PathVariable(value="id")Long id,Model model) {
		Paciente paciente =null;
		if(id>0) {
			paciente=pacienteDAO.buscarPaciente(id);
		}else {
			return "redirect:/listar";
		}
		model.addAttribute("crearForm","Modificar Paciente");
		model.addAttribute("paciente",paciente);
		return "pacientes/formulario";
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable (value="id")Long id) {
		if(id >0) {
			pacienteDAO.eliminar(id);
		}
		return "redirect:/pacientes/listar";		
		
	}
	@RequestMapping("/ver/{id}")
	public String ver(@PathVariable(value = "id")Long id,Model model, RedirectAttributes flash) {
		Paciente paciente= pacienteDAO.buscarPaciente(id);
		Citas cita= citaDAO.buscarCita(id);
		if(paciente ==null && cita ==null) {
			flash.addFlashAttribute("error","El paciente no existe en la base de datos");
			return "redirect:/pacientes/listar";		
		}
		
		model.addAttribute("paciente", paciente);
		model.addAttribute("citas", cita);
		return "pacientes/ver";
	}	
	
}
