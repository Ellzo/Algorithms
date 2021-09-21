import kotlin.math.pow

class SubstringEquality(val s: String) {
    private val x1 = (0..1000).random()
    private val x2 = (0..1000).random()

    fun isEqual(startIndex1: Int, startIndex2: Int, length: Int): Boolean {
        val h1 = Array(s.length + 1) { 0L }
        val h2 = Array(s.length + 1) { 0L }

        for (i in 1 until h1.size) {
            h1[i] = x1 * h1[i - 1] + s[i - 1].code
            h2[i] = x2 * h2[i - 1] + s[i - 1].code
        }

        val hash1For1 = h1[startIndex1 + length] - h1[startIndex1] * x1.toDouble().pow(length).toInt()
        val hash1For2 = h1[startIndex2 + length] - h1[startIndex2] * x1.toDouble().pow(length).toInt()

        if (hash1For1 == hash1For2) {
            val hash2For1 = h2[startIndex1 + length] - h2[startIndex1] * x2.toDouble().pow(length).toInt()
            val hash2For2 = h2[startIndex2 + length] - h2[startIndex2] * x2.toDouble().pow(length).toInt()
            if (hash2For1 == hash2For2) {
                return true
            }
        }

        return false
    }
}