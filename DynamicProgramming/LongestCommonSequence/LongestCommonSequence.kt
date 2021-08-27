object LongestCommonSequence {

    /**
     * Longest Common Sequence Algorithm for 2 sequences of integers
     */
    fun longestCommonSequence(seq1: Array<Int>, seq2: Array<Int>): Int {
        val table = Array(seq1.size) { Array(seq2.size) { -1 } }

        var longest = 0
        for (i in seq1.indices) {
            if (longest == 0 && seq1[i] == seq2[0])
                longest = 1

            table[i][0] = longest
        }

        longest = 0
        for (j in seq2.indices) {
            if (longest == 0 && seq2[j] == seq1[0])
                longest = 1

            table[0][j] = longest
        }


        for (i in 1 until seq1.size) {
            for (j in 1 until seq2.size) {
                if (seq1[i] == seq2[j]) {
                    table[i][j] = table[i - 1][j - 1] + 1
                } else {
                    table[i][j] = max(table[i - 1][j], table[i][j - 1])
                }
            }
        }

        return table[seq1.size - 1][seq2.size - 1]
    }

    /**
     * Longest Common Sequence Algorithm for 3 sequences of integers
     */
    fun longestCommonSequence(seq1: Array<Int>, seq2: Array<Int>, seq3: Array<Int>): Int {
        val table = Array(seq1.size) { Array(seq2.size) { Array(seq3.size) { -1 } } }


        var longest: Int

        var foundC = -1
        for (i in seq1.indices) {
            longest = 0
            for (j in seq2.indices) {
                if (foundC != -1 && j >= foundC) longest = 1
                else if (seq1[i] == seq2[j] && seq1[i] == seq3[0]) {
                    longest = 1
                    foundC = j
                }
                table[i][j][0] = longest
            }
        }

        foundC = -1
        for (j in seq2.indices) {
            longest = 0
            for (k in seq3.indices) {
                if (foundC != -1 && k >= foundC) longest = 1
                else if (seq2[j] == seq3[k] && seq2[j] == seq1[0]) {
                    longest = 1
                    foundC = k
                }
                table[0][j][k] = longest
            }
        }

        foundC = -1
        for (i in seq1.indices) {
            longest = 0
            for (k in seq3.indices) {
                if (foundC != -1 && k >= foundC) longest = 1
                else if (seq1[i] == seq3[k] && seq1[i] == seq2[0]) {
                    longest = 1
                    foundC = k
                }
                table[i][0][k] = longest
            }
        }

        for (i in 1 until seq1.size) {
            for (j in 1 until seq2.size) {
                for (k in 1 until seq3.size) {
                    if (seq1[i] == seq2[j] && seq1[i] == seq3[k]) {
                        table[i][j][k] = table[i - 1][j - 1][k - 1] + 1
                    } else {
                        table[i][j][k] = max(
                            table[i - 1][j - 1][k],
                            table[i - 1][j][k - 1],
                            table[i - 1][j][k],
                            table[i][j - 1][k],
                            table[i][j][k - 1],
                            table[i][j - 1][k - 1]
                        )
                    }
                }
            }
        }

        return table[seq1.size - 1][seq2.size - 1][seq3.size - 1]
    }

    /**
     * Maximum number between a pair of integers
     */
    private fun max(a: Int, b: Int): Int {
        return if (a >= b) a else b
    }

    /**
     * Maximum number between 6 integers
     */
    private fun max(a0: Int, a1: Int, a2: Int, a3: Int, a4: Int, a5: Int): Int {
        var max = a0

        if (a1 > max) {
            max = a1
        }

        if (a2 > max) {
            max = a2
        }

        if (a3 > max) {
            max = a3
        }

        if (a4 > max) {
            max = a4
        }

        if (a5 > max) {
            max = a5
        }

        return max
    }
}