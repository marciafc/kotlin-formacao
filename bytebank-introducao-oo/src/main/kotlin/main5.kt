fun main() {

    println("Bem vindo ao Bytebank")

    val contaAlex = Conta5(titular = "Alex", numero = 1000)
    contaAlex.deposita(200.0)

    val contaFran = Conta5(numero = 1001, titular = "Fran")
    contaFran.deposita(300.0)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)

    println("depositando na conta da Fran")
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    println("sacando na conta do Alex")
    contaAlex.saca(250.0)
    println(contaAlex.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println("saque em excesso na conta do Alex")
    contaAlex.saca(100.0)
    println(contaAlex.saldo)

    println("saque em excesso na conta da Fran")
    contaFran.saca(500.0)
    println(contaFran.saldo)

    println("Transferência da conta da Fran para o Alex")

    if (contaFran.transfere(destino = contaAlex, valor = 300.0)) {
        println("Transferência sucedida")
    } else {
        println("Falha na transferência")
    }

    println(contaAlex.saldo)
    println(contaFran.saldo)
}

class Conta5(var titular: String,
             val numero: Int) {

    var saldo = 0.0
        private set // apenas o set é privado
        /*
        // setter e getter já fornecidos pelo Kotlin
        // fica um código mais idiomático utilizando PROPERTY ao invés de métodos de acesso setSaldo / getSaldo
        // escrever código neste, qdo for necessário, diferente
        set(valor) {
            // usar o palavra reservada 'FIELD' para alterar no set
            // kotlin por default já tem um set com conteúdo field = valor
            // println("field $field")
            // field = valor
            // println("field $field")

            // fazendo validação no set
            if(valor > 0) {
                field = valor
            }
            println("field $field")
        }
        get() {
            // kotlin por default já tem um get retornando o field, usar o FIELD
            // logo, esse código é redundate: return field
            // escrever código neste, qdo for necessário, diferente
            return field
        }
        */

    // constutor SECUNDÁRIO
    //   -> o constutor PRIMÁRIO é declarado na definição da classe
    // Usar o SECUNDÁRIO qdo precisar executar trechos de código a mais
    // Para inicialização, o construtor PRIMÁRIO é o esperado
    /*
    constructor(titular: String, numero: Int) {
        this.titular = titular
        this.numero = numero
    }

    // Além do construtor PRIMÁRIO, podemos utilizar o bloco INIT
    // para executar trechos de código durante a inicialização

    init {
      //Executa alguma coisa durante a construção.
    }

    */

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta5): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}