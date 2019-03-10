package com.krishna.aoc2018

import java.math.BigInteger
import java.io.File
import java.io.File.separator as SEPARATOR

class DayOne {
    var freq: BigInteger 
    var freqTwice : BigInteger?
    var valList: List<BigInteger>
    var freqSeenSet: MutableSet<BigInteger>

    init {
        freq = BigInteger.valueOf(0L)
        freqTwice = null
        freqSeenSet = mutableSetOf()
        val valListAux: MutableList<BigInteger> = mutableListOf()
        val file = File(".${SEPARATOR}input${SEPARATOR}day1.txt")

        file.forEachLine {
           valListAux.add(it.toBigInteger())
        }
        valList = valListAux.toList()
    }

    fun computeFreq() {
        freq = BigInteger.valueOf(0L)

        for (value in valList) {
            freq = freq + value
        }
    }

    fun computeFirstRepeatedFreq() {
        freq = BigInteger.valueOf(0L)
        while(freqTwice == null)
            computeFirstRepeatedFreqAux()
    }
    
    fun computeFirstRepeatedFreqAux() {
        for (value in valList) {
            freq = freq + value

            if (freqSeenSet.contains(freq)) {
                freqTwice = freq
                break
            }
            else
                freqSeenSet.add(freq)
        }
    }
}

fun main() {
    val dayOne = DayOne()
    dayOne.computeFreq()
    println("Part 1: " + dayOne.freq.toString())

    dayOne.computeFirstRepeatedFreq()
    println("Part 2: " + dayOne.freqTwice.toString())
}