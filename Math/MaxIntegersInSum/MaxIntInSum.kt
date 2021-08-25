object MaxIntInSum {
    fun getIntegersOfNum(num: Int): Array<Int> {
        if (num > 0) {
            var i = 0
            var sum = 0
            while (sum < num) {
                i++
                sum += i
            }

            val dif = sum - num

            return if (dif > 0) {
                var reached = false
                Array(i - 1) {
                    if (!reached && it + 1 != dif) {
                        it + 1
                    } else {
                        reached = true
                        it + 2
                    }
                }
            } else {
                Array(i) {
                    it + 1
                }
            }
        } else {
            return emptyArray()
        }
    }
}