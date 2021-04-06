package br.com.zup.pix.registra

import br.com.zup.interfaces.ContasDeClientesNoItauClient
import br.com.zup.pix.ChavePixRepository
import br.com.zup.pix.validacoes.ChaveExistenteException
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import javax.validation.Valid


@Validated
@Singleton
class NovaChavePixService(
    @Inject val repository: ChavePixRepository,
    @Inject val itauClient: ContasDeClientesNoItauClient,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)


    @Transactional
    fun registra(@Valid novaChave: NovaChavePix): ChavePix {

        if (repository.existsByChave(novaChave.chave!!))
            throw ChaveExistenteException("Chave Pix '${novaChave.chave}' existente")

        val response = itauClient.buscaContaPorTipoChave(novaChave.clienteId!!, novaChave.tipoConta!!.name)
        val conta = response.body()?.toModel() ?: throw IllegalStateException("Cliente não encontrado no Itau")

        val chave = novaChave.toModel(conta)
        repository.save(chave)

        return chave
    }


}

