object MajoritySearchNaive {

	fun naiveSearch(list: List<Int>): Int {
        for (i in list.indices) {
            val current = list[i]
            var count = 0
            for (element in list) {
                if (element == current) {
                    count++
                }
            }
            if (count >= list.size.toDouble() / 2) {
                return 1
            }
        }
        return 0
    }

}
