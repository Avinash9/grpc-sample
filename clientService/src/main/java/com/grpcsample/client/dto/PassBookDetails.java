package com.grpcsample.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PassBookDetails {

    private String userId;
    private String txnAmount;
    private String merchantName;

    public PassBookDetails(String userId, String txnAmount, String merchantName) {
        this.userId = userId;
        this.txnAmount = txnAmount;
        this.merchantName = merchantName;
    }
}
