package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

//Sistema de camadas, temos uma camada de serviço, 
//que depende de uma camada de dados (Spring JPA Repository)

@Service //Annotation do Spring que registra a classe como um componente do sistema.
public class SaleService {
	
	@Autowired //faz com que o framework Spring instancie o objeto por mim.
	private SaleRepository repository;
	
	/** 
	Neste caso, como a busca é pequena (poucos Sellers),
	inserida a linha 31 para que o JPA utilize o cache e não tenha a necessidade de 
	buscar no banco Seller por Seller.
	*/
	@Autowired 
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true) //utilizado para que o banco não faça lock
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(item -> new SaleDTO(item));
		//result vira uma stream, map converte cada item da lista tipo Seller para SellerDTO e depois 
		//o collect transforma a stream de volta em lista.
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
	
	
}
