package com.capg.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.store.bean.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
