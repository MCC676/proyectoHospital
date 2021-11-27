package com.MCC.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MCC.demo.models.dao.ICitasDAO;
import com.MCC.demo.models.dao.IPacienteDAO;
import com.MCC.demo.models.entity.Atencion;
import com.MCC.demo.models.entity.Citas;
import com.MCC.demo.models.entity.Medicamentos;
import com.MCC.demo.models.entity.Paciente;
import com.MCC.demo.models.entity.Tratamiento;



@Controller
@RequestMapping("/atencion")
@SessionAttributes("atencion")
public class AtencionController {

	@Autowired
	private ICitasDAO citaDao;
	@Autowired
	private IPacienteDAO pacienteDao;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/form/{citaId}")
	public String crear(@PathVariable(value = "citaId") Long citaId, Model model, RedirectAttributes flash) {
		
		Paciente paciente = pacienteDao.buscarPaciente(citaId);
		Citas cita = citaDao.buscarCita(citaId);
		if(cita ==null && paciente==null) {
			flash.addFlashAttribute("error","El médico no tiene cita programada");
			return "redirect:/medicos/listar";
		}
		Atencion atencion= new Atencion();
		atencion.setCita(cita);
		//cita.setPaciente(paciente);
		model.addAttribute("paciente", paciente);
		model.addAttribute("atencion", atencion);
		return "atencion/formulario";
	}
	
	@PostMapping("/form")
	public String guardar(Atencion atencion, 
			@RequestParam(name = "item_id[]", required = true)  Long[] itemId,
			@RequestParam(name = "cantidad[]", required = true)  Integer[] cantidad,
			RedirectAttributes flash,
			SessionStatus status) {
			
		for(int i=0; i<itemId.length; i++) {
			Medicamentos med= citaDao.findCitaById(itemId[i]);
			
			Tratamiento trt = new Tratamiento();
			trt.setCantidad(cantidad[i]);
			trt.setMedicamento(med);
			atencion.addTratamiento(trt);
			
			log.info("ID: "+itemId[i].toString()+" cantidad: "+cantidad[i].toString());
		}
		citaDao.saveAtencion(atencion);
		status.setComplete();
		
		flash.addFlashAttribute("success", "Atencion registrada");
		
		return "redirect:/pacientes/ver/"+atencion.getCita().getId();
	}
}
