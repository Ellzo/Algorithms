import java.util.*

class StackMinMax {
    private var data = Stack<Int>()
    private var size = 0

    val isEmpty: Boolean
        get() = size == 0

    private val maxStack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun peek(): Int {
        return data.peek()
    }

    fun push(item: Int) {
        if (size == 0) {
            maxStack.push(item)
            minStack.push(item)
        } else {
            if (item >= maxStack.peek()) {
                maxStack.push(item)
            }

            if (item <= minStack.peek()) {
                minStack.push(item)
            }
        }
        data.push(item)
        size++
    }

    fun pop() {
        if (size > 0) {
            if (data.peek() == maxStack.peek()) {
                maxStack.pop()
            } else if (data.peek() == minStack.peek()) {
                minStack.pop()
            }
            data.pop()
            size--
        }
    }

    fun max(): Int = maxStack.peek()

    fun min(): Int = minStack.peek()

}