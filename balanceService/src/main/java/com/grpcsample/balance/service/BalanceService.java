package com.grpcsample.balance.service;

import com.grpcsample.balance.repository.BalanceRepository;
import com.sample.grpcsample.balanceService.BalanceRequest;
import com.sample.grpcsample.balanceService.BalanceResponse;
import com.sample.grpcsample.balanceService.BalanceServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class BalanceService extends BalanceServiceGrpc.BalanceServiceImplBase
{
    @Autowired
    private BalanceRepository balanceRepository;

    @Override
    public void getBalance(BalanceRequest request, StreamObserver<BalanceResponse> responseObserver) {
        BalanceResponse.Builder builder = BalanceResponse.newBuilder();
        this.balanceRepository.findById(request.getUserId()).ifPresent(
                balance -> {
                    builder.setAvailableBalance(balance.getCurrentBalance());

                });


        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();

    }
}
