fun main() {
    fun parseInput(input: List<String>): List<Int> {
        val calorieCounts: MutableList<Int> = mutableListOf()
        var currentCalorieCount = 0

        for (calorie in input.map { c -> c.toIntOrNull() }) {
            if (calorie == null) {
                calorieCounts += currentCalorieCount
                currentCalorieCount = 0
            } else {
                currentCalorieCount += calorie
            }
        }

        return calorieCounts
    }

    fun part1(input: List<String>): Int {
        return parseInput(input)
                .max()
    }

    fun part2(input: List<String>): Int {
        return parseInput(input)
                .sorted()
                .takeLast(3)
                .sum()
    }

    val input = readInput("Day01")

    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
