package com.grpcsample.balance.repository;

import com.grpcsample.balance.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,String> {

}
