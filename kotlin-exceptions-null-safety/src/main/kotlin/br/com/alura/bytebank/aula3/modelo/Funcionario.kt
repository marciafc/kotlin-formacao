package br.com.alura.bytebank.aula3.modelo

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double
){
    abstract val bonificacao: Double


}