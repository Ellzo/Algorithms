object Lottery {
    private lateinit var segmentsByStart: Array<Int>
    private lateinit var segmentsByEnd: Array<Int>
    private lateinit var points: Array<Int>
    private lateinit var all: Array<Int>
    private lateinit var result: Array<Array<Int>>

    private const val SORT_BY_START = 85
    private const val SORT_BY_END = 3
    private const val SORT_POINTS = 15
    private const val MERGE_ALL = 59

    fun numOfSegments(segments: Array<Array<Int>>, points: Array<Int>): Array<Array<Int>> {
        init(segments, points)

        sort(0, segments.size - 1, SORT_BY_START)
        sort(0, segments.size - 1, SORT_BY_END)
        sort(0, points.size - 1, SORT_POINTS)

        mergeArrays()

        search()

        return result
    }

    private fun init(segments: Array<Array<Int>>, points: Array<Int>) {
        this.points = points

        segmentsByStart = Array(segments.size) {
            segments[it][0]
        }

        segmentsByEnd = Array(segments.size) {
            segments[it][1]
        }

        result = Array(points.size) {
            arrayOf(points[it], 0)
        }

    }

    private fun sort(start: Int, end: Int, sortMethod: Int) {
        if (start < end) {
            val mid = (start + end) / 2
            sort(start, mid, sortMethod)
            sort(mid + 1, end, sortMethod)
            merge(start, mid, end, sortMethod)
        }

    }

    private fun merge(start: Int, mid: Int, end: Int, mergeMethod: Int) {
        val array = when (mergeMethod) {
            SORT_BY_START -> segmentsByStart
            SORT_BY_END -> segmentsByEnd
            SORT_POINTS -> points
            else -> all
        }


        val tempArray = Array(array.size) { 0 }

        var l = start
        var r = mid + 1

        while (l <= mid && r <= end) {
            if (array[l] <= array[r]) {
                tempArray[r + l - mid - 1] = array[l]
                l++
            } else {
                tempArray[r + l - mid - 1] = array[r]
                r++
            }
        }

        while (l <= mid) {
            tempArray[r + l - mid - 1] = array[l]
            l++
        }

        while (r <= end) {
            tempArray[r + l - mid - 1] = array[r]
            r++
        }

        for (i in start..end) {
            array[i] = tempArray[i]
        }

    }

    private fun mergeArrays() {
        all = Array(segmentsByStart.size + segmentsByEnd.size + points.size) { 0 }

        for (i in points.indices) {
            all[i] = points[i]
        }

        for (i in segmentsByStart.indices) {
            all[i + points.size] = segmentsByStart[i]
        }

        for (i in segmentsByEnd.indices) {
            all[i + points.size + segmentsByStart.size] = segmentsByEnd[i]
        }

        merge(
            0,
            points.size - 1,
            points.size + segmentsByStart.size - 1,
            MERGE_ALL
        )

        merge(
            0,
            points.size + segmentsByStart.size - 1,
            all.size - 1,
            MERGE_ALL
        )

    }

    private fun search() {
        var segmentsStartCounter = 0
        var segmentsEndCounter = 0
        var pointsCounter = 0

        val tempResult = Array(this.result.size) { arrayOf(0, 0) }

        all.forEach {
            if (segmentsStartCounter < segmentsByStart.size && it == segmentsByStart[segmentsStartCounter]) {
                segmentsStartCounter++
            } else if (pointsCounter < points.size && it == points[pointsCounter]) {
                tempResult[pointsCounter][0] = points[pointsCounter]
                tempResult[pointsCounter][1] = segmentsStartCounter - segmentsEndCounter
                pointsCounter++
            } else {
                segmentsEndCounter++
            }
        }

        this.result.forEach {
            val point = it[0]

            var start = 0
            var end = tempResult.size - 1
            var mid: Int

            while (start <= end) {
                mid = (start + end) / 2

                when {
                    tempResult[mid][0] == point -> {
                        it[1] = tempResult[mid][1]
                        break
                    }
                    tempResult[mid][0] > point -> {
                        end = mid - 1
                    }
                    else -> {
                        start = mid + 1
                    }
                }
            }
        }

    }
}
