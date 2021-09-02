class Packet(val arrivalTime: Int, val processingTime: Int) {
    companion object {
        fun simulateProcessing(size: Int, packets: Array<Packet>): Array<Int> {
            val processingResult = Array(packets.size) { -1 }
            if (size > 0 && packets.isNotEmpty()) {
                val processingQueue = Queue<Packet>(size)

                var time = 0
                var lastPacketTime = 0
                var timeInQueue = 0
                var i = 0
                var currentPacket = packets[i]

                while (i in packets.indices) {

                    if (!processingQueue.isEmpty && time - lastPacketTime == processingQueue.peek().processingTime) {
                        timeInQueue -= processingQueue.peek().processingTime
                        processingQueue.dequeue()
                        lastPacketTime = time
                    }

                    while (currentPacket.arrivalTime == time) {
                        if (processingQueue.isFull) {
                            processingResult[i] = -1
                        } else {
                            processingQueue.enqueue(currentPacket)
                            processingResult[i] = lastPacketTime + timeInQueue
                            timeInQueue += currentPacket.processingTime
                        }
                        if (++i < packets.size) {
                            currentPacket = packets[i]
                        } else {
                            break
                        }
                    }

                    if (processingQueue.isEmpty) {
                        lastPacketTime++
                    }
                    time++
                }

            }
            return processingResult
        }
    }
}