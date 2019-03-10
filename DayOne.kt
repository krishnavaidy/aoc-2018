package com.krishna.aoc2018

import java.io.File
import java.io.File.separator as SEPARATOR

class DayOne {
    var freq = 0f
    val file : File = File(".${SEPARATOR}input${SEPARATOR}day1.txt")
    
    fun computeFreq() {
        freq = 0f
        file.forEachLine {
            freq = freq + it.toFloat()
        }
    }
}

fun main() {
    val dayOne = DayOne()
    dayOne.computeFreq()

    println(dayOne.freq)
}