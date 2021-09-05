fun main() {

    println("Bem vindo ao Bytebank")
    println()

    println("****** Uso do FOR ******")
    for (i in 1..2) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }

    println("****** Uso do FOR com until (exclui o último valor da iteração) ******")
    for (i in 1 until 5) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }

    println("****** Uso do FOR com step ******")
    for (i in 1..5 step 2) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }

    println("****** Uso do FOR com downTo ******")
    for (i in 3 downTo 1) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }

    println("****** Uso do FOR com downTo e step ******")
    for (i in 6 downTo 1 step 2) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }

    println("****** Uso do FOR com downTo e step com BREAK ******")
    for (i in 6 downTo 1 step 2) {

        if(i == 4) {
            break
        }

        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }

    println("****** Uso do FOR com downTo e step com CONTINUE ******")
    for (i in 6 downTo 1 step 2) {

        if(i == 4) {
            continue
        }

        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }

    println("break e continue com label")
    loop@ for (i in 1..10) {
        println("I: $i")
        for (j in 1..10) {
            println("J $j")
            if (j == 5) break@loop
        }
    }
    /*
    CONSOLE
    I: 1
    J 1
    J 2
    J 3
    J 4
    J 5
    */

    println()
    println("****** Uso do WHILE ******")
    var i = 0
    while(i < 5){
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        // testaCondicoes(saldo)
        println()
        i++
    }
}

fun testaCondicoes(saldo: Double) {

    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}
