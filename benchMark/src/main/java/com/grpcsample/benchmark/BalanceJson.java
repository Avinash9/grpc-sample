package com.grpcsample.benchmark;


import lombok.Data;

@Data
public class BalanceJson {

    private int  availableBalance;
    private int  usedBalance ;
    private int  accountId ;
    private String userName;
}
