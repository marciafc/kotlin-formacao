fun main() {

    println("Bem vindo ao Bytebank")

    //println("COMECA testaLacos")
    //testaLacos()
    //println("TERMINA testaLacos")
    //testaCopiasEReferencias()

    val contaAlex = Conta()
    contaAlex.titular = "Alex"
    contaAlex.numero = 1000
    contaAlex.saldo = 200.0

    val contaFran = Conta()
    contaFran.titular = "Fran"
    contaFran.numero = 1001
    contaFran.saldo = 300.0

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println("depositando na conta do Alex")
    deposita(contaAlex, 50.0)
    println(contaAlex.saldo)

    println("depositando na conta da Fran")
    deposita(contaFran, 70.0)
    println(contaFran.saldo)
}

fun deposita(conta: Conta, valor: Double){
    conta.saldo += valor
}

class Conta {
    var titular = ""
    var numero = 0
    var saldo = 0.0
}

fun testaCopiasEReferencias(){

    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    // CONSOLE (Só numeroY será sofrerá alteração: tipo primitivo é cópia do valor, não da referência)
    //
    // numeroX 10
    // numeroY 11

    val contaJoao = Conta()
    contaJoao.titular = "João"

    // contaMaria recebe referência contaJoao
    var contaMaria = contaJoao

    // altera o titular da contaMaria
    // isso irá alterar o objeto contaJoao também
    contaMaria.titular = "Maria"

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    // CONSOLE (contaJoao e contaMaria sofrem alteração: objeto trabalha com referência)
    //
    // titular conta joao: Maria
    // titular conta maria: Maria


    // ao alterar o contaJoao, tb altera contaMaria
    contaJoao.titular = "João"
    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")
    // CONSOLE
    // titular conta joao: João
    // titular conta maria: João

    println(contaJoao)
    println(contaMaria)
    //CONSOLE (referência de memória é igual -> contaJoao e contaMaria)
    //
    // Conta@2752f6e2
    // Conta@2752f6e2

    println(Conta())
    // Conta@e580929
}

fun testaLacos(){
    var i = 0
    while(i < 5){
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++
    }

    for (i in 5 downTo 1) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }
}

/*
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
}*/
