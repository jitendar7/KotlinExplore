package com.bignerdranch.nyethack

import com.bignerdranch.nyethack.extensions.random as randomizer
import java.io.File

class Player(
    _name: String, override var healthPoints: Int = 100,
    val isBlessed: Boolean, private val isImmortal: Boolean
) : Fightable {

    override val diceCount = 3
    override val diceSides = 6
    override val damageRoll: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }

    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown = lazy { selectHometown() }
    var currentPosition = Coordinate(0, 0)

    private fun selectHometown() =
        File("data/towns.txt").readText()
            .split("\n").randomizer()

    init {
        require(healthPoints > 0, {
            "healthPoints must be greater than zero."
        })
        require(name.isNotBlank(), {
            "Player must have a name."
        })
    }

    constructor(name: String) : this(
        name,
        isBlessed = true, isImmortal = false
    ) {
        if (name.toLowerCase() == "kar")
            healthPoints = 40
    }

    fun castFireball(numFireballs: Int = 2) =
        println(
            "A glass of Fireball " +
                    "springs into existence. (x$numFireballs)"
        )


    fun auraColor(): String {
        //Aura
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible)
            "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus(): String {
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
}