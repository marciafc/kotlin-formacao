package br.com.alura.bytebank.aula3.teste

import br.com.alura.bytebank.aula3.modelo.Autenticavel
import br.com.alura.bytebank.aula3.modelo.Cliente
import br.com.alura.bytebank.aula3.modelo.Conta
import br.com.alura.bytebank.aula3.modelo.ContaCorrente
import br.com.alura.bytebank.aula3.modelo.ContaPoupanca
import br.com.alura.bytebank.aula3.modelo.SistemaInterno

fun testaObjects() {
    val fran = object : Autenticavel {
        val nome: String = "Fran"
        val cpf: String = "111.111.111-11"
        val senha: Int = 1000

        override fun autentica(senha: Int) = this.senha == senha
    }
    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(fran, 1000)
    println("nome do cliente ${fran.nome}")

    val alex = Cliente(nome = "Alex", cpf = "", senha = 1)
    val contaPoupanca = ContaPoupanca(titular = alex, numero = 1000)
    val contaCorrente = ContaCorrente(titular = alex, numero = 1001)

    println("Total de contas: ${Conta.total}")
}