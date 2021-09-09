class Thread(val index: Int, var freeTime: Long) {
    companion object {
        fun simulate(numOfThreads: Int, jobs: Array<Long>): Array<Pair<Int, Long>> {
            val threads = ThreadsQueue(numOfThreads) { Thread(it, 0) }
            return Array(jobs.size) { threads.add(jobs[it]) }
        }

        fun slowSimulator(numOfThreads: Int, jobs: Array<Long>): Array<Pair<Int, Long>> {
            val threads = Array<Int>(jobs.size) { 0 }
            val startTime = Array<Long>(jobs.size) { 0L }
            val nextFreeTime = Array<Long>(numOfThreads) { 0L };
            for (i in jobs.indices) {
                val duration = jobs[i];
                var bestThread = 0;
                for (j in nextFreeTime.indices) {
                    if (nextFreeTime[j] < nextFreeTime[bestThread])
                        bestThread = j;
                }
                threads[i] = bestThread;
                startTime[i] = nextFreeTime[bestThread];
                nextFreeTime[bestThread] += duration;
            }

            return Array(jobs.size) { Pair(threads[it], startTime[it]) }
        }

        private class ThreadsQueue(val size: Int, init: (Int) -> Thread) {
            private val threads = Array(size, init)

            fun add(jobTime: Long): Pair<Int, Long> {
                val result = Pair(threads[0].index, threads[0].freeTime)
                threads[0].freeTime += jobTime
                heapify()
                return result
            }

            private fun heapify() {
                var i = 0
                var temp: Thread
                while (i * 2 + 1 < size) {
                    var min = i * 2 + 1
                    if (i * 2 + 2 < size
                        && (threads[i * 2 + 2].freeTime < threads[min].freeTime
                                || (threads[i * 2 + 2].freeTime == threads[min].freeTime && threads[i * 2 + 2].index < threads[min].index))
                    ) {
                        min = i * 2 + 2
                    }

                    if (threads[min].freeTime < threads[i].freeTime || (threads[i].freeTime == threads[min].freeTime && threads[min].index < threads[i].index)) {
                        temp = threads[i]
                        threads[i] = threads[min]
                        threads[min] = temp
                    } else {
                        break
                    }

                    i = min
                }

            }
        }
    }
}