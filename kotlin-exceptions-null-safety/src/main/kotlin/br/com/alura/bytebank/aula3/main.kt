package br.com.alura.bytebank.aula3

import br.com.alura.bytebank.aula3.exception.SaldoInsuficienteException
import br.com.alura.bytebank.aula3.teste.testaComportamentosConta

var count = 0

fun main() {


    println("início main")

    // Simular um 'Error'
    // teste()

    testaComportamentosConta()
    println("fim main")
}

fun teste() {
    println(count++) // 10490
    // StackOverflowError é um 'Error': estouro de pilha
    // Dev não trabalha com esse tipo de problema
    return teste()
}

fun funcao1() {
    println("início funcao1")
    try {
        funcao2()
    } catch (e: SaldoInsuficienteException) {
        e.printStackTrace()
        println("SaldoInsuficienteException foi pegada")
    }
    println("fim funcao1")
}

fun funcao2() {
    println("início funcao2")
    for (i in 1..5) {
        println(i)
        throw SaldoInsuficienteException()
    }
    println("fim funcao2")
}