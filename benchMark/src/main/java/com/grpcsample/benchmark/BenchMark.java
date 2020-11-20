package com.grpcsample.benchmark;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sample.grpcsample.balanceService.BalanceDTO;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BenchMark {


    public static void main(String[] args) {

        BalanceJson balanceJson = new BalanceJson();
        balanceJson.setAccountId(1);
        balanceJson.setAvailableBalance(100);
        balanceJson.setUsedBalance(1);
        balanceJson.setUserName("Test");
        ObjectMapper mapper = new ObjectMapper();


        Runnable runnable1 = () ->
        {
            try {
                byte[] bytes = mapper.writeValueAsBytes(balanceJson);
//                System.out.println(bytes.length);
                BalanceJson balanceJson1 = mapper.readValue(bytes,BalanceJson.class);
            } catch (Exception e) {
                System.out.println("exception proto");
            }

        };


        BalanceDTO balanceDTO = BalanceDTO.newBuilder().setAccountId(1).setAvailableBalance(100).setUsedBalance(1).setUserName("Test").build();

        Runnable runnable = () ->
        {
            try {
                byte[] bytes = balanceDTO.toByteArray();
//                System.out.println(bytes.length);
                BalanceDTO sam1 = BalanceDTO.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                System.out.println("exception proto");
            }


        };


        for (int i = 0; i < 5; i++) {
            runPerformanceTest(runnable1, "json-ser-desr");
            runPerformanceTest(runnable, "proto-ser-desr");
        }


    }


    private static void runPerformanceTest(Runnable runnable, String method){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 900000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(
                method + " : " + (time2 - time1) + " ms"
        );
    }
}
