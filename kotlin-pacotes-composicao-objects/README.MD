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

  - [Aula2](src/main/kotlin/br/com/alura/bytebank/aula2/main.kt)
    - Composição
      
      - Evita que uma classe tenha membros desnecessários: fragmenta mais o código em classes que mantêm os membros que fazem sentido. Ex classe Endereço contém todas as informações de um endereço.  
        
      - A classe não é obrigada a manter os membros da classe que a compõe: o relacionamento é a classe ter outra, ela não vai ter as características da classe que a compõe, e sim a possibilidade de utilizá-la ou não.

      - Composição X Herança

        - [Como não aprender orientação a objetos: Herança](https://blog.caelum.com.br/como-nao-aprender-orientacao-a-objetos-heranca/)    
      
    - Property opcional: instanciar na declaração (exemplo [Cliente com atributo do tipo Endereco](src/main/kotlin/br/com/alura/bytebank/aula2/modelo/Cliente.kt)) e atributo com valor default (exemplo [Endereco](src/main/kotlin/br/com/alura/bytebank/aula2/modelo/Endereco.kt))
      
    ```
    // instanciando ao declarar na classe Cliente
    var endereco: Endereco = Endereco()
    
    // valor default na classe Endereco 
    // opcional pode ser var OU val
    var logradouro: String = ""
    
    ```

  - [Aula3](src/main/kotlin/br/com/alura/bytebank/aula3/main.kt)
    
    - Variáveis globais
      
      - Exemplo [Conta](src/main/kotlin/br/com/alura/bytebank/aula3/modelo/Conta.kt)
    
      - [Object Declarations](https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview)

        - Ex [main](src/main/kotlin/br/com/alura/bytebank/aula3/main.kt) -> ```${Conta.total}```

        - Singleton, [Singleton_pattern - cases](https://en.wikipedia.org/wiki/Singleton_pattern#Common_uses)

        - Tem nome (objeto anônimo - caso do "Object Expressions" - não tem nome)

        - Fica em arquivo ou classe (pode usar [Companion Objects](https://kotlinlang.org/docs/object-declarations.html#companion-objects))
            - Nome implícito é Companion (exceto se informar outro nome)
        
    - [Object Expressions](https://kotlinlang.org/docs/object-declarations.html#object-expressions)
    
      -  Objeto anônimo: palavra reservada 'object' (estrutura que não tem uma classe). Ex [main](src/main/kotlin/br/com/alura/bytebank/aula3/main.kt)
         
        - Permite utilizar herança, interface... polimorfismo
         
        -  Implementar classe sem ter que ter a classe propriamente dita. Ex definir comportamento de eventos de clique
    
    - [Constantes em tempo de compilação (Compile-Time Constants)](https://kotlinlang.org/docs/properties.html#compile-time-constants)
      - const
        
    - Property pode ser importada ```import br.com.alura.bytebank.aula3.modelo.teste```

## Notas

  - Teclas de atalho IntelliJ
    
    - Control + Alt + o -> remove imports não utilizados

## Reference

- [Kotlin: recursos da linguagem com pacotes e composição - Github Alura](https://github.com/alura-cursos/kotlin-pacotes-composicao-objects)