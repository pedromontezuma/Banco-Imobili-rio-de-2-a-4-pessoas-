open class Casas(val name:String, val casa:Int, val preçovenda:Int, var preçoaluguel:Int, var dono: Jogadores ?= null){}

    fun tabuleiro(casas:ArrayList<Casas>){
                casas.add(Casas("Osasco",1, 60,20))
                casas.add(Casas("Barueri",2, 80,20))
                casas.add(Casas("Itaquera",3, 100,20))
                casas.add(Casas("Casa do Caique",4, 120,30))
                casas.add(Casas("Juvelandia",5, 140,30))
                casas.add(Casas("Foca Bravo",6, 160,30))
                casas.add(Casas("Islandia",7, 180,45))
                casas.add(Casas("Corda é top",8, 200,48))
                casas.add(Casas("Cepo de Madeira",9, 220,51))
                casas.add(Casas("Num sei",10, 240,53))
                casas.add(Casas("Irineu",11, 260,56))
                casas.add(Casas("Gabriel cara de pastel",12, 280,58))
                casas.add(Casas("Vinicius cara de churiço",13, 300,60))
                casas.add(Casas("Caique trombadinha",14, 320,62))
                casas.add(Casas("Nunca fui enquadrado",15, 340,62))
                casas.add(Casas("Séloco",16, 360,62))
                casas.add(Casas("Friendzone",17, 380,62))
                casas.add(Casas("Carapicuiba",18, 400,62))
                casas.add(Casas("Favela",19, 420,62))
                casas.add(Casas("Sadboy",20, 440,62))
    }
