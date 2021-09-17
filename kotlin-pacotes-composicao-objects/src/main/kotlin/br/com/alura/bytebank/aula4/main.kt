package br.com.alura.bytebank.aula4

import br.com.alura.bytebank.aula4.modelo.Endereco
import br.com.alura.bytebank.aula4.teste.testaFuncionarios

fun main() {

    val endereco = Endereco()

    val objeto: Any = Any()
    //objeto.


    // Any() do Kotlin é mapeado para Object do Java (interoperabilidade)
    // irá imprimir: java.lang.Object@e580929
    imprime(objeto)

    imprime(1)
    imprime(1.0)
    val teste: Any = imprime(endereco)
    println(teste)

    // irá imprimir: kotlin.Unit
    println(Unit)
    println(Unit.hashCode())

    // Int => public class Int
    // irá imprimir: kotlin.jvm.internal.IntCompanionObject@1e643faf
    println(Int)
    println(Int.hashCode())

    testaFuncionarios()

}

fun imprime(valor: Any) : Any {

    // Código Kotlin => println(message: Any?)
    // Any? => ? é para aceitar nulo
    println(valor)

    var endereco : Endereco? = null
    //println(endereco)

    return valor
}