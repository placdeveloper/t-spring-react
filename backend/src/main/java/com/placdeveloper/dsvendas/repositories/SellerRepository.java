package com.placdeveloper.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placdeveloper.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
