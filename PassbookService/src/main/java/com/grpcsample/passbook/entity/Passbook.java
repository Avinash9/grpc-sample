package com.grpcsample.passbook.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class Passbook {

    @Id
    private  int id;
    private String txnAmount;
    private String userId;

}
