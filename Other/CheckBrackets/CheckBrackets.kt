import java.util.*

object CheckBrackets {
    fun checkBrackets(s: String): Int {
        val charStack = Stack<Char>()
        val posStack = Stack<Int>()
        for (i in s.indices) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                charStack.push(s[i])
                posStack.push(i + 1)
            }

            if (s[i] == ')') {
                if (charStack.peek() != '(') {
                    return i + 1
                }
                charStack.pop()
                posStack.pop()
            }

            if (s[i] == ']') {
                if (charStack.peek() != '[') {
                    return i + 1
                }
                charStack.pop()
                posStack.pop()
            }

            if (s[i] == '}') {
                if (charStack.peek() != '{') {
                    return i + 1
                }
                charStack.pop()
                posStack.pop()
            }
        }

        return if (charStack.isEmpty() && posStack.isEmpty()) {
            -1
        } else {
            posStack.peek()
        }
    }
}