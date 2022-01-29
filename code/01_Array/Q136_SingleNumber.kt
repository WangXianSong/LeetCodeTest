package ArrayTest


/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 解决1：位运算：按位异或 xor
 *
 * a^a=0；自己和自己异或等于0
 * a^0=a；任何数字和0异或还等于他自己
 * a^b^c=a^c^b；异或运算具有交换律
 *
 * 解决2：Set 效率不高
 *
 */
fun main() {

    var aaa :IntArray = intArrayOf(2,2,1)
    singleNumber1(aaa)
}

/**
 * 位运算
 */
fun singleNumber(nums: IntArray): Int {
    var reduce = 0
    for (i in nums) {
        reduce = reduce xor i
    }
    return reduce
}

/**
 * Set计算
 *
 * 效率不高 执行用时：260 ms, 在所有 Kotlin 提交中击败了17.65%的用户
 */
fun singleNumber1(nums: IntArray): Int {
    var set = mutableSetOf<Int>()
    for (i in nums) {
        if (!set.add(i)) {
            set.remove(i)
        }
    }

    if (set.size > 0) {
        return set.elementAt(0)

    }
    return -1;
}


