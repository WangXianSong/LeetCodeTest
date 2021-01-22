package ArrayTest

/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:
输入: [1,3,5,6], 5
输出: 2

示例 2:
输入: [1,3,5,6], 2
输出: 1
*/
fun main() {
    val arr = intArrayOf(1, 2, 6, 7, 9)
    val a = searchInsert(arr, 0)
    println(a)
}

// 搜索插入位置
fun searchInsert(nums: IntArray, target: Int): Int {
    // 一路找对应 一边找比他小
    var i = 0
    var indexMin = 0
    var result = 0
    while (i < nums.size) {
        // 如果见到相同的马上返回
        if (nums[i] == target) {
            return i
            // 如果比target小，那么有可能在后头，先记录
        } else if (nums[i] < target) { // 1 < 0 ..
            result = i
            // 已经比target大了，根据数组有序性，后面没洗了，直接返回
        } else if (nums[i] > target) {
            return i
        }
        i++
    }
    // 如果都找不到，那么就把刚刚记录的位置后腾出来塞它
    return result + 1
}



