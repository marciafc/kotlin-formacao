package br.com.alura.bytebank.aula5

import br.com.alura.bytebank.aula5.modelo.Endereco
import java.lang.IllegalStateException

fun main() {

    var endereco: Endereco? = null
    //endereco!!.logradouro // Non-null assertion operator - NullPointerException
    endereco?.logradouro   // Safe call operator - não terá problema de NullPointerException

    var enderecoNulo: Endereco? = Endereco(logradouro = "rua vergueiro", complemento = "prédio")
    val logradouroNovo: String? = enderecoNulo?.logradouro


    println("Safe call operator encadeado")
    println("length ${enderecoNulo?.logradouro?.length}")


    // let SEM uso do it - dando um nome
    enderecoNulo?.let { end ->
        println("length com let ${end.logradouro.length}")
    }

    // let COM uso do it
    enderecoNulo?.let {

        // let: não precisa chamada encadeada com safe call operator
        println(it.logradouro.length)

        // Elvis Operator para retornar exception qdo for null
        val tamanhoComplementoOuExcecao: Int = it.complemento?.length ?: throw IllegalStateException("Complemento não pode ser vazio")
        println("tamanhoComplementoOuExcecao $tamanhoComplementoOuExcecao")

        // // Elvis Operator para retornar valor qdo for null
        val tamanhoComplemento: Int = it.complemento?.length ?: 0
        println("tamanhoComplemento $tamanhoComplemento")

    }

    // Safe cast
    teste("")
    teste(1)
}

fun teste(valor: Any){

    // Safe casts: caso não consiga realizar o cast, o valor será null
    // Evita ClassCastException
    val numero: Int? = valor as? Int
    println(numero)
}