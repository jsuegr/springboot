package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Controller
public class ClienteController {
	@Autowired
	private IClienteDao clienteDao;
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("titulo", "Formulario de cliente");
		model.put("cliente", cliente);
		return "form";
	}
	
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()){
			return "form";
		}
		clienteDao.save(cliente);
		return "redirect:listar";
	}
}
