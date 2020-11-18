package com.grpcsample.passbook.service;

import com.grpcsample.passbook.repository.PassbookRepository;
import com.sample.grpcsample.passbookService.PassBookDTO;
import com.sample.grpcsample.passbookService.PassbookRequest;
import com.sample.grpcsample.passbookService.PassbookResponseResponse;
import com.sample.grpcsample.passbookService.PassbookServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class PassbookService  extends PassbookServiceGrpc.PassbookServiceImplBase {

    @Autowired
    private PassbookRepository passbookRepository;

    @Override
    public void getTransactionHistory(PassbookRequest request, StreamObserver<PassbookResponseResponse> responseObserver) {

        PassbookResponseResponse.Builder builder = PassbookResponseResponse.newBuilder();
        List<PassBookDTO> passBookDTOList=this.passbookRepository.getPassbookByUserId(request.getUserId()).stream().map(

                passbook ->
                        PassBookDTO.newBuilder().setTxnAmount(
                                passbook.getTxnAmount()).
                                setMerchantName("test").build()).collect(Collectors.toList());


        responseObserver.onNext(builder.addAllPassbookDTO(passBookDTOList).build());
        responseObserver.onCompleted();
    }
}
