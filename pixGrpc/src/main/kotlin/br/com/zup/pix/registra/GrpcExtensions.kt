package br.com.zup.pix.registra

import br.com.zup.NovaChavePixRequest
import br.com.zup.pix.TipoDeChave
import br.com.zup.pix.TipoDeConta

fun NovaChavePixRequest.toModel(): NovaChavePix {
    return NovaChavePix(
        clienteId = clienteId,
        tipoChave = TipoDeChave.valueOf(tipoChave.name),
        chave = chave,
        tipoConta = TipoDeConta.valueOf(tipoConta.name)

    )

}