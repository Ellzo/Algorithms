object MoneyChange {
    var coins = arrayOf(1, 3, 5, 10, 25)

    private lateinit var change: Array<Int>

    fun moneyChange(money: Int, change: Array<Array<Int>> = Array(money) { emptyArray() }): Array<Int> {
        if (money <= 0) {
            return emptyArray()
        }

        if (change[money - 1].isEmpty()) {
            if (coins.binarySearch(money) >= 0) {
                change[money - 1] = arrayOf(money)
            } else {
                var minSize: Int = money
                var minIndex: Int = money - 1
                var size: Int

                for (coin in coins) {
                    size = moneyChange(money - coin, change).size
                    if (size in 1 until minSize) {
                        minSize = size
                        minIndex = money - coin - 1
                    }
                }

                change[money - 1] = Array<Int>(minSize + 1) {
                    if (it == minSize) {
                        money - 1 - minIndex
                    } else {
                        change[minIndex][it]
                    }
                }
            }
        }

        return change[money - 1]
    }
}