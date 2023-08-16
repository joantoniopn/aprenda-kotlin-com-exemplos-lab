// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (val nome: String, val idade: Int) {
    override fun toString(): String {
        return "Usuario: " + this.nome + " | " + "Idade: " + this.idade
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "Curso: " + this.nome + " - " + "Duracao: " + this.duracao
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>();

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    override fun toString(): String  {
        return "Formacao: " + this.nome + "\nInscritos: " + this.inscritos.count() + "\nDificuldade: " + this.nivel
    }

    fun listarConteudos() {
        print("\n----------------------------------\n")
        this.conteudos.forEach {
                i -> println(i)
        }
    }

    fun listarInscritos() {
        print("----------------------------------\n")
        this.inscritos.forEach {
                i -> println(i)
        }
    }

    fun removerMatricula(usuario: Usuario) {
        inscritos.removeIf { it.nome === usuario.nome }
    }
}


fun main() {
    val usuario1: Usuario = Usuario("Joao", 29);
    val usuario2: Usuario = Usuario("Jorge", 30);
    val usuario3: Usuario = Usuario("Luana", 26);

    val systemUsers: MutableList<ConteudoEducacional> = mutableListOf(
        ConteudoEducacional("Logica com Kotlin", 20),
        ConteudoEducacional("Configurando Ambiente", 4),
        ConteudoEducacional("Iniciando um projeto", 30)
    )

    val conteudos: List<ConteudoEducacional> = systemUsers;

    val Formacao1: Formacao = Formacao("Kotlin iniciante", conteudos, Nivel.BASICO);
    Formacao1.matricular(usuario1);
    Formacao1.matricular(usuario2);
    Formacao1.matricular(usuario3);

    print(Formacao1);
    Formacao1.listarConteudos()
    Formacao1.listarInscritos()

    Formacao1.removerMatricula(usuario1)

    Formacao1.listarInscritos()
}