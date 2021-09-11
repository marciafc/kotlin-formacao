# Kotlin: recursos da linguagem com pacotes e composição

  - [Aula1](src/main/kotlin/br/com/alura/bytebank/aula1/main.kt)
    
    - [Package](https://kotlinlang.org/docs/packages.html), [imports](https://kotlinlang.org/docs/packages.html#imports)
      - convenção do reverse domain (domínio reverso)
        
    - [Default imports do Kotlin](https://kotlinlang.org/docs/packages.html#default-imports) (kotlin.*, kotlin.text.*, etc...)
      
    - Package ambíguos: usar alias. Exemplo ```kotlin.String``` e ```java.lang.String```
    ```    
    import java.lang.String as StringJava
    
    // String do Kotlin
    val palavra: String = ""    
    
    // String do Java - está usando com o alias 'StringJava' definido no import
    val palavraJava: StringJava = StringJava("") 
    
    ```

## Notas

  - Teclas de atalho IntelliJ
    
    - Control + Alt + o -> remove imports não utilizados

## Reference

- [Kotlin: recursos da linguagem com pacotes e composição - Github Alura](https://github.com/alura-cursos/kotlin-pacotes-composicao-objects)