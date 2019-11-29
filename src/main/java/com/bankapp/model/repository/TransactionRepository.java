package com.bankapp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bankapp.model.entity.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long>{
	 List<Transactions> findByAccountAccountNumber(Long accountNumber);
}
