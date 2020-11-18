package com.grpcsample.balance.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class Balance {

    @Id
    private  String id;
    private int userId;
    private  int accountNumber;
    private int currentBalance;
    private int usedBalance;
    private String userName;
}
