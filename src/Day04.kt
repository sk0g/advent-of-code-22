fun sectionsOverlap(s: String): Boolean {
    val (assignment1, assignment2) = s.split(",")
    val bounds1 = assignment1.toBounds()
    val bounds2 = assignment2.toBounds()

    var overlaps = bounds1.first <= bounds2.first && bounds1.second >= bounds2.second
    overlaps = overlaps || bounds2.first <= bounds1.first && bounds2.second >= bounds1.second
    return overlaps
}

fun String.toBounds(): Pair<Int, Int> {
    val bounds = this
        .split("-")
        .map { it.toInt() }
    return bounds[0] to bounds[1]
}

fun main() {
    fun part1Assertions() {
        assert(!sectionsOverlap("2-4,6-8"))
        assert(!sectionsOverlap("2-3,4-5"))
        assert(!sectionsOverlap("5-7,7-9"))
        assert(sectionsOverlap("2-8,3-7"))
        assert(sectionsOverlap("6-6,4-6"))
        assert(!sectionsOverlap("2-6,4-8"))
    }

    part1Assertions()

    val input = readInput("Day04")

    val part1Answer = input.count { sectionsOverlap(it) }
    println("Part 1: $part1Answer")
}
