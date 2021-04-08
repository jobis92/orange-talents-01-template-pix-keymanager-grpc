package br.com.zup.pix.remover

import br.com.zup.RemoveChavePixRequest
import br.com.zup.RemoveChavePixResponse
import br.com.zup.RemoveChavePixServiceGrpc
import br.com.zup.pix.validacoes.ErrorHandler
import io.grpc.stub.StreamObserver
import java.util.*
import javax.inject.Inject

import javax.inject.Singleton

@Singleton
@ErrorHandler
class RemoveChavePixEndPoint(@Inject private val service: RemoveChaveService) :
    RemoveChavePixServiceGrpc.RemoveChavePixServiceImplBase() {

    override fun remove(
        request: RemoveChavePixRequest,
        responseObserver: StreamObserver<RemoveChavePixResponse>
    ) {


        service.remove(pixId = UUID.fromString(request.pixId), clienteId = UUID.fromString(request.clienteId))

        responseObserver.onNext(
            RemoveChavePixResponse.newBuilder()
                .setPixId(request.pixId)
                .setClienteId(request.clienteId)
                .build()
        )
        responseObserver.onCompleted()


    }

}