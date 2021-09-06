class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: Int
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
) {

    // Ambas as formas são válidas:
    /*
    override val bonificacao: Double
        get() {
            return super.bonificacao + salario
        }
    */
    override val bonificacao: Double = super.bonificacao + salario

    fun autentica(senha: Int): Boolean {
        if(this.senha == senha){
            return true
        }
        return false
    }

}