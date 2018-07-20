import java.security.SecureRandom


open class Jogadores(val name:String, var money:Int = 300, var position:Int = 0, var jogando:Boolean = true, var eliminado:Boolean = false){

    fun listaPlayers(players:MutableList<Jogadores>){}

    fun perdeu(propriedade:List<Casas>) {
        if (money < 0) {
            this.jogando = false
            propriedade.forEach { it.dono = null }
            this.eliminado = !this.eliminado
            println("Perdeu! LIXO")
        }
    }
    fun jogada(casa : List<Casas>,resultado:Int) {
        if(this.jogando && !this.eliminado){
            this.position = newPosition(resultado)
            if(casa[this.position].dono == null){
                println(this.name + ",você parou em: " + casa[this.position].name +", localizada na posição " + casa[this.position].casa +
                        "!\nO preço desta área é: " + casa[this.position].preçovenda + " e a cada vez que algum player parar " +
                        "em sua casa, deverá lhe pagar " + casa[this.position].preçoaluguel + " Juvecoins!")
                println("Deseja comprar este local? (S/N)")
                var resposta = readLine()!!
                var respostaCorreta = resposta.toUpperCase()
                if(respostaCorreta == "S") {
                    if (this.money >= casa[this.position].preçovenda) {
                        this.comprarCasa(casa)
                        println("Parabéns!\nVocê, " + this.name + " é o novo dono de " + casa[this.position].name)
                        println("Seu saldo agora é de: " + this.money + " Juvecoins!\n")
                    } else {
                        println("Infelizmente, você não tem dinheiro suficiente para realizar esta compra! Fica pra próxima!")
                        println("Seu saldo se manteve em " + this.money + " Juvecoins!\n")
                    }
                }
                else{
                    println("Você perdeu a oportunidade de comprar " + casa[this.position].name +"!\n")
                    println("Seu saldo se manteve em " + this.money + " Juvecoins!\n")
                }
            }
            else if(casa[this.position].dono !==null){
                println("Parece que alguém se deu mal, einh " + this.name + "?")
                println("Você caiu em " + casa[this.position].name + " e deve pagar " + casa[this.position].preçoaluguel + " Juvecoins para o dono deste local!")
                pagarAluguel(this, casa[this.position].preçoaluguel,casa[this.position].dono)
                println("Pagamento efetuado!")
                println("O seu novo saldo, " + this.name + " é de " + this.money + " Juvecoins!")
            }
        }
    }

    fun newPosition(value:Int) : Int{
        println("Caro " + this.name + ", seu saldo atual é de " + this.money + " Juvecoins!")
        println(this.name + " pressione enter para jogar o dado!")
        readLine()
        println("O número que você tirou foi $value")
        var newpos = position + value
        if (newpos >= 20) {
            newpos = newpos - 20
        }
        return newpos
    }

    open fun pagarAluguel(devedor:Jogadores,preçoaluguel:Int, dono: Jogadores?){
        devedor.money = devedor.money - preçoaluguel
        if(dono != null){
            dono.money = dono.money + preçoaluguel
        }
    }

    open fun comprarCasa(casa:List<Casas>){
        modoDeCompra(casa[this.position].preçovenda, casa[this.position])
    }

    open fun modoDeCompra(preço: Int, house:Casas){
        this.money = this.money - preço
        house.dono= this
    }

    open fun aumentarPrecoAluguel(house: Casas){
        house.preçoaluguel = 100
    }

}
abstract class remove(){
abstract fun remove(element: Jogadores): Boolean}
