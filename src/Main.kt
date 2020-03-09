import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.random.Random
import kotlin.test.assertTrue

// Complete the closestNumbers function below.
fun closestNumbers(arr: Array<Int>): Array<Int> {
    quickSort(arr, 0, arr.size - 1)
//    Arrays.sort(arr)
    val pairs = ArrayList<Int>()
    var smallestDiff = abs(arr[0] - arr[1])
    pairs.add(arr[0])
    pairs.add(arr[1])
    for (i in 2 until arr.size) {
        val diff = abs(arr[i - 1] - arr[i])
        if (diff == smallestDiff) {
            pairs.add(arr[i - 1])
            pairs.add(arr[i])

        } else if (diff < smallestDiff) {
            smallestDiff = diff
            pairs.add(0, arr[i-1])
            pairs.add(1, arr[i])
            for (j in pairs.size-1 downTo  2) {
                pairs.removeAt(j)
            }
        }
    }
    return pairs.toTypedArray()
}

fun quickSort(arr: Array<Int>, l: Int, r: Int): Array<Int> {
    if (l < r) {
        val pivot = partition(arr, l, r)
        quickSort(arr, l, pivot)
        quickSort(arr, pivot + 1, r)
    }
    return arr
}

fun partition(arr: Array<Int>, l: Int, r: Int): Int {

    val pivot = Random.nextInt(l, r)
    var i = l
    var j = r
    val x = arr[pivot]
    while (true) {
        while (arr[i] < x) {
            i++
        }
        while (arr[j] > x) {
            j--
        }
        if (i >= j) return j
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i++
        j--
    }
}

fun swap(arr: Array<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

// Partition using Hoare's Partitioning scheme
fun Partition(a: Array<Int>, low: Int, high: Int): Int {
    val pivot = a[high]
    var i = low - 1
    var j = high + 1
    while (true) {
        do {
            i++
        } while (a[i] < pivot)
        do {
            j--
        } while (a[j] > pivot)
        if (i >= j) return j
        swap(a, i, j)
    }
}

fun main(args: Array<String>) {
////    assertEquals(quickSort(arrayOf(2,6,3,3), 0, 3), arrayOf(2,3,3,6))
//    var sorted = quickSort(arrayOf(2, 6, 3, 3), 0, 3)
//    println(Arrays.toString(sorted))
//    assertTrue(sorted.contentDeepEquals(arrayOf(2, 3, 3, 6)))
//    sorted = quickSort(arrayOf(2, 6, 8, 16, 5, 1, 3, 3), 0, 7)
//    println(Arrays.toString(sorted))
//
//    assertTrue(sorted.contentDeepEquals(arrayOf(1, 2, 3, 3, 5, 6, 8, 16)))
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = closestNumbers(arr)

    println(result.joinToString(" "))
}