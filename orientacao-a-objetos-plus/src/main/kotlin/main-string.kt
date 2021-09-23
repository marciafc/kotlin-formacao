fun main() {

    //https://kotlinlang.org/docs/basic-types.html#strings
    //
    val x = 10
    var y = x
    y++

    // somente o 'y' é alterado -> valor
    println(x)
    println(y)


    val p1 = Pessoa("Alex")
    val p2 = p1
    p2.nome = "Fran"

    // ambos objetos são alterados para 'Fran' -> referência
    println(p1.nome)
    println(p2.nome)

    val palavra = "palavra"
    var palavraNova = palavra
    palavraNova = "palavraNova"

    val substring = palavra.substring(4)

    // String é um objeto (NÃO é um tipo primitivo)
    // Strings são imutáveis
    // Cada nova String é um novo objeto, NÃO uma cópia
    println(palavra)
    println(palavraNova)
    println(substring)

    // String é um conjunto de char
    for(c in palavra) {

        // == só funciona com char
        println(c == 'a')

        //Operator '==' cannot be applied to 'Char' and 'String'
        //println(c == "a")

    }


}

class Pessoa(var nome: String)