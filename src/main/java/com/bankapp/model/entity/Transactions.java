package com.bankapp.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="accounttransaction_table")
public class Transactions {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate transactiondate;
	private double amount;
	private String type;
	 @JoinColumn(name="accountNumber_fk")
	@ManyToOne
	@JsonIgnore
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(LocalDate transactiondate) {
		this.transactiondate = transactiondate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Transactions( double amount, String type) {
		
		this.transactiondate = LocalDate.now();
		this.amount = amount;
		this.type = type;
	}
	public Transactions() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transactions [id=" + id + ", transactiondate=" + transactiondate + ", amount=" + amount + ", type="
				+ type + "]";
	}
	

}
