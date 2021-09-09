package com.placdeveloper.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.placdeveloper.dsvendas.dto.SaleDTO;
import com.placdeveloper.dsvendas.dto.SellerDTO;
import com.placdeveloper.dsvendas.entities.Sale;
import com.placdeveloper.dsvendas.repositories.SaleRepository;
import com.placdeveloper.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repo;
	
	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {

		sellerRepository.findAll();
		
		Page<Sale> result = repo.findAll(pageable);

		return result.map(x -> new SaleDTO(x.getId(), x.getVisited(), x.getDeals(), x.getAmount(), x.getDate(),
				new SellerDTO(x.getSeller().getId(), x.getSeller().getName())));

	}
}
