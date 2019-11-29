package com.bankapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.Customer;
import com.bankapp.model.entity.Transactions;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionService;
import com.bankapp.web.beanconfig.AccountRequest;
import com.bankapp.web.beanconfig.AccountRequestBean;

@RestController
@RequestMapping(path="api")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping(path="account",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> allAccounts(){
		return new ResponseEntity<List<Account>>(accountService.findAll(),HttpStatus.OK);
	}
	@PostMapping(path="account",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addAccount(@RequestBody AccountRequest accountreq){
		Account account=new Account(accountreq.getBalance(), false);
		Customer customer=new Customer(accountreq.getName(), accountreq.getEmail(), accountreq.getPhone(), accountreq.getAddress(), accountreq.getCity(), accountreq.getCountry());
		account.setCustomer(customer);
		accountService.createAccount(account);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(path="account/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>delete(@PathVariable(name="accountNumber")Long accountNumber){
		accountService.deleteAccount(accountNumber);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping(path="account/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transactions>>transactionalList(@PathVariable(name="accountNumber")Long accountNumber){
		return new ResponseEntity<List<Transactions>>(transactionService.findByAccountAccountNumber(accountNumber),HttpStatus.OK);
	}
	@PutMapping(path="account/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>update(@PathVariable(name="accountNumber")Long accountNumber,@RequestBody AccountRequestBean accountBean){
		Account updateaccount=accountService.findAllById(accountNumber);
		updateaccount.getCustomer().setEmail(accountBean.getEmail());
		updateaccount.getCustomer().setPhone(accountBean.getPhone());
		updateaccount.getCustomer().setAddress(accountBean.getAddress());
		updateaccount.getCustomer().setCity(accountBean.getCity());
		updateaccount.getCustomer().setCountry(accountBean.getCountry());
	
		
		accountService.updateAccount(updateaccount, accountNumber);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
