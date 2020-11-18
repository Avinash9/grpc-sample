package com.grpcsample.passbook.repository;

import com.grpcsample.passbook.entity.Passbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PassbookRepository  extends JpaRepository<Passbook,Integer> {

    List<Passbook> getPassbookByUserId(String userId);

}
