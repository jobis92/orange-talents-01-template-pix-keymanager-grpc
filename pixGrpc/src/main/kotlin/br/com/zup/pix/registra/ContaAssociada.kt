package br.com.zup.pix.registra

import javax.persistence.Embeddable


@Embeddable
class ContaAssociada(
    val tipo: String,
    val instituicao: String,
    val ispb: String,
    val agencia: String,
    val numero: String,
    val nome: String,
    val cpf: String,
)
