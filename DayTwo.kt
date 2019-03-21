package com.krishna.aoc2018

import java.math.BigInteger
import java.io.File
import java.io.File.separator as SEPARATOR

class DayTwo {
    val valList: List<String>
    var exactlyTwoRepeated: BigInteger
    var exactlyThreeRepeated: BigInteger

    init {
        exactlyTwoRepeated = BigInteger.valueOf(0)
        exactlyThreeRepeated = BigInteger.valueOf(0)
        val valListAux: MutableList<String> = mutableListOf()

        val file = File(".${SEPARATOR}input${SEPARATOR}day2.txt")
        file.forEachLine {
            valListAux.add(it.toString())
        }
        valList = valListAux.toList()
    }

    fun computeFreqForWord(w: String) {
        var alphabetMap: MutableMap<Char, Int> = mutableMapOf()

        for (c in w) {
            val seen: Int= (alphabetMap.get(c)?: 0) + 1
            alphabetMap.put(c, seen)
        }

        var twiceSeen: Boolean = false
        var thriceSeen: Boolean = false
        for (v in alphabetMap.values) {
            if (v.equals(2) && !twiceSeen) {
                exactlyTwoRepeated++
                twiceSeen = true
            } else if(v.equals(3) && !thriceSeen) {
                exactlyThreeRepeated++
                thriceSeen = true
            }
        }
    }

    fun computeChecksum(): BigInteger {
        for (w in valList) {
            computeFreqForWord(w.toLowerCase())
        }
        return exactlyTwoRepeated*exactlyThreeRepeated
    }
}

fun main() {
    val dayTwo = DayTwo()
    println(dayTwo.computeChecksum())
}

