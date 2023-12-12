
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
data class Usuario(val nome: String, val idade: Int) {
    val cursos = mutableListOf<String>()

    fun listarCursos() = cursos.forEach(::print)

    override fun toString(): String {
        return "\nNome: $nome, Idade: $idade\n"
    }

}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)


data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun listarAlunos() = inscritos.forEach(::print)
    fun matricular(vararg usuarios: Usuario ) {
        usuarios.forEach { it.cursos.add(this.nome) }
        inscritos.addAll(usuarios)
    }
}

fun main() {
    val conteudos = listOf(
        ConteudoEducacional("Introdução à Programação", 25, Nivel.BASICO),
        ConteudoEducacional("CSS", 40, Nivel.BASICO),
        ConteudoEducacional("HTML", 15, Nivel.BASICO),
    )
    val formacao = Formacao("Dev Front-end", conteudos)
    val usuario = Usuario("Swellington Soares", 31)
    formacao.matricular(usuario)
    usuario.listarCursos()
    formacao.listarAlunos()
}
