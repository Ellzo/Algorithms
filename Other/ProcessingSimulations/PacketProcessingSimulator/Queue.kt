import java.util.*

class Queue<T>(size: Int) {
    private val list: LinkedList<T> = LinkedList()
    private val size: Int
    private var count: Int
    fun enqueue(element: T) {
        if (count != size) {
            list.addLast(element)
            count++
        }
    }

    fun dequeue() {
        list.removeFirst()
        count--
    }

    fun peek(): T {
        return list.peek()
    }

    val isEmpty: Boolean
        get() = count == 0
    val isFull: Boolean
        get() = count == size

    init {
        this.size = size
        count = 0
    }
}