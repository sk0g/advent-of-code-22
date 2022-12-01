fun main() {
    fun part1(input: List<String>): Int {
        val calorieCounts: MutableList<Int> = mutableListOf()
        var currentCalorieCount = 0

        for (calorie in input) {
            val parsedCalorie = calorie.toIntOrNull()

            if (parsedCalorie == null) {
                calorieCounts += currentCalorieCount
                currentCalorieCount = 0
            } else {
                currentCalorieCount += parsedCalorie
            }
        }

        return calorieCounts.max()
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day01")
    println(part1(input))
}
