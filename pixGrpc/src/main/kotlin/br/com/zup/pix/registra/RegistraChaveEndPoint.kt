package br.com.zup.pix.registra

import br.com.zup.NovaChavePixRequest
import br.com.zup.NovaChavePixResponse
import br.com.zup.RegistraChavePixServiceGrpc
import br.com.zup.pix.validacoes.ErrorHandler
import io.grpc.stub.StreamObserver
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ErrorHandler
class RegistraChaveEndPoint(@Inject private val service: NovaChavePixService) :
    RegistraChavePixServiceGrpc.RegistraChavePixServiceImplBase() {

    override fun registra(
        request: NovaChavePixRequest,
        responseObserver: StreamObserver<NovaChavePixResponse>
    ) {

        val novaChave = request.toModel()
        val chaveCriada = service.registra(novaChave)

        responseObserver.onNext(
            NovaChavePixResponse.newBuilder()
                .setClienteId(chaveCriada.clienteId.toString())
                .setPixId(chaveCriada.id.toString())
                .build()
        )

        responseObserver.onCompleted()
    }
}