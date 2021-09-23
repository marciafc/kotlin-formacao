# Kotlin: lidando com exceptions e referências nulas

  - [Aula1](src/main/kotlin/br/com/alura/bytebank/aula1/main.kt)
    
    - [Pilha de execução / call stack](https://github.com/alura-cursos/kotlin-exceptions-null-safety/blob/9773725b0e5b9d49bb6fd9aee433516749237a3c/apresentacao.pdf)
      
      - Frames no IntelliJ (debugger)
        
    - [Exceptions](https://kotlinlang.org/docs/exceptions.html)
      
  - [Aula2](src/main/kotlin/br/com/alura/bytebank/aula2/main.kt)
    
    - printStackTrace = identificação da exception + message + stackTrace + cause (quando houver)
    
    - [try-expression](https://kotlinlang.org/docs/exceptions.html)
    
    - [try é uma expressão](https://kotlinlang.org/docs/exceptions.html#try-is-an-expression)
    
      - Exemplo [main.kt](src/main/kotlin/br/com/alura/bytebank/aula2/main.kt)
      
      - try ou catch podem retornar valor: **última instrução é o retorno**.
        
      - O bloco finally, se houver, não afeta retorno.
        
      ```val a: Int? = try { input.toInt() } catch (e: NumberFormatException) { null }```
      
    - O 'if' também é uma expressão (if-expression) - similar ao try  
      
      - [main.kt](src/main/kotlin/br/com/alura/bytebank/aula2/main.kt)
        
      ```
      // Double? é um Double que pode ser nulo
      val valorComTaxa: Double? = if (valorRecebido != null) {
        valorRecebido + 0.1
      } else {
        null
      }      
      ```
      
    - [when expression](https://kotlinlang.org/docs/control-flow.html#when-expression)
    ```
    val valorComTaxa: Double? = when {
        valorRecebido != null -> {
            valorRecebido + 0.1
        }
        else -> {
            null
        }
    }
    ```
    
    - expression do Kotlin vs. early return 
      - early return: mais significado, código comum em qualquer linguagem de programação. Exemplo:    
      
    ```
    val valorComTaxa: Double? = valorComTaxa(100.0)

    fun valorComTaxa(valorRecebido: Double?): Double? {
        if (valorRecebido != null) {
            return valorRecebido + 0.1
        }
        return null
    }
    ```
    
  - [Aula3](src/main/kotlin/br/com/alura/bytebank/aula3/main.kt)
    
    - [Lançar exception](https://kotlinlang.org/docs/exceptions.html) => usar throw
      
      - Exemplo 
        - Lançando exceção: [Conta](src/main/kotlin/br/com/alura/bytebank/aula3/modelo/Conta.kt) => [SaldoInsuficienteException](src/main/kotlin/br/com/alura/bytebank/aula3/exception/SaldoInsuficienteException.kt)
        - try, catch: [testaComportamentosConta](src/main/kotlin/br/com/alura/bytebank/aula3/teste/testaComportamentosConta.kt)
        
    - Throwable (ver **hierarquia com atalho do IntelliJ**): pai de TODAS exceptions 
      
      - Exception: casos capturados e tratados no código pelo dev
        
        - As exceções criadas devem herdar de Exception e não de Throwable (pai de todas, inclusive de Error)     
        
      - Error: idem a exception, mas refere-se a problemas na JVM, programador não lida com estes
        - Ex: falta de memória
      
    - 'Exception' (e outras) no Kotlin usa **TypeAliases.kt** mapeando para o Java. Exemplo:
      
      ```@SinceKotlin("1.1") public actual typealias Exception = java.lang.Exception```    

  - [Aula4](src/main/kotlin/br/com/alura/bytebank/aula4/main.kt)
    
    - Capturando mais de uma exception
      
      - [Conta, método transfere() ](src/main/kotlin/br/com/alura/bytebank/aula4/modelo/Conta.kt)
      - [testaComportamentosConta](src/main/kotlin/br/com/alura/bytebank/aula4/teste/testaComportamentosConta.kt)
      - [SaldoInsuficienteException](src/main/kotlin/br/com/alura/bytebank/aula4/exception/SaldoInsuficienteException.kt), [FalhaAutenticacaoException](src/main/kotlin/br/com/alura/bytebank/aula4/exception/FalhaAutenticacaoException.kt)
        
      ```      
        try {
            
        } catch (e: SaldoInsuficienteException){
        
        } catch (e: FalhaAutenticacaoException){
        
        } catch (e: Exception){
        
        }  
      ```  
      
    - Criar exceção aceitando argumento opcional. Caso não informe, tem valor default:
      
      ```
      class SaldoInsuficienteException(
        mensagem: String = "O saldo é insuficiente"
      ) : Exception(mensagem)
      ```    
      
    - [Checked exceptions no Kotlin](https://kotlinlang.org/docs/exceptions.html#checked-exceptions)
      - Kotlin opera na JVM, mas não possui exceções checked

    - Padrão [Delegation](https://en.wikipedia.org/wiki/Delegation_pattern)    

      - Exemplo [Conta, override do método autentica() ](src/main/kotlin/br/com/alura/bytebank/aula4/modelo/Conta.kt)
      
      - Maneira mais objetiva de implementar no Kotlin => delegação de propriedade (Property delegation)
        
        - Alterar implementação [Conta, override do método autentica() ](src/main/kotlin/br/com/alura/bytebank/aula4/modelo/Conta.kt) para usar 'Autenticavel by titular', assim:
          
        ```
        abstract class Conta(
            val titular: Cliente,
            val numero: Int
        ) : Autenticavel by titular
        
        // Remover o método abaixo 
        override fun autentica(senha: Int): Boolean {
            // ...
        }    
      
        ```
  - [Aula5](src/main/kotlin/br/com/alura/bytebank/aula5/main.kt)
  
    - Tipos nullable e non-null
    
      - var endereco: Endereco? = null // aceita um endereço null

      - var endereco: Endereco = null // NÃO aceita um endereço null, erro de compilação
    
    - [Null Safety](https://kotlinlang.org/docs/null-safety.html#null-safety) = evitar NPE
    
      - Ao identificar a possibilidade de referência nula, o compilador do Kotlin não compila
        
      - Testar null com "**if expression**" ou **if "normal"** (testando se é null)
        
      - [Safe call operator](https://kotlinlang.org/docs/null-safety.html#safe-calls) (?.)
        - Desnecessário utilizá-lo em variáveis não null
        - Necessário realizar chamadas encadeadas usando safe call, quando for acessar os membros
          ```
          endereco?.logradouro?.length?.toUByte()
          ```
      - [let](https://kotlinlang.org/docs/scope-functions.html#let) (scope functions - let é uma função de escopo)
        - Não precisa fazer o safe call encadeado, faz o safe call só na primeira chamada
        - Pode nomear e definir seu tipo com lambda OU usar nome implícito 'it'
          
      - [Elvis Operator](https://kotlinlang.org/docs/null-safety.html#elvis-operator) (é uma syntax sugar): combina safe call com ?:
        - Retornar valor
        - Criar exceção
          
      - [Safe casts](https://kotlinlang.org/docs/null-safety.html#safe-casts)
        - Faz um cast seguro (similar a um smart cast), se não conseguir, o valor será null
        - Evita ClassCastException
    
      - [Non-null assertion operator](https://kotlinlang.org/docs/null-safety.html#the-operator) (!!) -> assume que não é null, pode causar NullPointerException (NPE)
        - NPE-lovers
    
## Notas

  - IntelliJ atalhos

    - Control + h => ver hierarquia de uma classe, quem herda de quem
  

## Reference

  - [Kotlin: lidando com exceptions e referências nulas - Github Alura](https://github.com/alura-cursos/kotlin-exceptions-null-safety)