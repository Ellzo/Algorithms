object EditDistance {
    private var T: Array<Array<Int>>? = null

    fun editDistanceRecursive(
        seq1: String,
        seq2: String,
        i: Int = seq1.length,
        j: Int = seq2.length
    ): Int {
        if (T == null || (i == seq1.length && j == seq2.length)) {
            T = Array(i + 1) { Array(j + 1) { -1 } }
        }

        if (T!![i][j] == -1) {
            T!![i][j] = when {
                i == 0 -> j
                j == 0 -> i
                else -> {
                    val diff = if (seq1[i - 1] == seq2[j - 1]) 0 else 1
                    min(
                        editDistanceRecursive(seq1, seq2, i - 1, j) + 1,
                        editDistanceRecursive(seq1, seq2, i, j - 1) + 1,
                        editDistanceRecursive(seq1, seq2, i - 1, j - 1) + diff
                    )
                }
            }
        }

        return T!![i][j]

    }

    fun editDistanceIterative(
        seq1: String,
        seq2: String,
    ): Int {
        T = Array(seq1.length + 1) { Array(seq2.length + 1) { -1 } }

        for (i in 0..seq1.length) {
            T!![i][0] = i
        }

        for (j in 0..seq2.length) {
            T!![0][j] = j
        }

        var dif: Int
        for (k1 in 1..seq1.length) {
            for (k2 in 1..seq2.length) {
                dif = if (seq1[k1 - 1] == seq2[k2 - 1]) 0 else 1
                T!![k1][k2] = min(T!![k1 - 1][k2] + 1, T!![k1][k2 - 1] + 1, T!![k1 - 1][k2 - 1] + dif)
            }
        }

        return T!![seq1.length][seq2.length]
    }

    private fun min(a: Int, b: Int, c: Int): Int {
        var min = a
        if (b < min) {
            min = b
        }
        if (c < min) {
            min = c
        }

        return min
    }
}