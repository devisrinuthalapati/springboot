package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entity.Transactions;
import com.bankapp.model.repository.TransactionRepository;
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
@Autowired
private TransactionRepository transactionRepository;
	@Override
	public List<Transactions> findByAccountAccountNumber(Long accountNumber) {
		
		return transactionRepository.findByAccountAccountNumber(accountNumber);
	}

}
