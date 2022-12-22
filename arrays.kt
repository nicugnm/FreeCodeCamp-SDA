import java.lang.Exception
import java.util.stream.IntStream.range

class CustomArray<Any> {
    private var array: Array<kotlin.Any?> = arrayOfNulls(16)
    private var capacity: Int = 16
    private var len: Int = 0

    constructor(capacity: Int) {
        if (capacity < 0) throw IllegalArgumentException("Capacity can't be negative!")
        this.capacity = capacity
    }

    fun add(element: Any) {
        if (len == capacity) {
            capacity = capacity * 2
            println("Capacity increased with * 2. Now capacity is: $capacity")
            val newArray: Array<kotlin.Any?> = arrayOfNulls(capacity)
            for (i in array.indices) {
                if (array[i] != null) {
                    newArray[i] = array[i]
                }
            }
            array = newArray
        }
        array[len] = element
        len++
    }

    fun remove(element: kotlin.Any?) {
        var founded = false
        for (index in array.indices) {
            if (array[index] == element) {
                array[index] = null
                len--
                founded = true
            }
        }

        if (!founded) {
            throw Exception("Element ${element} has not been found in the array!")
        }

        if (len == capacity / 2) {
            capacity /= 2
            println("Capacity decreased with / 2. Now capacity is: ${capacity}")
            val newArray: Array<kotlin.Any?> = arrayOfNulls(capacity)
            var counter = 0
            for (i in array.indices) {
                if (array[i] != null) {
                    newArray[counter++] = array[i]
                }
            }
            array = newArray
        }
    }

    fun print() {
        array.forEach { if (it != null) { println(it) } }
    }

    fun size() {
        print("Len is ${len} and capacity is ${capacity}")
    }

    fun isEmpty(): Boolean {
        return len == 0
    }

    fun get(index: Int): kotlin.Any? {
        if (index >= capacity || index < 0) {
            throw Exception("Capacity of the array is ${capacity}. Max index is ${capacity - 1} and minimum is 0")
        }
        return array[index]
    }

    fun set(index: Int, element: Any) {
        if (index >= capacity || index < 0) {
            throw Exception("Capacity of the array is ${capacity}. Max index is ${capacity - 1} and minimum is 0")
        }
        array[index] = element
    }

    fun removeAt(index: Int) {
        if (index >= capacity || index < 0) {
            throw Exception("Capacity of the array is ${capacity}. Max index is ${capacity - 1} and minimum is 0")
        }

        val element: kotlin.Any? = get(index)
        this.remove(element)
    }
}


fun main() {
    val customArray: CustomArray<Int> = CustomArray(16)
    //customArray.print()

    for (i in range(1, 100)) {
        customArray.add(i)
    }

    customArray.print()

    for (i in range(50, 100)) {
        customArray.remove(i)
    }

    customArray.print()

    customArray.size()

    println()

    for (i in range(0, 30)) {
        customArray.removeAt(i)
    }
    println()

    customArray.size()

//    customArray.removeAt(100)
}