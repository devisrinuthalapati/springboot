package com.bankapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bankapp.model.entity.Account;

@Repository

public interface AccountRepository extends JpaRepository<Account, Long> {
	public Account findAccountByAccountNumber(Long accountNumber);

}
