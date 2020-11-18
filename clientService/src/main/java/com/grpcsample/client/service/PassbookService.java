package com.grpcsample.client.service;


import com.grpcsample.client.dto.PassBookDetails;
import com.sample.grpcsample.passbookService.PassbookRequest;
import com.sample.grpcsample.passbookService.PassbookResponseResponse;
import com.sample.grpcsample.passbookService.PassbookServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassbookService {

    @GrpcClient("passbook-service")
    private PassbookServiceGrpc.PassbookServiceBlockingStub  passbookServiceBlockingStub;


    public List<PassBookDetails> getPassBook(String userId)
    {
        PassbookRequest passbookRequest=  PassbookRequest.newBuilder().setUserId(userId).build();
        PassbookResponseResponse passbookResponseResponse =
                this.passbookServiceBlockingStub.getTransactionHistory(passbookRequest);
        return  passbookResponseResponse.getPassbookDTOList().stream().map(
                passBookDTO -> new PassBookDetails(
                        passBookDTO.getUserId(),passBookDTO.getTxnAmount(),passBookDTO.getMerchantName()
                )).collect(Collectors.toList());

    }
}
