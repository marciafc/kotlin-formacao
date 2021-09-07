# Kotlin: herança, polimorfismo e Interface

  - [Aula1](src/main/kotlin/aula1/main.kt)
    
    - Separação do código em arquivos

  - [Aula2](src/main/kotlin/aula2/main.kt)
    
    - Herança
      
      ```
      // parameters iguais entre classe mãe e filha:
      //  -> NÃO usar val ou var na classe FILHA
      // vide 'nome' (SEM val) e 'senha' (TEM val)
      class Gerente(nome: String,
                    cpf: String,
                    salario: Double,
                    val senha: Int
        ) : Funcionario(nome = nome,
                        cpf = cpf,
                        salario = salario
                    ) { }
      ```
      - palavra reservada OPEN habilita que outras classes herdem dessa:
      
        - vide classe [Funcionario](src/main/kotlin/aula2/Funcionario.kt)
        - Erro caso não tenha open: This type is final, so it cannot be inherited from...
        
      - Sobrescrever comportamentos herdados => usar palavras reservadas:
        - 'override' (método da classe filha) e 
        - 'open' (método da classe mãe)
        
    - Converter função em property (técnica do Kotlin)
      - vide classe [Funcionario](src/main/kotlin/aula2/Funcionario.kt) em bonificacao
      - Alt + Enter
    
  - [Aula3](src/main/kotlin/aula3/main.kt)
    
    - Polimorfismo

  - [Aula4](src/main/kotlin/aula4/main.kt)

    - classe abstrata: abstract - vide [Funcionario](src/main/kotlin/aula4/Funcionario.kt) ou [Conta](src/main/kotlin/aula4/Conta.kt) 
      
      - Não será mais possível instanciá-la
      - Não precisa OPEN, a classe já é aberta
        
    - membros abstratos - vide [Funcionario](src/main/kotlin/aula4/Funcionario.kt) ou [Conta](src/main/kotlin/aula4/Conta.kt)  
      
      - Não tem implementação (é só a assinatura) e quem herda, que deve implementar
        - usar 'protected' (na property) para que cada um dos membros consigam modificar o property - vide [Conta](src/main/kotlin/aula4/Conta.kt) \ 'protected set' em 'saldo'
      - Método abstract não precisa OPEN, já é aberto
      - As classes que herdam nao podem mais chamar a implementacao da classe pai com super
    
    - Declarar um método sem implementação:
      
    ```      
      override val bonificacao: Double
        get() = TODO("Not yet implemented")
    ```
        
    - [Modificadores de acesso](https://khan.github.io/kotlin-for-python-developers/#visibility-modifiers): public, private, protected, public, private ou internal
      
      - protected: classes filhas terão acesso
        
      - internal: restringe o acesso para o módulo do projeto
        
        - Módulo => melhor discussão com uso de [build tools](https://medium.com/@alex.felipe/entenda-o-que-s%C3%A3o-build-tools-do-mundo-java-682a26e38ff2) 

  - [Aula5](src/main/kotlin/aula5/main.kt)
    
    - Herança com múltiplas classes
      
      - FuncionarioAdmin
        
        - [Gerente](src/main/kotlin/aula5/Gerente.kt) herda de [FuncionarioAdmin (abstract)](src/main/kotlin/aula5/FuncionarioAdmin.kt) que herda de [Funcionario (abstract)](src/main/kotlin/aula5/Funcionario.kt)
        
        - [Diretor](src/main/kotlin/aula5/Diretor.kt) herda de [FuncionarioAdmin (abstract)](src/main/kotlin/aula5/FuncionarioAdmin.kt) que herda de [Funcionario (abstract)](src/main/kotlin/aula5/Funcionario.kt)
          
      - Funcionario comum
        
        - [Analista](src/main/kotlin/aula5/Analista.kt) herda de [Funcionario (abstract)](src/main/kotlin/aula5/Funcionario.kt)
        
        - [Auxiliar](src/main/kotlin/aula5/Auxiliar.kt) herda de [Funcionario (abstract)](src/main/kotlin/aula5/Funcionario.kt)
        
    - Polimorfismo
      
      - FuncionarioAdmin ou Funcionario comum 
        
      - Nem sempre o polimorfismo com herança resolve todos os casos
    
  - [Aula6](src/main/kotlin/aula6/main.kt)
    
    - Polimorfismo com uso de [interface](https://kotlinlang.org/docs/interfaces.html)
      
      - permite usar para Funcionario, Cliente ou qualquer outra classe
    
      - Exemplos:
        
        - [Cliente](src/main/kotlin/aula6/Cliente.kt) implementa [Autenticavel](src/main/kotlin/aula6/Autenticavel.kt)
          
        - [Diretor](src/main/kotlin/aula6/Diretor.kt) herda [FuncionarioAdmin](src/main/kotlin/aula6/FuncionarioAdmin.kt) que herda de [Funcionario](src/main/kotlin/aula6/Funcionario.kt) e implementa [Autenticavel](src/main/kotlin/aula6/Autenticavel.kt)
            
        - Obs: [FuncionarioAdmin](src/main/kotlin/aula6/FuncionarioAdmin.kt) / [Cliente](src/main/kotlin/aula6/Cliente.kt) estão com a 'senha' como 'protected' => somente seus filhos podem ter acesso (informação sensível)
        
      - Diferença entre **interface** e **classe abstrata**: [interface não mantém estado](https://kotlinlang.org/docs/interfaces.html)
        
        - Não tem construtor
          
        - Pode ter properties, mas serão abstratas ou prover implementação de acesso
    
      - Interface pode ter uma implementação default
        - Como não mantém estado, necessário informar para a interface via property abstrata (property terá **override** na classe filha)
          - Atentar com informações sensíveis, pois não terá qualquer restrição quanto ao acesso
        - Se houver conflito (mesma assinatura), fazer override defindo qual implementação irá utilizar em cada classe filha
    
    - **Herança** usada para um contexto específico
      
    - **Interface** é um contrato, usar para referências que fogem do contexto da classe

## Notas

  - Kotlin permite converter função em property
    
     - Clicar em cima do nome da função \ Alt + Enter \ Convert function to property     
     
    Isso:
     ```
     open fun bonificacao() : Double {
        return salario * 0.1
     }
    ```
    
    Ficará assim:
    ```
    open val bonificacao: Double
        get() {
            return salario * 0.1
        }
    ```
    
    Pode ser escrito assim (em uma linha SEM explicitar o tipo do retorno):
    
    ```
    open val bonificacao get() = salario * 0.1
    ```
   
    Ou assim (em uma linha EXPLICITANDO o tipo do retorno):

    ```
    open val bonificacao: Double get() = salario * 0.1

    // ou sem get()
    open val bonificacao: Double = salario * 0.1
    
    ```
 
    E nas **classes filhas** fica nesse formato (observe o SUPER. , OVERRIDE, GET()):
    
    ```
    
    override val bonificacao: Double
        get() {
            return super.bonificacao + salario + plr
        }
    
    ```
    
    - Reverter o processo: Alt + Enter \ Convert property to function
      
      - Nesse caso, as classes filhas ficarão com 'override fun' onde era 'override val'
    
  - Casos com construtor SECUNDÁRIO: é obrigatório o uso do construtor da classe mãe (sempre tem o SUPER)
    
    ```
    
    // construtor PRIMÁRIO
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
        //métodos
    }
    
    // construtor SECUNDÁRIO ( tem chamada SUPER() )
    class Gerente : Funcionario {

        val senha: Int

        constructor(
            nome: String,
            cpf: String,
            salario: Double,
            senha: Int
        ) : super(
            nome = nome,
            cpf = cpf,
            salario = salario
        ) {
            this.senha = senha
        }

        //métodos

    }  
    
    ```        
    Outro exemplo: 
    
    ```
           
    open class Animal {
    }
    class Gato : Animal() {
    }
    
    // construtor SECUNDÁRIO ( tem chamada SUPER() )
    class Gato : Animal {
        constructor() : super()
    }
    
    ```

  - IntelliJ atalhos

    - Control + alt + m => extrai código selecionado para uma função
    
    - Alt + Enter no nome da classe \ Extract 'NomeClasse' from current file
    
    - Alt + shift + x => fecha todos os arquivos abertos
      
    - Alt + Enter \ Put parameters on separate lines
      - Vai quebrar cada parâmetro em uma linha
      ```class Funcionario(val nome: String,val cpf: String,val salario: Double){```

    - control + d => replica linha
    
    - F5 em cima da classe => cria uma nova classe com outro nome e mesmo conteúdo da primeira

    - Shift + F6: rename
      
    - Alt + 1 => mostra / oculta a área do project src
    
    - Control + n => Buscar classes 

## Reference

  - [Kotlin: herança, polimorfismo e Interface - Github Alura](https://github.com/alura-cursos/kotlin-oo-heranca-polimorfismo-interfaces)