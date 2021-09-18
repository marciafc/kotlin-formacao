package br.com.alura.bytebank.aula5

import br.com.alura.bytebank.aula5.modelo.Endereco

fun main() {

    // equals
    val (endereco, enderecoNovo) = testaEquals()

    // hashCode
    testaHashCode(endereco)
    println("endereco hashCode:     ${endereco.hashCode()}")
    println("enderecoNovo hashCode: ${enderecoNovo.hashCode()}")

    println(enderecoNovo.hashCode())
    // 240650537

    // toString
    testaToString(endereco)

}

private fun testaEquals(): Pair<Endereco, Endereco> {

    println("######### equals #########")

    val endereco = Endereco(
        logradouro = "Rua vergueiro",
        complemento = "Alura",
        cep = "00000-0700"
    )

    val enderecoNovo = Endereco(
        logradouro = "Rua vergueiro",
        complemento = "Alura",
        cep = "00000-0700"
    )

    println(endereco)
    println()
    println(enderecoNovo)

    println()

    // true
    println("Os endereços são iguais? ${endereco.equals(enderecoNovo)}")

    return Pair(endereco, enderecoNovo)
}

private fun testaHashCode(endereco: Endereco) {

    println("######### hashCode #########")

    // Hexadecimal
    println(endereco)
    // Saída SEM e COM toString() implementado, respectivamente (obs: NENHUM dos dois com hashCode/equals implementados):
    //   br.com.alura.bytebank.aula5.modelo.Endereco@2752f6e2
    //   Endereco(logradouro='Rua vergueiro', numero=0, bairro='', cidade='', estado='', cep='00000-0700', complemento='Alura')

    println()

    // Int
    println(endereco.hashCode())
    // Saída SEM e COM toString() implementado, respectivamente (obs: NENHUM dos dois com hashCode/equals implementados):
    //   659748578
    //   853119666
    // Saída com toString, hashCode e equals IMPLEMENTADOS: -30991899

    println()

    // Int
    println("${endereco.javaClass}@${endereco.hashCode()}")
    // Saída SEM e COM toString() implementado, respectivamente (obs: NENHUM dos dois com hashCode/equals implementados):
    //   class br.com.alura.bytebank.aula5.modelo.Endereco@659748578
    //   class br.com.alura.bytebank.aula5.modelo.Endereco@853119666
    // Saída com toString, hashCode e equals IMPLEMENTADOS:
    //   class br.com.alura.bytebank.aula5.modelo.Endereco@-30991899


    // Convertendo Int (hashCode é Int) para Hexadecimal
    println("${endereco.javaClass}@${Integer.toHexString(endereco.hashCode())}")
    // Saída SEM e COM toString() implementado, respectivamente (obs: NENHUM dos dois com hashCode/equals implementados):
    //   class br.com.alura.bytebank.aula5.modelo.Endereco@2752f6e2 // é igual ao toString
    //   class br.com.alura.bytebank.aula5.modelo.Endereco@32d992b2
    // Saída com toString, hashCode e equals IMPLEMENTADOS:
    //   class br.com.alura.bytebank.aula5.modelo.Endereco@fe2719e5

}

private fun testaToString(endereco: Endereco) {

    println("######### toString #########")

    val enderecoStr = endereco.toString()

    // sem implementar toString(), imprime br.com.alura.bytebank.aula5.modelo.Endereco@2752f6e2
    println(enderecoStr)
    println()
    println(endereco)
}

fun imprime(valor: Any): Any {
    println(valor)
    return valor
}