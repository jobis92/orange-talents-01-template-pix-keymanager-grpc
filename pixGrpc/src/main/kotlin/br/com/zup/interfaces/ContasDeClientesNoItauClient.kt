package br.com.zup.interfaces

import br.com.zup.dados.DadosDaContaResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client


@Client("http://localhost:9091")
interface ContasDeClientesNoItauClient {


    @Get("/api/v1/clientes/{clienteId}/contas")
    fun buscaContaPorTipoChave(
        @PathVariable clienteId: String,
        @QueryValue tipo: String
    ): HttpResponse<DadosDaContaResponse>
}
