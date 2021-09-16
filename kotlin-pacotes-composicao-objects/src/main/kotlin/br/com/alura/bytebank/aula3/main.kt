package br.com.alura.bytebank.aula3

import br.com.alura.bytebank.aula3.modelo.*
import br.com.alura.bytebank.aula3.teste.testaContasDiferentes
//import br.com.alura.bytebank.aula3.modelo.teste

fun main() {

    println("Vai criar objeto anônimo")

    // Objeto anônimo com uso de 'object expression'
    // Pode usar interface OU herança
    // Ao colocar ': Autenticavel' agora pode fazer uso do polimorfismo
    val fran = object : Autenticavel {
        val nome: String = "Fran"
        val cpf: String = "111.111.111-11"
        val senha: Int = 1000

        // 'override' pq estará subscrevendo a interface 'Autenticavel '
        override fun autentica(senha: Int) = this.senha == senha
    }

    val sistemaInterno = SistemaInterno()

    // polimorfismo
    sistemaInterno.entra(fran, 1000)

    println("nome do cliente ${fran.nome}")

    println("Terminou de criar objeto anônimo")



    val alex = Cliente(nome = "Alex", cpf = "", senha = 1)
    val contaPoupanca = ContaPoupanca(titular = alex, numero = 1000)
    val contaCorrente = ContaCorrente(titular = alex, numero = 1001)

    testaContasDiferentes()

    println("Total de contas: ${Conta.total}")
}