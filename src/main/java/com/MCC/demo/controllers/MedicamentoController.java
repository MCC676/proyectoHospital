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

import com.MCC.demo.models.dao.IMedicamentoB;
import com.MCC.demo.models.dao.IMedicamentoDAO;
import com.MCC.demo.models.entity.Medicamentos;

@Controller
@RequestMapping("medicamentos")
public class MedicamentoController {
	
	@Autowired
	private IMedicamentoDAO medicamentoDAO;
	
	@Autowired
	private IMedicamentoB medicamentoB;
	
	@RequestMapping("/")
	public String index() {
		return "listar";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("medicamentos",medicamentoDAO.getMedicamento());
		model.addAttribute("pagina", 1);
		return"medicamentos/listar";
	}
	
	@RequestMapping("/form")
	public String crear(Map<String, Object> model) {
		Medicamentos medicamento=new Medicamentos();
		model.put("crearForm", "Registrar Medicamento");
		model.put("medicamento", medicamento);
		model.put("pagina", 2);
			return "medicamentos/formulario";
	}
	@RequestMapping(value ="/form",method=RequestMethod.POST)
	public String guardar(Medicamentos medicamento) {
		medicamentoDAO.save(medicamento);
		return "redirect:listar";
	}
	
	@RequestMapping("/form/{id}")
	public String editar(@PathVariable(value="id")Long id,Model model) {
		Medicamentos medicamento=null;
		if(id>0) {
			medicamento=medicamentoDAO.buscarMedicamento(id);
		}else {
			return "redirect:/listar";
		}
		model.addAttribute("crearForm","Modificar Medicamento");
		model.addAttribute("medicamento",medicamento);
		return "medicamentos/formulario";
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable (value="id")Long id) {
		if(id >0) {
			medicamentoDAO.eliminar(id);
		}
		return "redirect:/medicamentos/listar";		
		
	}
	@RequestMapping("/ver/{id}")
	public String ver(@PathVariable(value = "id")Long id,Model model, RedirectAttributes flash) {
		Medicamentos medicamento= medicamentoDAO.buscarMedicamento(id);
		if(medicamento ==null) {
			flash.addFlashAttribute("error","El paciente no existe en la base de datos");
			return "redirect:/pacientes/listar";		
		}
		model.addAttribute("paciente", medicamento);
		return "pacientes/ver";
	}
	
	@RequestMapping(value = "/cargar-productos/{term}", produces= {"application/json"})
	public @ResponseBody List<Medicamentos> cargarMedicamentos(@PathVariable String term){
		return medicamentoB.findByNombre(term);
	}
	
}
