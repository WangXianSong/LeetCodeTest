package ArrayTest

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
fun main() {
    var aaa: IntArray = intArrayOf(1, 0, 0, 1)
    moveZeroes(aaa)
    for (index in aaa) {
        println(index)
    }
}

/**
 * 双头索引
 */
fun moveZeroes(nums: IntArray): Unit {
    var num = 0
    var zero = 0 // 一直记录最前的零的索引
    var size = nums.size


    for (index in nums.indices) {
        // 如果当前数不为0，则和零标记符换位
        if (nums[index] != 0) {
            var temp = nums[zero]
            nums[zero] = nums[index]
            nums[index] = nums[zero]
            // 零的位置++
            zero++
        }
    }

// 剩余的要设为0
    for (index in zero until size) {
        nums[index] = 0
    }
}



