object LCM {
    fun getLCM(a: Long, b: Long): Long {
        val gcd = GCD.getGCD(a, b)
        return (a * b) / gcd
    }

    fun getLCMSlow(a: Long, b: Long): Long {
        if(a != 0L || b != 0L) {
            val smaller = if (a <= b) a else b
            for (i in smaller..a * b) {
                if (i % a == 0L && i % b == 0L) {
                    return i
                }
            }
        }

        return a * b
    }
}
