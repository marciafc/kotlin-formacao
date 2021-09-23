package main

fun main() {

    // Data Class => classe de dados
    // - gera equals(), hashCode() e toString()
    // - gera componentN() functions
    // - gera copy()
    //
    // Construtor primário: usar properties (com var / val), não somente argumentos
    // Data Class https://kotlinlang.org/docs/data-classes.html
    // Destructuring Declarations https://kotlinlang.org/docs/destructuring-declarations.html
    // Operator Overloading https://kotlinlang.org/docs/operator-overloading.html

    // Classe
    val alex = Pessoa(
        nome = "Alex",
        idade = 25
    )
    alex.fala()

    val alex2 = Pessoa(
        nome = "Alex",
        idade = 25
    )
    // false
    println(alex == alex2)

    // val (nome, idade) = alex
    val (nome, idade) = alex
    println("nome: $nome idade: $idade")

    //alex2.copy(alex)


    // Data Class
    val documento = Documento(
        rg = "12345678-9",
        cpf = "123.4565.789-01"
    )
    //val documento2 = Documento(
    //    rg = "12345678-9",
    //    cpf = "123.4565.789-01"
    //)

    val documento2 = documento.copy()

    // vai copiar o documento para documento3, e alterar o valor do rg
    val documento3 = documento.copy(rg = "1234")

    // true
    println(documento == documento2)

    // Desestruturação do objeto
    // componentN()
    val (rg, cpf) = documento
    println("rg: $rg e cpf: $cpf")





    // Pessoa@2c7b84de
    println(alex)

    // Documento(rg=12345678-9, cpf=123.4565.789-01)
    println(documento)

    println(documento2)
    println(documento3)


}

class Pessoa(val nome: String, val idade: Int) {

    fun fala() {
        println("emite som")
    }

    // componentN() baseada nos números pela ordem do construtor
    // Declaração de desestruturação, sem data class, seria assim:
    operator fun component1() = this.nome
    operator fun component2() = this.idade

}


data class Documento(val rg: String, val cpf: String)