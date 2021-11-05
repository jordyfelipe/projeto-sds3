package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

//Sistema de camadas, temos uma camada de serviço, 
//que depende de uma camada de dados (Spring JPA Repository)

@Service //Annotation do Spring que registra a classe como um componente do sistema.
public class SellerService {
	
	@Autowired //faz com que o framework Spring instancie o objeto por mim.
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(item -> new SellerDTO(item)).collect(Collectors.toList());
		//result vira uma stream, map converte cada item da lista tipo Seller para SellerDTO e depois 
		//o collect transforma a stream de volta em lista.
	}
	
}
