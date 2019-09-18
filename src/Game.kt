const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed=true)

    val race = "gnome"
    val faction = when(race){
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
         else -> "Free people of the Rolling Hills"
    }

    castFireball()

}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    //Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible)
        "GREEN" else "NONE"
    return auraColor
}

private fun castFireball(numFireballs: Int = 2) = println("A glass of Fireball springs into existence.(x$numFireballs)")

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    return when (healthPoints) {
        100 -> "is in excellent condition"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition"
    }

}