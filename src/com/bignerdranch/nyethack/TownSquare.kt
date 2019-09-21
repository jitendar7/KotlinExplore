package com.bignerdranch.nyethack

open class TownSquare : Room("Town Square") {

    override val dangerLevel: Int
        get() = super.dangerLevel - 3

    private var bellSound = "GWONG"

    final override fun load() = "The villagers rally and cheer as you enter!\n{ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}