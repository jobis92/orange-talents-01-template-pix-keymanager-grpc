package br.com.zup.dados

data class DadosDaContaResponse(
    val tipo: String,
    val instituicao: InstituicaoResponse,
    val agencia: String,
    val numero: String,
    val titular: TitularResponse
) {
}

data class TitularResponse(val id: String, val nome: String, val cpf: String)
data class InstituicaoResponse(val nome: String, val ispb: String)