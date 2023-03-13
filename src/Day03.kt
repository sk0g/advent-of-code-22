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

fun getCommonItemAndPriority(items: List<String>): Pair<Char, Int> {
    assert(items.size == 3)
    val (s1, s2, s3) = items
    val commonCharacter = s1.toHashSet()
        .intersect(s2.toHashSet())
        .intersect(s3.toHashSet())
        .first()

    return commonCharacter to commonCharacter.getPriority()
}

fun main() {
    val input = readInput("Day03")

    part1Assertions()
    val part1Value = input.sumOf { findCommonItem(it).getPriority() }
    println("Part 1: $part1Value")

    part2Assertions()
    val part2Value = input
        .chunked(3)
        .map { getCommonItemAndPriority(it) }
        .sumOf { it.second }
    println("Part 2: $part2Value")
}

fun part1Assertions() {
    assert(findCommonItem("vJrwpWtwJgWrhcsFMMfFFhFp") == 'p')
    assert(findCommonItem("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL") == 'L')
    assert(findCommonItem("PmmdzqPrVvPwwTWBwg") == 'P')
    assert(findCommonItem("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn") == 'v')
    assert(findCommonItem("ttgJtRGJQctTZtZT") == 't')
    assert(findCommonItem("CrZsJsPPZsGzwwsLwLmpwMDw") == 's')
}

fun part2Assertions() {
    assert(
        getCommonItemAndPriority(
            listOf(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
            ),
        ) == 'r' to 18,
    )

    assert(
        getCommonItemAndPriority(
            listOf(
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw",
            ),
        ) == 'Z' to 52,
    )
}
