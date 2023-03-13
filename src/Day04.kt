fun sectionsOverlapCompletely(s: String): Boolean {
    val (assignment1, assignment2) = s.split(",")
    val bounds1 = assignment1.toBounds()
    val bounds2 = assignment2.toBounds()

    var overlaps = bounds1.first <= bounds2.first && bounds1.second >= bounds2.second
    overlaps = overlaps || bounds2.first <= bounds1.first && bounds2.second >= bounds1.second
    return overlaps
}

fun sectionsOverlapPartially(s: String): Boolean {
    val (bounds1, bounds2) = s
        .split(",")
        .map { it.toBounds() }
    return bounds1.first <= bounds2.second && bounds1.second >= bounds2.first
}

fun String.toBounds(): Pair<Int, Int> {
    val bounds = this
        .split("-")
        .map { it.toInt() }
    return bounds[0] to bounds[1]
}

fun main() {
    fun part1Assertions() {
        assert(!sectionsOverlapCompletely("2-4,6-8"))
        assert(!sectionsOverlapCompletely("2-3,4-5"))
        assert(!sectionsOverlapCompletely("5-7,7-9"))
        assert(sectionsOverlapCompletely("2-8,3-7"))
        assert(sectionsOverlapCompletely("6-6,4-6"))
        assert(!sectionsOverlapCompletely("2-6,4-8"))
    }

    fun part2Assertions() {
        assert(!sectionsOverlapPartially("2-4,6-8"))
        assert(!sectionsOverlapPartially("2-3,4-5"))
        assert(sectionsOverlapPartially("5-7,7-9"))
        assert(sectionsOverlapPartially("2-8,3-7"))
        assert(sectionsOverlapPartially("6-6,4-6"))
        assert(sectionsOverlapPartially("2-6,4-8"))
    }

    part1Assertions()
    part2Assertions()

    val input = readInput("Day04")

    val part1Answer = input.count { sectionsOverlapCompletely(it) }
    println("Part 1: $part1Answer")

    val part2Answer = input.count { sectionsOverlapPartially(it) }
    println("Part 2: $part2Answer")
}
