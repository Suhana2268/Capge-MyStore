package com.capg.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.store.bean.Stock;



public interface StockRepository extends JpaRepository<Stock, Integer>{

}
