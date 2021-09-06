# Kotlin: primeiros passos e Orientação a Objetos

  - [main.kt](src/main/kotlin/main.kt)
    - val, var
    - String template
      
  - [main2.kt](src/main/kotlin/main2.kt)
    - for, until, step, downTo, break, continue
    - label loop@ (break@loop, continue@loop) com loops aninhados
    - while
    - if, when
    
  - [main3.kt](src/main/kotlin/main3.kt)
    - classe, objeto, método
    - referência, valor
    
  - [main4.kt](src/main/kotlin/main4.kt)
    - get, set
    - return Unit, outros tipos
    - encapsulamento
    - modificadores de acesso

  - [main5.kt](src/main/kotlin/main5.kt)
    - Código mais idiomático ao Kotlin
    - get e set da property
    - modificador de acesso no set / get da property, field      
    - construtor primário, construtor secundário, init
    - label, argumentos nomeados
    - parâmetro opcional com valor default
    
## Notas

  - String template ```println("numeroX $numeroX")``` ou ```println("titular conta joao: ${contaJoao.titular}")```

  - [CamelCase](https://pt.wikipedia.org/wiki/CamelCase)

  - Locais que podemos CRIAR uma CLASSE

    - Em nível de arquivo (exemplo main3.kt classe Conta)

    - Dentro de um método sempre antes de ser utilizado
    ```
    // no main() ou qlq outro método
    fun main() {
      println("Bem vindo ao Bytebank")
  
      class Conta {
          var titular = ""
          var numero = 0
          var saldo = 0.0
      }
  
      val contaAlex = Conta()
      // restante do código
    }
    ```
    - Dentro de outra classe

    - Em arquivo separado (arquivo só para a classe)

  - Funções membros == métodos == comportamentos

  - Quando não retorna nada explícito, está retornando Unit do Kotlin (é implícito)

  - Variável já tem getter/setter -> propriedade / property -> main5.kt

  - Começar como val, mudar para var somente se houver necessidade de alteração

  - Construtor com argumento opcional: informar valor default (no exemplo, o 'numero')
    ```
    class Conta(var titular: String,
                 val numero: Int = 0) {
    ```

  - label == rótulo: não importa ordem dos parâmetros
    - argumentos nomeados
    - pode utilizar no construtor ou métodos

    ```
    Conta(titular = "Alex", numero = 1000)
    Conta(numero = 1001, titular = "Fran")
  
    (contaFran.transfere(destino = contaAlex, valor = 300.0))
    ```

## Controle de Fluxo

  - [Controle de fluxo WHEN](https://kotlinlang.org/docs/control-flow.html#when-expression)

  - [Conditions and loops](https://kotlinlang.org/docs/control-flow.html)

## Loops

  - [Looops - Documentação oficial](https://kotlinlang.org/docs/control-flow.html#for-loops)
    
  - [Loops - Kotlin for Python developers](https://khan.github.io/kotlin-for-python-developers/#loops)

## Tipos primitivos

  - [Primitive data types and their limitations](https://khan.github.io/kotlin-for-python-developers/#primitive-data-types-and-their-limitations)

## Modificadores de acesso

  - [Visibility modifiers](https://kotlinlang.org/docs/visibility-modifiers.html)

## Propriedades 

  - [Declaring properties](https://kotlinlang.org/docs/properties.html#declaring-properties)

## Construtores

  - [Constructors](https://kotlinlang.org/docs/classes.html#constructors)

## Argumentos nomeados

  - [Named arguments](https://kotlinlang.org/docs/functions.html#named-arguments)

## Convenções de código Kotlin

  - [Coding conventions](https://kotlinlang.org/docs/coding-conventions.html)

## Aprender Kotlin

  - [Play Example](https://play.kotlinlang.org/byExample/overview)

  - [Tutorial Kotlin for Python developers](https://khan.github.io/kotlin-for-python-developers/)

## Reference

  - [Kotlin documentação oficial](https://kotlinlang.org/docs/home.html)

  - [kotlin-introducao-orientacao-a-objetos - Github Alura](https://github.com/alura-cursos/kotlin-introducao-orientacao-a-objetos)