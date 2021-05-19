package com.capg.store.bean;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@Entity
@ApiModel(value = "Stock Bean")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	
	@ApiModelProperty(name = "Stock Name", value = "Hols the min 3 character stock name and only alphabets are allowed", required = true)
	@NotEmpty(message = "The name of the stock cannot be null")
	@Size(min = 3, max = 15, message = "Invalid stock Name")
	@Pattern(regexp="^[A-Za-z]+",message = "Invalid Input")
	private String stockName;
	
	@ApiModelProperty(name = "Stock Price", value = "Hold the price of stock and cannot be negitive", required = true)
	@Positive(message = "The price cannot be negative")
	private int stockPrice;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Stock(int stockId, String stockName,int stockPrice) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}

	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", stockPrice=" + stockPrice + "]";
	}
	



}