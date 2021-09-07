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

## Reference

  - [Kotlin: herança, polimorfismo e Interface - Github Alura](https://github.com/alura-cursos/kotlin-oo-heranca-polimorfismo-interfaces)