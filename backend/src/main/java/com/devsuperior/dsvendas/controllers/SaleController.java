package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
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
	
	@GetMapping(value = "/amount-by-seller") //Para mapear a requisição HTTP
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
		//Retorna uma resposta 200, que no protocolo HTTP significa que deu
		//tudo certo e no corpo desta resposta retorna também a lista.
	}
	
	@GetMapping(value = "/success-by-seller") //Para mapear a requisição HTTP
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){
		List<SaleSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);
		//Retorna uma resposta 200, que no protocolo HTTP significa que deu
		//tudo certo e no corpo desta resposta retorna também a lista.
	}
	
}
