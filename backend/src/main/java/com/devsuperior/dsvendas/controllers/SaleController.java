package com.devsuperior.dsvendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.service.SaleService;

@RestController //Indica que a classe é um controlador Rest
@RequestMapping(value = "/sales") //Caminho para este recurso web
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping //Para mapear a requisição HTTP
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
		//Retorna uma resposta 200, que no protocolo HTTP significa que deu
		//tudo certo e no corpo desta resposta retorna também a lista.
	}
	
}
