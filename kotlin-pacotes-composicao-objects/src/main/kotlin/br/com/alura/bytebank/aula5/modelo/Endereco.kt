package br.com.alura.bytebank.aula5.modelo

class Endereco(
    var logradouro: String = "",
    var numero: Int = 0,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    var complemento: String = ""
){

    /*override fun toString(): String {
        return "Endereco(logradouro='$logradouro', numero=$numero, bairro='$bairro', cidade='$cidade', estado='$estado', cep='$cep', complemento='$complemento')"
    }*/

    // To raw string literal (String pura)
    override fun toString(): String {
        return """
            Endereco(logradouro='$logradouro', 
            numero=$numero,               
            bairro='$bairro', 
            cidade='$cidade', 
            estado='$estado', 
            cep='$cep', 
            complemento='$complemento')
            """.trimIndent()
    }

    // Recebe um Any => qualquer tipo de objeto:
    // necessário testar null e tipo
    override fun equals(other: Any?): Boolean {

        // Mesma referência que recebeu?
        if (this === other) return true

        // 'javaClass != other?.javaClass' => nome da classe que recebeu é diferente da atual?
        // 'other?.javaClass' => testando null com '?'
        if (javaClass != other?.javaClass) return false

        // cast (não precisa fazer smart cast, pois já verificou se não é null e se é mesmo nome da classe)
        other as Endereco

        // Verificando cada um dos campos se são diferentes
        if (logradouro != other.logradouro) return false
        if (numero != other.numero) return false
        if (bairro != other.bairro) return false
        if (cidade != other.cidade) return false
        if (estado != other.estado) return false
        if (cep != other.cep) return false
        if (complemento != other.complemento) return false

        return true
    }

    override fun hashCode(): Int {
        var result = logradouro.hashCode()

        // 'numero' é 'Int' pega só o valor, não o .hashCode()
        result = 31 * result + numero

        result = 31 * result + bairro.hashCode()
        result = 31 * result + cidade.hashCode()
        result = 31 * result + estado.hashCode()
        result = 31 * result + cep.hashCode()
        result = 31 * result + complemento.hashCode()

        return result
    }
}
