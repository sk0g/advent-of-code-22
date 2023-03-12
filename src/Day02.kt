import Move.*

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

fun main() {
    fun part1(input: List<String>): Int =
        parseInput(input)
            .map { getRoundResult(it[0], it[1]) }
            .sum()

    val input = readInput("Day02")

    assert(getRoundResult('A', 'Y') == 8)
    assert(getRoundResult('B', 'X') == 1)
    assert(getRoundResult('C', 'Z') == 6)

    println("Part 1: ${part1(input)}")
}
