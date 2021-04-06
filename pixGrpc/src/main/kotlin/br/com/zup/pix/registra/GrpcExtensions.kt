package br.com.zup.pix.registra

import br.com.zup.NovaChavePixRequest
import br.com.zup.TipoChave
import br.com.zup.TipoConta

fun NovaChavePixRequest.toModel(): NovaChavePix {
    return NovaChavePix(
        clienteId = clienteId,
        tipoChave = when (tipoChave) {
            TipoChave.UNKNOWN_TIPO_CHAVE -> null
            else -> TipoChave.valueOf(tipoChave.name)
        },
        chave = chave,
        tipoConta = when (tipoConta) {
            TipoConta.UNKNOWN_TIPO_CONTA -> null
            else -> TipoConta.valueOf(tipoConta.name)
        }
    )
}