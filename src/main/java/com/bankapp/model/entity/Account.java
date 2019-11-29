package com.bankapp.model.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="acc_table1")
public class Account {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountNumber;
	
	@Column(name="Balance")
	private double balance;
	
	private Boolean blocked;
	@OneToOne(mappedBy="account", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	/*@JsonIgnore*/
	private Customer customer;
	@OneToMany(mappedBy="account",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
private	List<Transactions> transactionsList=new ArrayList<>();
	public void addTransaction(Transactions tx){
		transactionsList.add(tx);
		tx.setAccount(this);
	}
	
	public List<Transactions> getTransactionsList() {
		return transactionsList;
	}
	public void setTransactionsList(List<Transactions> transactionsList) {
		this.transactionsList = transactionsList;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
		customer.setAccount(this);
	}
	
	public Account(double balance, Boolean blocked) {
		
		this.balance = balance;
		this.blocked = blocked;
		
	}

	public Account(double balance, Boolean blocked, Customer customer) {
		
		this.balance = balance;
		this.blocked = blocked;
		this.customer = customer;
	}

	public Account() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", blocked=" + blocked
				+ "]";
	}
	

}
