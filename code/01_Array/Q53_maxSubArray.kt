package ArrayTest


/*

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

进阶:如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

*/


fun main() {
//    val arr = intArrayOf(-2, -1, 3, 5, 10, -2, -1, 2, 5, -2)
//    val arr = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val arr = intArrayOf(1)
    val a = maxSubArray(arr)
    println(a)
}

/**
 * 动态规划
 */
fun maxSubArray(nums: IntArray): Int {

    if (nums.size == 1) {
        return nums[0]
    }

    // 动态规划
    for (i in 1 until nums.size) {
        if (nums[i - 1] > 0) {
            nums[i] = nums[i] + nums[i - 1]
        }
    }
    var maxInt = 0
    for (i in 1 until nums.size) {
        nums[i] = Math.max(nums[i - 1], nums[i])
        maxInt = nums[i]
        //println(nums[i])
    }
    return maxInt
}