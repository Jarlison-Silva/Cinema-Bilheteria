class Filme(
    val titulo: String,
    val genero: String,
    val valorBase: Double
)

class Ingresso(
    val assento: Int,
    val eEstudante: Boolean
)

class Cliente(
    val nome: String,
    val voucherPipoca: String?
)

fun main() {

    // Cadastro do filme
    val filme = Filme(
        titulo = "Vingadores",
        genero = "Ação",
        valorBase = 30.0
    )

    // Cadastro do cliente
    val cliente = Cliente(
        nome = "Jarlison",
        voucherPipoca = "PIPOCA10"
    )

    // Ingressos selecionados
    val ingressos = listOf(
        Ingresso(1, true),
        Ingresso(2, false),
        Ingresso(3, false)
    )

    var total = 0.0

    // Calculando o valor dos ingressos
    for (ingresso in ingressos) {

        val valorIngresso: Double

        if (ingresso.eEstudante) {
            valorIngresso = filme.valorBase * 0.5
        } else {
            valorIngresso = filme.valorBase
        }

        total += valorIngresso

        println(
            "Assento ${ingresso.assento}: R$ ${"%.2f".format(valorIngresso)}"
        )
    }

    // Classificação/recomendação usando when
    val recomendacao = when (filme.genero) {
        "Ação" -> "Recomendado para maiores de 12 anos"
        "Terror" -> "Recomendado para maiores de 16 anos"
        "Animação" -> "Livre"
        "Comédia" -> "Recomendado para maiores de 10 anos"
        else -> "Classificação não informada"
    }

    // Null Safety + operador Elvis
    val brinde = cliente.voucherPipoca ?: "Sem brinde"

    println()
    println("===== RESUMO DA COMPRA =====")
    println("Cliente: ${cliente.nome}")
    println("Filme: ${filme.titulo}")
    println("Gênero: ${filme.genero}")
    println(recomendacao)
    println("Voucher: $brinde")
    println("Total: R$ ${"%.2f".format(total)}")

    if (cliente.voucherPipoca != null) {
        println("Brinde: Pipoca grátis!")
    } else {
        println("Brinde: Nenhum")
    }
}