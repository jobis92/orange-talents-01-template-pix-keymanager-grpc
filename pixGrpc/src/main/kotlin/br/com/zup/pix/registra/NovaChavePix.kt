package br.com.zup.pix.registra

import br.com.zup.TipoChave
import br.com.zup.TipoConta
import br.com.zup.pix.TipoDeChave
import br.com.zup.pix.TipoDeConta
import br.com.zup.pix.validacoes.ValidPixKey
import br.com.zup.pix.validacoes.ValidUUID
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@ValidPixKey
@Introspected
data class NovaChavePix(
    @ValidUUID
    @field:NotBlank
    val clienteId: String?,
    @field:NotNull
    val tipoChave: TipoDeChave,
    @field:Size(max = 77)
    val chave: String?,
    @field:NotNull
    val tipoConta: TipoDeConta?


) {

    fun toModel(conta: ContaAssociada): ChavePix {
        return ChavePix(
            clienteId = UUID.fromString(this.clienteId),
            tipoChave = TipoChave.valueOf(this.tipoChave.name),
            chave = if (this.tipoChave == TipoDeChave.ALEATORIA) UUID.randomUUID().toString() else this.chave!!,
            tipoConta = TipoConta.valueOf(this.tipoConta!!.name),
            conta = ContaAssociada(
                conta.tipo,
                conta.instituicao,
                conta.ispb,
                conta.agencia,
                conta.numero,
                conta.nome,
                conta.cpf
            )
        )
    }

}



