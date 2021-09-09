package com.placdeveloper.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placdeveloper.dsvendas.dto.SellerDTO;
import com.placdeveloper.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repo;

	public List<SellerDTO> findAll() {
		return repo.findAll()
				.stream()
				.map(x -> new SellerDTO(x.getId(), x.getName()))
				.collect(Collectors.toList());
	}
}
