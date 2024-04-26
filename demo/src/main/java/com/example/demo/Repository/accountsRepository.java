package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.accounts;

@Repository
public interface accountsRepository extends CrudRepository<accounts, Long> {
    accounts findByAccount(String account);
}
