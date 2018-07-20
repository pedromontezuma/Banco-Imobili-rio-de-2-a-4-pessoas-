import jdk.nashorn.internal.objects.NativeArray.forEach
import sun.audio.AudioPlayer.player
import java.security.SecureRandom
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {

    val casas = ArrayList<Casas>()
    tabuleiro(casas)
    var players = ArrayList<Jogadores>()
    var winner: String
    var gerador = SecureRandom()
    var resultado = gerador.nextInt(6) + 1
    var rodadas = 0
    var contador = players.count()


    println("Bem vindo ao Banco Imobiliário Digital!")

    println("Quantos jogadores participarão da partida? (Min 2 - Máx 4)")

    val aux = 0
    val number = readLine()!!.toInt()
    for (aux in 1..number) {
        println("\nQual o seu nome, jogador?")
        var nomePlayer = Jogadores(readLine()!!)
        players.add(nomePlayer)
        println("Bem vindo, ${nomePlayer.name}")
    }
    if (number == 2) {
        println("\nPlayer1: " + players[0].name + "\nPlayer2: " + players[1].name)
    } else if (number == 3) {
        println("\nPlayer1: " + players[0].name + "\nPlayer2: " + players[1].name + "\nPlayer3: " + players[2].name)
    } else if (number == 4) {
        println("\nPlayer1: " + players[0].name + "\nPlayer2: " + players[1].name + "\nPlayer3: " + players[2].name + "\nPlayer4: " + players[3].name)
    }
    println("\nO jogo vai começar!\n\n")

    Collections.shuffle(players)
    println("A ordem dos jogadores é:")
    players.forEach {
        println("${it.name}")
    }

    println("\nPode jogar, player!")

    while (rodadas < 1000 && players.count() >= 2) {
        players.forEach {
            if (it.money > 0 && it.jogando && !it.eliminado) {
                it.jogada(casas, gerador.nextInt(6) + 1)
            }
            if (it.money < 0) {
                it.perdeu(casas)
                println("Voce foi eliminado!")
                players.remove(it)
            }
            players.forEach {
                it.money += 10
            }
            rodadas += 1
            if ( rodadas > 50 ){
                it.aumentarPrecoAluguel(casas[it.position])
            }
        }
    }
    if(rodadas > 1000){
        println("Este jogo excedeu seu limite de rodadas e nao houve vencedores!")
        return
    }
    if (players.count() == 1) {
        winner = players[0].name
        print("Parabens $winner, voce ganhou!")
    }
}