package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entity.TransactionLog;

public interface TransactionalLogService {
public List<TransactionLog> findAll();
}
