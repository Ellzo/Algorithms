object PrimitiveCalculator {
    var numOfOperations: Array<Int>? = null

    fun minNumOfOperations(num: Int): Int {
        if (numOfOperations == null || num > numOfOperations!!.size) {
            numOfOperations = Array(num) { 0 }
        }

        if (num <= 0) return -1

        if (num == 1) return 0

        if (numOfOperations!![num - 1] == 0) {
            val d1 = if (num % 3 == 0) minNumOfOperations(num / 3) else num - 2
            val d2 = if (num % 2 == 0) minNumOfOperations(num / 2) else num - 2
            val d3 = minNumOfOperations(num - 1)

            numOfOperations!![num - 1] = min(d1, d2, d3) + 1
        }

        return numOfOperations!![num - 1]
    }

    private fun min(num1: Int, num2: Int, num3: Int): Int {
        var min = num1

        if (num2 < min) {
            min = num2
        }

        if (num3 < min) {
            min = num3
        }

        return min
    }
}