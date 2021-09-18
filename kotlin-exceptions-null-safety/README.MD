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

## Notas

  - IntelliJ atalhos

    - Control + h => ver hierarquia de uma classe, quem herda de quem
  

## Reference

  - [Kotlin: lidando com exceptions e referências nulas - Github Alura](https://github.com/alura-cursos/kotlin-exceptions-null-safety)