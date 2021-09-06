import kotlin.math.pow

class Point(var x: Int, var y: Int) {

    companion object {
        private lateinit var sortedArrayByY: Array<Point>

        fun calcClosestPoints(array: Array<Point>): Double {
            sortedArrayByY = mergeSort(array, 0, array.size - 1, false)
            return recursiveClosestPoints(mergeSort(array, 0, array.size - 1, true), 0, array.size - 1)
        }

        private fun recursiveClosestPoints(array: Array<Point>, start: Int, end: Int): Double {
            println("Recursive Closest Points...")
            val res = if (start < end) {
                val mid = (start + end) / 2
                val d1 = recursiveClosestPoints(array, start, mid)
                println(d1)
                val d2 = recursiveClosestPoints(array, mid + 1, end)
                println(d2)
                val sortedArrayByY = mergeSort(array, start, end, false)
                var d = if (d1 != (-1).toDouble() && d2 != (-1).toDouble()) {
                    println("Is not -1")
                    if (d1 <= d2) d1 else d2
                } else {
                    if (d1 != (-1).toDouble()) {
                        d1
                    } else if (d2 != (-1).toDouble()) {
                        d2
                    } else {
                        println("Calculating distance...")
                        println("${array[start].x} ${array[start].y} ${array[end].x} ${array[end].y}")
                        calcDist(array[start], array[end])
                    }
                }
                var tempD: Double
                for (i in sortedArrayByY.indices) {
                    inner@ for (j in (i + 1..i + 7)) {
                        if (j >= array.size) {
                            break@inner
                        }
                        tempD = calcDist(array[i], array[j])
                        if (d > tempD) {
                            d = tempD
                        }
                    }
                }

                d
            } else {
                (-1).toDouble()
            }

            println("Result : $res")
            println()
            return res
        }

        private fun calcDist(p1: Point, p2: Point): Double {
            println("${p1.x} ${p1.y} ${p2.x} ${p2.y}")
            return ((p1.x - p2.x).toDouble().pow(2) + (p1.y - p2.y).toDouble().pow(2)).pow(0.5)
        }

        private fun mergeSort(array: Array<Point>, start: Int, end: Int, sortX: Boolean): Array<Point> {
            println("Sorting... ")
            val result = if (start < end) {
                val array1 = mergeSort(array, start, (start + end) / 2, sortX)
                val array2 = mergeSort(array, (start + end) / 2 + 1, end, sortX)
                merge(array1, array2, sortX)
            } else {
                arrayOf(array[start])
            }
            println("Sort result: ")
            result.forEach {
                println(it.x)
                println(it.y)
            }
            println()
            return result
        }

        private fun merge(array1: Array<Point>, array2: Array<Point>, sortX: Boolean): Array<Point> {
            println("Merging... ")
            var i = 0
            var j = 0
            val resultArray = Array(array1.size + array2.size) { Point(0, 0) }

            while (i < array1.size && j < array2.size) {
                if ((sortX && array1[i].x < array2[j].x) || (!sortX && array1[i].y < array2[j].y)) {
                    resultArray[i + j].x = array1[i].x
                    resultArray[i + j].y = array1[i].y
                    i++
                } else {
                    resultArray[i + j].x = array2[j].x
                    resultArray[i + j].y = array2[j].y
                    j++
                }
            }

            while (i < array1.size) {
                resultArray[i + j].x = array1[i].x
                resultArray[i + j].y = array1[i].y
                i++
            }

            while (j < array2.size) {
                resultArray[i + j].x = array2[j].x
                resultArray[i + j].y = array2[j].y
                j++
            }

            println("Merge result: ")
            resultArray.forEach {
                println(it.x)
                println(it.y)
            }
            println()

            return resultArray
        }
    }
}