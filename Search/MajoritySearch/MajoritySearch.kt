object MajoritySearch {

    fun search(list: List<Int>): Int {
        if (list.isEmpty()) {
            return 0
        }

        val size = list.size

        val sortedList = sortList(list)

        if (size % 2 == 0) {
            return when {
                numOfOccurrences(sortedList, sortedList[size / 2 - 1]) >= (size.toDouble() / 2) -> {
                    1
                }
                numOfOccurrences(sortedList, sortedList[size / 2]) >= (size.toDouble() / 2) -> {
                    1
                }
                else -> {
                    0
                }
            }
        } else {
            return if (numOfOccurrences(sortedList, sortedList[size / 2]) >= (size.toDouble() / 2)) {
                1
            } else {
                0
            }
        }

    }

    private fun sortList(list: List<Int>): List<Int> {
        return mergeSort(list, 0, list.size - 1)
    }

    private fun mergeSort(list: List<Int>, low: Int, high: Int): List<Int> {
        return if (low < high) {
            val mid = (low + high) / 2
            val part1 = mergeSort(list, low, mid)
            val part2 = mergeSort(list, mid + 1, high)
            merge(part1, part2)
        } else {
            listOf(list[low])
        }
    }

    private fun merge(list1: List<Int>, list2: List<Int>): List<Int> {
        val mergedList = mutableListOf<Int>()
        var i1 = 0
        var i2 = 0
        while (i1 < list1.size && i2 < list2.size) {
            if (list1[i1] <= list2[i2]) {
                mergedList.add(list1[i1])
                i1++
            } else {
                mergedList.add(list2[i2])
                i2++
            }
        }

        while (i1 < list1.size) {
            mergedList.add(list1[i1])
            i1++
        }

        while (i2 < list2.size) {
            mergedList.add(list2[i2])
            i2++
        }

        return mergedList
    }

    private fun numOfOccurrences(list: List<Int>, n: Int): Int {
        val first = firstIndexBinarySearch(list, n)
        return if (first != -1) {
            lastIndexBinarySearch(list, n) - first + 1
        } else {
            0
        }
    }

    private fun firstIndexBinarySearch(list: List<Int>, n: Int): Int {
        var low = 0
        var high = list.size - 1
        var mid: Int
        var result = -1
        while (low <= high) {
            mid = (low + high) / 2
            when {
                list[mid] == n -> {
                    result = mid
                    high = mid - 1
                }
                list[mid] > n -> {
                    high = mid - 1
                }
                else -> {
                    low = mid + 1
                }
            }
        }

        return result
    }

    private fun lastIndexBinarySearch(list: List<Int>, n: Int): Int {
        var low = 0
        var high = list.size - 1
        var mid: Int
        var result = -1
        while (low <= high) {
            mid = (low + high) / 2
            when {
                list[mid] == n -> {
                    result = mid
                    low = mid + 1
                }
                list[mid] > n -> {
                    high = mid - 1
                }
                else -> {
                    low = mid + 1
                }
            }
        }

        return result
    }
}
