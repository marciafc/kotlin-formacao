# Kotlin: primeiros passos e Orientação a Objetos

## Controle de Fluxo

  - [Controle de fluxo WHEN](https://kotlinlang.org/docs/control-flow.html#when-expression)

  - [Conditions and loops](https://kotlinlang.org/docs/control-flow.html)

## Loops

  - [Looops - Documentação oficial](https://kotlinlang.org/docs/control-flow.html#for-loops)
    
  - [Loops - Kotlin for Python developers](https://khan.github.io/kotlin-for-python-developers/#loops)

## Tipos primitivos

  - [Primitive data types and their limitations](https://khan.github.io/kotlin-for-python-developers/#primitive-data-types-and-their-limitations)

## Aprender Kotlin

  - [Play Example](https://play.kotlinlang.org/byExample/overview)

  - [Tutorial Kotlin for Python developers](https://khan.github.io/kotlin-for-python-developers/)

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


## Reference

  - [Kotlin documentação oficial](https://kotlinlang.org/docs/home.html)

  - [kotlin-introducao-orientacao-a-objetos - Github Alura](https://github.com/alura-cursos/kotlin-introducao-orientacao-a-objetos)