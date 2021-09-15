package br.com.alura.bytebank.aula2.modelo

class Endereco(
    val logradouro: String = "",
    val numero: Int = 0,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    var complemento: String = ""
)
