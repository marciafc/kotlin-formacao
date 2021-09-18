package br.com.alura.bytebank.aula1

import br.com.alura.bytebank.aula1.modelo.Endereco

fun main() {
    println("início main")

    // ArithmeticException
    //10/0

    funcao1()
    println("fim main")
}

fun funcao1(){
    println("início funcao1")
    funcao2()
    println("fim funcao1")
}

fun funcao2() {
    println("início funcao2")
    for (i in 1..5){
        println(i)

        val endereco = Any()

        // ClassCastException
        //endereco as Endereco
    }
    println("fim funcao2")
}