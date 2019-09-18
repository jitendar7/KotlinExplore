fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    //Aura
    val auraColor = if (auraVisible)
        "GREEN" else "NONE"
    println("(Aura: $auraColor) "+
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")

    val healthStatus = when(healthPoints){
        100 -> "is in excellent condition"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if(isBlessed){
            "has some minor wounds but is healing quite quickly"
        }else{
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition"
    }

    val race = "gnome"
    val faction = when(race){
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
         else -> "Free people of the Rolling Hills"
    }

}