fun findCommonItem(s: String): Char {
    val (firstHalf, secondHalf) = s.chunked(s.length / 2)
    return firstHalf.toHashSet()
        .intersect(secondHalf.toHashSet())
        .first()
}

fun Char.getPriority(): Int =
    if (this.isUpperCase()) {
        this.code + 27 - 'A'.code
    } else {
        this.code + 1 - 'a'.code
    }

fun main() {
    val input = readInput("Day03")

    assert(findCommonItem("vJrwpWtwJgWrhcsFMMfFFhFp") == 'p')
    assert(findCommonItem("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL") == 'L')
    assert(findCommonItem("PmmdzqPrVvPwwTWBwg") == 'P')
    assert(findCommonItem("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn") == 'v')
    assert(findCommonItem("ttgJtRGJQctTZtZT") == 't')
    assert(findCommonItem("CrZsJsPPZsGzwwsLwLmpwMDw") == 's')

    val part1Value = input.sumOf { findCommonItem(it).getPriority() }
    println("Part 1: $part1Value")
}
