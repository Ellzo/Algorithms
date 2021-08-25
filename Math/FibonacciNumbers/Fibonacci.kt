object Fibonacci {
    fun getFinNumber(position: Int): Long {
        return when (position) {
            0 -> {
                0L
            }
            1 -> {
                1L
            }
            else -> {
                getFinNumber(position - 1) + getFinNumber(position - 2)
            }
        }
    }

    fun getFinNumberOptimized(position: Int): Long {
        return when {
            position >= 2 -> {
                val finNums = mutableListOf<Long>()
                finNums.add(0)
                finNums.add(1)
                for (n in 2..position) {
                    finNums.add(finNums[n - 1] + finNums[n - 2])
                }
                finNums[position - 1] + finNums[position - 2]
            }
            position == 1 -> {
                1L
            }
            position == 0 -> {
                0L
            }
            else -> {
                -1L
            }
        }
    }

    fun calcFinNumMod(position: Int, m: Int): Long {
        return when {
            m > 1 -> {
                val period = mutableListOf<Long>()
                period.add(0)
                period.add(1)
                var i = 2
                while (true) {
                    period.add((period[i - 1] + period[i - 2]) % m)
                    if (period[i] == 1L && period[i - 1] == 0L) {
                        break
                    }
                    i++
                }
                period.removeLast()
                period.removeLast()
                period[position % period.size]
            }
            m == 1 || m == 0 -> {
                0
            }
            else -> {
                -1
            }
        }
    }

    fun calcFinNumModSlow(position: Int, m: Int): Long{
        return if(m > 0) {
            getFinNumberOptimized(position) % m
        }else{
            -1L
        }
    }

    fun getLastDigitOfFibSum(sumIndex: Int): Int{
        return (calcFinNumMod(sumIndex + 2, 10).toInt() + 9) % 10
    }

    fun getLastDigitOfPartSum(start: Int, end: Int): Int{
        return (getLastDigitOfFibSum(end) + 10 - getLastDigitOfFibSum(start - 1)) % 10
    }

    fun getLastDigitOfSquareSum(sumIndex: Int): Int{
        val l1 = calcFinNumMod(sumIndex, 10).toInt()
        val l2 = calcFinNumMod(sumIndex - 1, 10).toInt()
        return (l1 * (l1 + l2)) % 10
    }

}