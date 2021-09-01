object HeapSort {
    fun sort(array: Array<Int>) {
        buildHeap(array)
        var i = array.size - 1
        var temp: Int
        while (i > 0) {
            temp = array[0]
            array[0] = array[i]
            array[i] = temp
            heapify(array, 0, i)
            i--
        }
    }

    private fun buildHeap(array: Array<Int>) {
        var i = (array.size - 1) / 2
        while (i >= 0) {
            heapify(array, i, array.size)
            i--
        }
    }

    private fun heapify(array: Array<Int>, n: Int, size: Int) {
        if (n * 2 + 1 < size) {
            if (array[n] < array[n * 2 + 1] || (n * 2 + 2 < size && array[n] < array[n * 2 + 2])) {
                val max = if (n * 2 + 2 < size && array[n * 2 + 1] <= array[n * 2 + 2]) {
                    n * 2 + 2
                } else {
                    n * 2 + 1
                }

                val temp = array[n]
                array[n] = array[max]
                array[max] = temp
                heapify(array, max, size)
            }
        }
    }
}