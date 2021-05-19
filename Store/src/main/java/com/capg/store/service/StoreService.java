package com.capg.store.service;

import java.util.List;

import com.capg.store.bean.Stock;
import com.capg.store.bean.Transaction;

public interface StoreService {
	
	public List<Stock> getAllStock();
	public Stock saveStock(Stock s);
	public List<Transaction> getAllTransaction();
	public Transaction saveTransaction(Transaction t);
	public Stock updatedStock(String stockName, int quantity, String type);
	public Stock getStockById(int id);
	public Transaction getTransactionById(int id);
	

}
