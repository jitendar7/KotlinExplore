package com.bignerdranch.nyethack

const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {

    val player = Player("Madrigal",healthPoints=100,isBlessed=true,isImmortal=false)
    player.castFireball()

    val auraColor = player.auraColor()
    val healthStatus = player.formatHealthStatus()

    printPlayerStatus(auraColor, isBlessed = true)

    val race = "gnome"
    val faction = when(race){
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
         else -> "Free people of the Rolling Hills"
    }

}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
}