package br.com.zup.pix.remover

import br.com.zup.pix.ChavePixRepository
import br.com.zup.pix.validacoes.ChaveNaoEncontradaException
import br.com.zup.pix.validacoes.ValidUUID
import io.micronaut.validation.Validated
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import javax.validation.constraints.NotBlank

@Validated
@Singleton
class RemoveChaveService(@Inject val repository: ChavePixRepository) {


    @Transactional
    fun remove(
        @NotBlank @ValidUUID(message = "cliente ID com o formato inválido") pixId: UUID,
        @NotBlank @ValidUUID(message = "pix ID com o formato inválido") clienteId: UUID
    ) {


        val chave = repository.findByIdAndClienteId(pixId, clienteId)
            .orElseThrow { ChaveNaoEncontradaException("Chave Pix não encontrada ou não pertence ao cliente!") }

        repository.deleteById(pixId)


    }

}