fun main() {

    //https://kotlinlang.org/docs/basic-types.html#numbers
    //
    //val x: Int = 10
    //val y: Double = 10.0

    //Int ou Double HERDAM de Number
    // Tudo é objeto no Kotlin, mas em runtime, torna-se primitivo
    val x: Number = 15
    val y: Number = 14.5

    // Não altera a referência, provando que é primitivo
    // 'a' permanece inalterado, somente 'z' é alterado
    var a : Int = 10
    var z = a
    z += 33
    println(z)

    teste(x)
    teste(y)


    // Conversão
    println(x.toDouble())
    println(y.toLong())

}

fun teste(valor: Number) {

}
