package ArrayTest

/**
 * 217. 存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 解决方法：暴力双重for循环：效率低
 *         HashMap存储：避免重复，list可重复，set有顺序
 *         Set利用不可重复性，在add的是否返回false判断即可
 */
fun main() {
    var tempArray: IntArray = intArrayOf(-1, 1, 2, 3)
    if (containsDuplicate(tempArray)) {
        println("songsong yes")
    }
}

fun containsDuplicate(nums: IntArray): Boolean {

    var map = mutableMapOf<Int, Boolean>()

    for (i in nums.indices) {

        println("songsong index = " + nums[i])

        if (!map.containsKey(nums[i])) {
            map.put(nums[i], false)
        } else {
            map.put(nums[i], true)
            return true
        }
    }
    return false
}