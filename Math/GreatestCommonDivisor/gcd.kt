object GCD {
    fun getGCD(a: Long, b: Long): Long{
        return if(a != 0L && b != 0L) {
            var larger = if (a >= b) a else b
            var smaller = if (a == larger) b else a
            var rem = larger % smaller
            while (rem > 0) {
                larger = smaller
                smaller = rem
                rem = larger % smaller
            }
            smaller
        }else{
            1L
        }
    }

    fun getGCDRecursive(a: Long, b: Long): Long{
        return if(a != 0L && b != 0L) {
            val smaller = if (a <= b) a else b
            val larger = if(smaller == a) b else a
            val rem = larger % smaller
            if (rem == 0L)
                smaller
            else
                getGCDRecursive(smaller, rem)
        }else{
            1L
        }
    }

    fun getGCDSlow(a: Long, b: Long): Long{
        var gcd = 1L
        val smaller = if(a > b) b else a
        for(n in 1..smaller){
            if(a % n == 0L && b % n == 0L){
                gcd = n
            }
        }
        return gcd
    }
}