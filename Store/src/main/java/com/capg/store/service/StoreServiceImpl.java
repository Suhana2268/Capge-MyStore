package com.capg.store.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.store.bean.Stock;
import com.capg.store.bean.Transaction;
import com.capg.store.dao.StockRepository;
import com.capg.store.dao.TransactionRepository;


@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	StockRepository stockrep;
	
	@Autowired
	TransactionRepository transactionRep;

	@Override
	public List<Stock> getAllStock() {
		// TODO Auto-generated method stub
		return stockrep.findAll();
	}

	@Override
	public Stock saveStock(Stock s) {
		// TODO Auto-generated method stub
		stockrep.save(s);
		return s;
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactionRep.findAll();
	}

	@Override
	public Transaction saveTransaction(Transaction t) {
		// TODO Auto-generated method stub
		transactionRep.save(t);
		return t;
	}

	@Override
	public Stock updatedStock(String stockName, int quantity, String type) {
		// TODO Auto-generated method stub
		List<Stock> sList = getAllStock();
		int x = 0;
		Stock s = null;
		for(Stock st : sList) {
			if(type.equals("buy")) {
			if(st.getStockName().equals(stockName)) {
				while(quantity >= 100) {
					int y = st.getStockPrice();
					x = (2*y)/100;
					int updatedPrice = y+x;
					System.out.println(updatedPrice);
					st.setStockPrice(updatedPrice);
					s = st;
					quantity -=100;
					stockrep.save(s);
					
					
				}
			}
			}
			else if(type.equals("sell")) {
				if(st.getStockName().equals(stockName)) {
					while(quantity >= 100) {
				int y = st.getStockPrice();
				x = (2*y)/100;
				int updatedPrice = y-x;
				System.out.println(updatedPrice);
				st.setStockPrice(updatedPrice);
				s = st;
				quantity -=100;
				stockrep.save(s);
					}
				}
			}
			
		}
		Transaction t = new Transaction(quantity, type, s);
		
		transactionRep.save(t);
		return s;
	}

	@Override
	public Stock getStockById(int id)  {
		return stockrep.findById(id).get();
		
	}
	
	@Override
	public Transaction getTransactionById(int id)  {
		return transactionRep.findById(id).get();
		
	}
	

}
