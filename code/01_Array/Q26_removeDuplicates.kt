package ArrayTest


fun main() {
    val arr = intArrayOf(1, 2, 2, 4, 4)
    val a = removeDuplicates(arr)
    println(a)
}

fun removeDuplicates(nums: IntArray): Int {
    var i = 0 // 有效值
    var j = 1 // 探针
    // 由于题目给定的是有序数组，
    // 那么不考虑后面会不会再出现前面出现过的元素
    while (j < nums.size) {
        if (nums[i] == nums[j]) {
            j++
        } else {
            nums[++i] = nums[j]
        }
    }
    // 一边往前走 一边改后头
    return i + 1
}


