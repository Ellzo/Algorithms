object QuickSort {
    private lateinit var array: Array<Int>

    fun quickSort(array: Array<Int>): Array<Int> {
        this.array = array
        sort(0, array.size - 1)
        return this.array
    }

    private fun sort(start: Int, end: Int) {
        if (start < end) {
            val pivot = (start..end).random()
            var temp = array[start]
            array[start] = array[pivot]
            array[pivot] = temp
            var left = start + 1
            var right = end
            while (left <= right) {
                temp = array[left]
                array[left] = array[right]
                array[right] = temp

                while (left <= end && array[left] <= array[start]) {
                    left++
                }
                while (right >= start && array[right] > array[start]) {
                    right--
                }
            }
            temp = array[start]
            array[start] = array[left - 1]
            array[left - 1] = temp
            sort(start, left - 2)
            sort(left, end)
        }
    }

    fun quick3(array: Array<Int>): Array<Int> {
        this.array = array
        sort3(0, array.size - 1)
        return this.array
    }

    private fun sort3(s: Int, e: Int) {
        var start = s
        var end = e
        while (start < end) {
            val pivot = (start..end).random()
            var temp = array[start]
            array[start] = array[pivot]
            array[pivot] = temp

            var m1 = start
            var m2 = start

            var l = start + 1

            while (l <= end) {
                if (array[l] < array[start]) {
                    m1++
                    m2++
                    temp = array[l]
                    array[l] = array[m1]
                    array[m1] = temp
                }

                if (array[l] == array[start] && m2 != l) {
                    m2++
                    temp = array[l]
                    array[l] = array[m2]
                    array[m2] = temp
                }

                l++
            }

            temp = array[start]
            array[start] = array[m1]
            array[m1] = temp

            if (m1 - start < end - m2) {
                sort(start, m1 - 1)
                start = m2 + 1
            } else {
                sort(m2 + 1, end)
                end = m1 - 1
            }
        }
    }
}