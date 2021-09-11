package br.com.alura.bytebank.aula1
import br.com.alura.bytebank.aula1.modelo.Cliente
import br.com.alura.bytebank.aula1.teste.testaAutenticacao

fun main() {
    testaAutenticacao()
    val cliente = Cliente(nome = "Alex", cpf = "", senha = 1)
}