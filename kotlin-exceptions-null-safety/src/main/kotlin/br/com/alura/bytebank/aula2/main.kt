package br.com.alura.bytebank.aula2

import br.com.alura.bytebank.aula2.modelo.Endereco
import java.lang.ClassCastException
import java.lang.NumberFormatException

fun main() {
    println("início main")

    val entrada: String = "1.0"

    // try-expression
    // Try is an expression (https://kotlinlang.org/docs/exceptions.html#try-is-an-expression)
    val valorRecebido: Double? = try {

        // última instrução é o RETORNO
        entrada.toDouble()

    } catch (e: NumberFormatException) {

        println("Problema na conversão")

        // Mensagem
        println(e.message)

        // StackTrace
        println(e.stackTrace)

        // Cause: qdo null, não teve outra "Exception" que causou
        println(e.cause)

        // Exibe a exception capturada, a mensagem, a stackTrace e a cause (quando houver)
        e.printStackTrace()

        // última instrução é o RETORNO
        null

    } finally {

        // não afeta o retorno
        26
    }

    println("No final teremos: $valorRecebido")

    // if-expression
    val valorComTaxa: Double? = if (valorRecebido != null) {
        valorRecebido + 0.1
    } else {
        null
    }

    if (valorComTaxa != null) {
        println("valor recebido: $valorComTaxa")
    } else {
        println("valor inválido")
    }

    // when expression
    val valorComTaxa2: Double? = when {
        valorRecebido != null -> {
            valorRecebido + 0.1
        }
        else -> {
            null
        }
    }
    println("valor valorComTaxa2: $valorComTaxa2")

    // early return
    val valorComTaxa3: Double? = valorComTaxa(100.0)
    println("valor valorComTaxa3: $valorComTaxa3")

   // funcao1()
    println("fim main")
}

fun valorComTaxa(valorRecebido: Double?): Double? {
    if (valorRecebido != null) {
        return valorRecebido + 0.1
    }
    return null
}

fun funcao1() {
    println("início funcao1")
    try {
        funcao2()
    } catch (e: ClassCastException) {
        e.printStackTrace()
        println("ClassCastException foi pegada")
    }
    println("fim funcao1")
}

fun funcao2() {
    println("início funcao2")
    for (i in 1..5) {
        println(i)
        val endereco = Any()
        endereco as Endereco
    }
    println("fim funcao2")
}