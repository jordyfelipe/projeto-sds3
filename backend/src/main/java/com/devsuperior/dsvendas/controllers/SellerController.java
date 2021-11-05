package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.service.SellerService;

@RestController //Indica que a classe é um controlador Rest
@RequestMapping(value = "/sellers") //Caminho para este recurso web
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@GetMapping //Para mapear a requisição HTTP
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
		//Retorna uma resposta 200, que no protocolo HTTP significa que deu
		//tudo certo e no corpo desta resposta retorna também a lista.
	}
	
}
