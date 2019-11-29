package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entity.TransactionLog;
import com.bankapp.model.repository.TransactionalLogRepository;
@Service
@Transactional
public class TransactionalLogServiceImpl implements TransactionalLogService{
@Autowired
private TransactionalLogRepository transactionLogRepository;
	@Override
	public List<TransactionLog> findAll() {
		
		return transactionLogRepository.findAll();
	}

}
