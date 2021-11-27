package com.MCC.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MCC.demo.models.dao.IMedicamentoDAO;
import com.MCC.demo.models.entity.Medicamentos;

@RestController
@RequestMapping("/api")
public class MedicinaRestController {

	@Autowired
	private IMedicamentoDAO medicinaDao;
	
	@RequestMapping("listar")
	public List<Medicamentos> listar(){
		return medicinaDao.getMedicamento();
	}
}
