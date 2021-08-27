class Knapsack(var weight: Int, var value: Int) {

    companion object {
        fun knapsackWithRep(arr: Array<Knapsack>, W: Int): Int {
            val values = Array(W + 1) { 0 }

            for (i in values.indices) {
                for (item in arr) {
                    if (i - item.weight in 0..W && values[i - item.weight] + item.value > values[i]) {
                        values[i] = values[i - item.weight] + item.value
                    }
                }
            }

            return values[W]
        }

        fun knapsackNoRep(arr: Array<Knapsack>, W: Int): Int {
            val values = Array(W + 1) { Array(arr.size + 1) { 0 } }

            for (i in values.indices) {
                for (w in arr.indices) {
                    values[i][w + 1] = values[i][w]
                    if (i - arr[w].weight in 0..W && values[i][w + 1] < values[i - arr[w].weight][w] + arr[w].value) {
                        values[i][w + 1] = values[i - arr[w].weight][w] + arr[w].value
                    }
                }
            }

            return values[W][arr.size]
        }
    }
}