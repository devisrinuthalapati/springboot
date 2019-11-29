package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.User;

public interface AccountService {
	public List<Account> findAll();
	void deleteAccount(Long accountNumber);
	void blockAccount(Long accountNumber);
	Account findAllById(Long accountNumber);
    void createAccount(Account account );
    void updateAccount(Account account,Long accountNumber );
    void deposit(Long accountNumber, double amount,String authority);
    void withdraw(Long accountNumber, double amount,String authority);
    void transfer(Long fromAccNumber, Long toAccNumber, double amount,String authority);
}
