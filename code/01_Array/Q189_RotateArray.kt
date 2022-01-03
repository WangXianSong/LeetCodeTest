package ArrayTest

import java.lang.Exception
import java.util.logging.Logger


/**
 * 189. 轮转数组
 *
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 解决方法1：临时数组存储
 * 解决方法2：数组反转:结果不行
 */
fun main() {

    var tempArray: IntArray = intArrayOf(-1)
    rotate1(tempArray,2);
}

/**
 * 旋转数组1：临时数组存储
 */
fun rotate1(nums: IntArray, k: Int): Unit {

    var size = nums.size
    var tempArray: IntArray = IntArray(size)


    // 使用临时数组存放原始数据
    for (i in nums.indices) {
        tempArray[i] = nums[i]
    }

    // 重新计算位置，再存入
    for (i in tempArray.indices) {
        nums[(i + k) % size] = tempArray[i]
    }
}

///**
// * 旋转数组2：反转
// */
//fun rotate(nums: IntArray, k: Int): Unit {
//    var size = nums.size
//    if (size == 1) {
//        return
//    }
//    nums.reverse()
//    if (size < k) {
//        return
//    }
//    reverseArray(nums, 0, k - 1)
//    reverseArray(nums, k, size - 1)
//}
//
///**
// * 反转具体方法
// */
//fun reverseArray(nums: IntArray, start: Int, end: Int) {
//    var s = start
//    var e = end
//    while (s < e) {
//        try {
//            val temp = nums[s]
//            nums[s++] = nums[e]
//            nums[e--] = temp
//        } catch (e: Exception) {
//            println(e.toString())
//        }
//
//    }
//}
