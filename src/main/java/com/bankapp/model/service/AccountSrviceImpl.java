package com.bankapp.model.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.TransactionLog;
import com.bankapp.model.entity.Transactions;
import com.bankapp.model.repository.AccountRepository;
import com.bankapp.model.repository.CustomerRepository;
import com.bankapp.model.repository.TransactionRepository;
import com.bankapp.model.repository.TransactionalLogRepository;
import com.bankapp.model.repository.UserRepository;
import com.bankapp.model.serviceexception.AccountNotfoundException;
import com.bankapp.model.serviceexception.InsufficientAmountException;
@Service
@Transactional
public class AccountSrviceImpl implements AccountService{

	@Autowired 
	private AccountRepository accountRepository;
	
	@Autowired 
	private TransactionRepository transactionRepository;
	@Autowired 
	private TransactionalLogRepository transactionalLogRepository;
	@Autowired 
	private CustomerRepository customerRepository;
	@Override
	public void blockAccount(Long accountNumber) {
		
		
	}

	@Override
	public void createAccount(Account account) {
		accountRepository.save(account);
		customerRepository.save(account.getCustomer());
		
	}

	/*@Override
	public void deposit(Long accountNumber, double amount) {
		Account account=accountRepository.findAccountByAccountNumber(accountNumber);
		account.setBalance(account.getBalance()+amount);
		Transactions transaction=new Transactions(amount,"deposit");
				account.addTransaction(transaction);
				accountRepository.save(account);
		TransactionLog log=new TransactionLog
				(accountNumber, null, "depoist", amount, "sai", "done");
		transactionalLogRepository.save(log);
	}*/

	/*@Autowired
	public void withdraw(Long accountNumber, double amount,String authority) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotfoundException::new);
		// min bal should be 1000 in any case
		if (account.getBalance() - amount < 1000)
			throw new InsufficientAmountException();
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		
		
	}*/

	
	@Override
	public List<Account> findAll() {
		
		return accountRepository.findAll();
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		accountRepository.deleteById(accountNumber);
		
	}

	@Override
	public void deposit(Long accountNumber, double amount, String authority) {
		Account account=accountRepository.findAccountByAccountNumber(accountNumber);
		account.setBalance(account.getBalance()+amount);
		Transactions transaction=new Transactions(amount,"deposit");
				account.addTransaction(transaction);
				accountRepository.save(account);
		TransactionLog log=new TransactionLog
				(accountNumber, null, "depoist", amount, authority, "done");
		transactionalLogRepository.save(log);
	}

	@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount, String authority) {
		Account account1=accountRepository.findById(fromAccNumber).orElseThrow(AccountNotfoundException::new);
		Account account2=accountRepository.findById(toAccNumber).orElseThrow(AccountNotfoundException::new);
		account1.setBalance(account1.getBalance()-amount);
		account2.setBalance(account2.getBalance()+amount);
		accountRepository.save(account1);
		accountRepository.save(account2);
		Transactions transactions=new Transactions(amount, "transfer");
		account1.addTransaction(transactions);
		account2.addTransaction(transactions);
		TransactionLog transactionLog=new TransactionLog(fromAccNumber, toAccNumber, "transfer", amount, authority, "done");
		transactionalLogRepository.save(transactionLog);
	}

	@Override
	public void withdraw(Long accountNumber, double amount, String authority) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotfoundException::new);
		// min bal should be 1000 in any case
		if (account.getBalance() - amount < 1000)
			throw new InsufficientAmountException();
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		Transactions transaction=new Transactions(amount,"deposit");
		account.addTransaction(transaction);
		accountRepository.save(account);
TransactionLog log=new TransactionLog
		(accountNumber, null, "withdraw", amount, authority, "done");
transactionalLogRepository.save(log);
	}

	@Override
	public void updateAccount(Account account, Long accountNumber) {
		Account accountToBeUpdate=accountRepository.findById(accountNumber).orElseThrow(AccountNotfoundException::new);
		accountRepository.save(accountToBeUpdate);
		
	}

	@Override
	public Account findAllById(Long accountNumber) {
		
		return accountRepository.findById(accountNumber).orElseThrow(AccountNotfoundException::new);
	}

}
