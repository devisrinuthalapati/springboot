package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entity.Transactions;

public interface TransactionService {
	List<Transactions> findByAccountAccountNumber(Long accountNumber);

}
