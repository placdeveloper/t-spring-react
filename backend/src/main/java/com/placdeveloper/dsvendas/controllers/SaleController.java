package com.placdeveloper.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placdeveloper.dsvendas.dto.SaleDTO;
import com.placdeveloper.dsvendas.dto.SaleSuccessDTO;
import com.placdeveloper.dsvendas.dto.SaleSumDTO;
import com.placdeveloper.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> lista = saleService.findAll(pageable);
		return ResponseEntity.ok(lista);
	}

	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> lista = saleService.amountGroupedBySeller();
		return ResponseEntity.ok(lista);
	}

	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> lista = saleService.successGroupedBySeller();
		return ResponseEntity.ok(lista);
	}

}
