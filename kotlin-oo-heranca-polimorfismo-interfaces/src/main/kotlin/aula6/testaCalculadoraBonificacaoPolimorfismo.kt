package aula6

fun testaCalculadoraBonificacaoPolimorfismo() {

    //val alex: Funcionario = Funcionario(
    val alex : Funcionario = Analista(
        nome = "Alex",
        cpf = "111.111.111-11",
        salario = 1000.0
    )

    val fran: Gerente = Gerente(
        nome = "Fran",
        cpf = "222.222.222-22",
        salario = 2000.0,
        senha = 1234
    )

    val gui = Diretor(
        nome = "Gui",
        cpf = "333.333.333-33",
        salario = 4000.0,
        senha = 4000,
        plr = 200.0
    )
    println(gui.plr)

    val calculadoraBonificacao = CalculadoraBonificacao()
    calculadoraBonificacao.registra(alex)
    calculadoraBonificacao.registra(fran)
    calculadoraBonificacao.registra(gui)
    println("TOTALZAO ${calculadoraBonificacao.total}")
    // Console: TOTALZAO 6300.0
}