package com.bankapp.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Optional<Customer> findById(Long id);
	public Customer findByEmail(String email);
	
}
