package com.MCC.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MCC.demo.models.dao.IMedicoB;
import com.MCC.demo.models.dao.IMedicoDAO;
import com.MCC.demo.models.entity.Medicos;





@Controller
@RequestMapping("medicos")
public class MedicoController {
	
	
	@Autowired
	private IMedicoDAO medicoDAO;
	
	@Autowired
	private IMedicoB medicoDaoB;
	
	
	
	@RequestMapping("/")
	public String index() {
		return "listar";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("medicos",medicoDAO.getMedico());
		model.addAttribute("pagina", 1);
		return"medicos/listar";
	}
	
	@RequestMapping("/form")
	public String crear(Map<String, Object> model) {
		Medicos medico=new Medicos();
		model.put("crearForm", "Registrar Medico");
		model.put("medico", medico);
		model.put("pagina", 2);
			return "medicos/formulario";
	}
	@RequestMapping(value ="/form",method=RequestMethod.POST)
	public String guardar(Medicos paciente) {
		medicoDAO.save(paciente);
		return "redirect:listar";
	}
	
	@RequestMapping("/form/{id}")
	public String editar(@PathVariable(value="id")Long id,Model model) {
		Medicos medicos =null;
		if(id>0) {
			medicos =medicoDAO.buscarMedicos(id);
		}else {
			return "redirect:/listar";
		}
		model.addAttribute("crearForm","Modificar Medico");
		model.addAttribute("medico",medicos);
		return "medicos/formulario";
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable (value="id")Long id) {
		if(id >0) {
			medicoDAO.eliminar(id);
		}
		return "redirect:/medicos/listar";		
		
	}
	@RequestMapping("/ver/{id}")
	public String ver(@PathVariable(value = "id")Long id,Model model, RedirectAttributes flash) {
		Medicos medico= medicoDAO.buscarMedicos(id);
		if(medico ==null) {
			flash.addFlashAttribute("error","El paciente no existe en la base de datos");
			return "redirect:/pacientes/listar";		
		}
		model.addAttribute("paciente", medico);
		return "medicos/ver";
	}
	@RequestMapping(value = "/cargar-espec/{term}", produces= {"application/json"})
	public @ResponseBody List<Medicos> cargarEspec(@PathVariable String term){
		return medicoDaoB.findByNombre(term);
	}
	
	
}
