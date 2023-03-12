import Move.*
import RoundResult.*

fun parseInput(input: List<String>): List<List<Char>> {
    return input
        .map {
            it.toCharArray()
                .toList()
                .filter { it != ' ' }
        }
}

enum class Move { Rock, Paper, Scissors }

fun getRoundResult(opponentInput: Char, playerInput: Char): Int {
    val opponentMove = mapOf('A' to Rock, 'B' to Paper, 'C' to Scissors)[opponentInput]!!
    val playerMove = mapOf('X' to Rock, 'Y' to Paper, 'Z' to Scissors)[playerInput]!!

    return when (opponentMove to playerMove) {
        Rock to Rock -> 1 + 3
        Rock to Paper -> 2 + 6
        Rock to Scissors -> 3 + 0
        Paper to Rock -> 1 + 0
        Paper to Paper -> 2 + 3
        Paper to Scissors -> 3 + 6
        Scissors to Rock -> 1 + 6
        Scissors to Paper -> 2 + 0
        Scissors to Scissors -> 3 + 3
        else -> 0
    }
}

enum class RoundResult { Lose, Draw, Win }

fun getMoveForOutcome(opponentInput: Char, advisedOutcome: Char): Char {
    val opponentMove = mapOf('A' to Rock, 'B' to Paper, 'C' to Scissors)[opponentInput]!!
    val intendedOutcome = mapOf('X' to Lose, 'Y' to Draw, 'Z' to Win)[advisedOutcome]!!

    return when (opponentMove to intendedOutcome) {
        Rock to Lose -> 'Z'
        Rock to Draw -> 'X'
        Rock to Win -> 'Y'
        Paper to Lose -> 'X'
        Paper to Draw -> 'Y'
        Paper to Win -> 'Z'
        Scissors to Lose -> 'Y'
        Scissors to Draw -> 'Z'
        Scissors to Win -> 'X'
        else -> 'X'
    }
}

fun main() {
    fun part1(input: List<String>): Int =
        parseInput(input)
            .map { getRoundResult(it[0], it[1]) }
            .sum()

    fun part2(input: List<String>): Int =
        parseInput(input)
            .map { getRoundResult(it[0], getMoveForOutcome(it[0], it[1])) }
            .sum()

    val input = readInput("Day02")

    assert(getRoundResult('A', 'Y') == 8)
    assert(getRoundResult('B', 'X') == 1)
    assert(getRoundResult('C', 'Z') == 6)
    println("Part 1: ${part1(input)}")

    assert(getRoundResult('A', getMoveForOutcome('A', 'Y')) == 4)
    assert(getRoundResult('B', getMoveForOutcome('B', 'X')) == 1)
    assert(getRoundResult('C', getMoveForOutcome('C', 'Z')) == 7)
    println("Part 2: ${part2(input)}")
}
