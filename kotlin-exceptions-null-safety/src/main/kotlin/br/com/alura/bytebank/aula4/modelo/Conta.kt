package br.com.alura.bytebank.aula4.modelo

import br.com.alura.bytebank.aula4.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.aula4.exception.SaldoInsuficienteException
import java.lang.NumberFormatException

// Para utilizar DELEGAÇÃO DE PROPRIEDADE (Property delegation):
//   1) Remover MÉTODO 'override fun autentica(senha: Int): Boolean'...
//   2) Trocar ' Autenticavel' POR ': Autenticavel by titular'
abstract class Conta(
    var titular: Cliente,
    val numero: Int
//) : Autenticavel by titular {
) : Autenticavel {
    var saldo = 0.0
        protected set

    companion object {
        var total = 0
            private set
    }

    init {
        println("Criando conta")
        total++
    }

    override fun autentica(senha: Int): Boolean {

        // Delegation
        return titular.autentica(senha)
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double)

    fun transfere(valor: Double, destino: Conta, senha: Int) {
        if (saldo < valor) {
            throw SaldoInsuficienteException(
                mensagem = "O saldo é insuficiente, saldo atual: $saldo, valor a ser subtraído $valor"
            )
        }
        if (!autentica(senha)) {
            throw FalhaAutenticacaoException()
        }
        //throw NumberFormatException()
        saldo -= valor
        destino.deposita(valor)
    }
}

class ContaCorrente(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        val valorComTaxa = valor + 0.1
        if (this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa
        }
    }
}

class ContaPoupanca(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        }
    }
}