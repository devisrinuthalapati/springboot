package com.bankapp.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.beanconfig.TransferRequest;
import com.bankapp.web.beanconfig.WithdrawOrDepositRequest;

@RestController
@RequestMapping(path="api")
public class TransactionController {
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping(path="transaction/deposit",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deposit(@RequestBody WithdrawOrDepositRequest withdrawordeposit,Principal principal){
		
		accountService.deposit(withdrawordeposit.getAccountNumber(), withdrawordeposit.getAmount(),principal.getName());
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PostMapping(path="transaction/withdraw",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>withdraw(@RequestBody WithdrawOrDepositRequest withdrawordeposit,Principal principal){
		accountService.withdraw(withdrawordeposit.getAccountNumber(), withdrawordeposit.getAmount(),principal.getName());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PostMapping(path="transaction/transfer",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>transfer(@RequestBody TransferRequest transferrequest,Principal principal){
		accountService.transfer(transferrequest.getFromAccount(),transferrequest.getToAccount(),transferrequest.getAmount(),principal.getName());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

}
