package aula6

// Como diferenciar onde é implements e extends?
//  - Funcionario ESTÁ invocando construtor -> é HERANÇA
//  - Autenticavel NÃO está invocando construtor -> é INTERFACE
abstract class FuncionarioAdmin(
    nome: String,
    cpf: String,
    salario: Double,
    protected val senha: Int
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
), Autenticavel {

    override fun autentica(senha: Int): Boolean {
        if(this.senha == senha){
            return true
        }
        return false
    }
}