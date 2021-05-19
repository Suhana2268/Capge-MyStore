package com.capg.store.web;

import java.time.LocalDateTime;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.store.bean.Stock;
import com.capg.store.bean.Transaction;
import com.capg.store.service.StoreService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@ApiModel(value = "My Store App", description = "Various stocks available")
public class StoreRestController {
	
	@Autowired
	private StoreService service;
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : My Store App "+LocalDateTime.now();
	}
	
	@ApiOperation(value = "Stock post mapping", response = Stock.class)
	@PostMapping("/stock")
	public Stock insertStock(@RequestBody @Valid Stock stock) {
		service.saveStock(stock);
		return stock;
	}
	
	@ApiOperation(value = "Stock get mapping to fetch all stocks", response = List.class)
	@GetMapping("/stocks")
	public List<Stock> getAllStocks() {
		return service.getAllStock();
	}
	
	
	@ApiOperation(value = "Transaction post mapping", response = Transaction.class)
	@PostMapping("/transaction")
	public Transaction insertTransaction(@RequestBody Transaction t) {
		service.saveTransaction(t);
		return t;
	}
	
	@ApiOperation(value = "Transaction get mapping to fetch all transactions", response = List.class)
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return service.getAllTransaction();
	}
	
	
	@ApiOperation(value = "Transaction get mapping to make transaction", response = Stock.class)
	@GetMapping("/stock/{stockName}/{quantity}/{type}")
	public Stock updatedStock(@PathVariable String stockName, @PathVariable int quantity, @PathVariable String type) {
		
		return service.updatedStock(stockName, quantity, type);
		
	}
	
	
	@ApiOperation(value = "Transaction get mapping to fetch transaction using id", response = Transaction.class)
	@GetMapping("/transaction/{tId}")
	public Transaction getTransactionById(@PathVariable int tId) {
		return service.getTransactionById(tId);
	}
	
	@ApiOperation(value = "Stock get mapping to fetch stock using id", response = Stock.class)
	@GetMapping("/stock/{id}")
	public Stock getStockById(@PathVariable int id) {
		return service.getStockById(id);
	}
		
}
