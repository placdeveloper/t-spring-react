package com.placdeveloper.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.placdeveloper.dsvendas.dto.SaleSuccessDTO;
import com.placdeveloper.dsvendas.dto.SaleSumDTO;
import com.placdeveloper.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	
	@Query("SELECT new com.placdeveloper.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new com.placdeveloper.dsvendas.dto.SaleSuccessDTO(obj.seller, "
			+ " SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
