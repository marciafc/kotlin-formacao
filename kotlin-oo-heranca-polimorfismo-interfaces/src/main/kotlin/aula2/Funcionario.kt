open class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double
){
   // As QUATRO formas abaixo são similares:

    /*
    open val bonificacao: Double
        get() {
            return salario * 0.1
        }
    */

    // open val bonificacao get() = salario * 0.1

    // open val bonificacao: Double get() = salario * 0.1

    open val bonificacao: Double = salario * 0.1

}