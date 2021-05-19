package com.capg.store.bean;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Entity
@ApiModel(value = "Transaction Bean")
@Table(name = "Transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transId;
	
	@ApiModelProperty(name = "Stock quantity", value = "Hold the quantity of the stock in a transaction")
	private int quantity;
	
	@ApiModelProperty(name = "Transaction type", value = "Hold the type of transaction that either can be buy or sell",required = true)
	private String transactionType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "StockInfo", referencedColumnName = "stockId")
	private Stock st;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transId, int quantity, String transactionType, Stock st) {
		super();
		this.transId = transId;
		this.quantity = quantity;
		this.transactionType = transactionType;
		this.st = st;
	}
	public Transaction(int quantity, String transactionType, Stock st) {
		super();
		this.transId = transId;
		this.quantity = quantity;
		this.transactionType = transactionType;
		this.st = st;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Stock getSt() {
		return st;
	}

	public void setSt(Stock st) {
		this.st = st;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", quantity=" + quantity + ", transactionType=" + transactionType
				+ ", st=" + st + "]";
	}
	
	
}
