open class Casas(val name:String, val casa:Int, val preçovenda:Int,val preçoaluguel:Int = 500, var dono: Jogadores ?= null){}

    fun tabuleiro(casas:ArrayList<Casas>){
                casas.add(Casas("Osasco",1, 60))
                casas.add(Casas("Barueri",2, 80))
                casas.add(Casas("Itaquera",3, 100))
                casas.add(Casas("Casa do Caique",4, 120))
                casas.add(Casas("Juvelandia",5, 140))
                casas.add(Casas("Foca Bravo",6, 160))
                casas.add(Casas("Islandia",7, 180))
                casas.add(Casas("Corda é top",8, 200))
                casas.add(Casas("Cepo de Madeira",9, 220))
                casas.add(Casas("Num sei",10, 240))
                casas.add(Casas("Irineu",11, 260))
                casas.add(Casas("Gabriel cara de pastel",12, 280))
                casas.add(Casas("Vinicius cara de churiço",13, 300))
                casas.add(Casas("Caique trombadinha",14, 320))
                casas.add(Casas("Nunca fui enquadrado",15, 340))
                casas.add(Casas("Séloco",16, 360))
                casas.add(Casas("Friendzone",17, 380))
                casas.add(Casas("Carapicuiba",18, 400))
                casas.add(Casas("Favela",19, 420))
                casas.add(Casas("Sadboy",20, 440))
    }


