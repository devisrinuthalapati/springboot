package com.bankapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entity.TransactionLog;
@Repository
public interface TransactionalLogRepository extends JpaRepository<TransactionLog, Long> {

}
