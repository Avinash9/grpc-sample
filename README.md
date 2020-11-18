# grpc-sample

client service - exposes HTTP APIS.

passbook servive - gRPC service

balance-service - gRPC service



# design

web ------>(http) client-service --------->(gRPC) balance-service

web ------>(http) client-service --------->(gRPC) passbook-service

web ------>(http) client-service --------->(gRPC) balance-service -------->(gRPC) passbook-service

## bloomRPC (postman like tool to check gRPC call)
https://github.com/uw-labs/bloomrpc/releases
