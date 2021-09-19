import kotlin.math.pow

object RabinKarp {
    private val x = 56
    private val p = 100000007

    fun searchRabinKarp(pattern: String, text: String): List<Int> {
        val pHash = hash(pattern)
        val tHashes = preComputeHashes(text, pattern.length)
        val result = mutableListOf<Int>()

        hLoop@ for (i in tHashes.indices) {
            if (pHash != tHashes[i])
                continue

            for (j in pattern.indices) {
                if (pattern[j] != text[i + j])
                    continue@hLoop
            }

            result.add(i)
        }

        return result
    }

    private fun hash(t: String): Int {
        var hashValue = 0L
        for (i in t.indices) {
            hashValue += t[i].code * x.toDouble().pow(i).toInt()
        }
        return (hashValue % p).toInt()
    }

    private fun preComputeHashes(text: String, pSize: Int): Array<Int> {
        return if (pSize < text.length) {
            val hashes = Array(text.length - pSize + 1) { 0L }
            val t = text.subSequence(0, pSize).toString()
            var hashValue = 0L
            for (i in t.indices) {
                hashValue += t[i].code * x.toDouble().pow(i).toInt()
            }
            hashes[0] = hashValue
            for (i in (1 until hashes.size)) {
                hashes[i] =
                    ((hashes[i - 1] - text[i - 1].code) / x + text[i + pSize - 1].code * x.toDouble().pow(pSize - 1)
                        .toLong())
            }

            Array(hashes.size) { (hashes[it] % p).toInt() }
        } else {
            emptyArray()
        }
    }
}