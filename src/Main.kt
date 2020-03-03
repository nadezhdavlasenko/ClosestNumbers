import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.random.Random
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the closestNumbers function below.
fun closestNumbers(arr: Array<Int>): Array<Int> {
    var i = 0
    var j = arr.size
    val pivot = partition(arr.size)
    while(i < pivot) {
        if (arr[i] < arr[pivot])

    }
}
fun partition(n: Int): Int {
    return Random.nextInt(0, n)
}
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = closestNumbers(arr)

    println(result.joinToString(" "))
}