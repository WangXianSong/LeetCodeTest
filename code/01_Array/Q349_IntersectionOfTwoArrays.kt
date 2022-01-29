package ArrayTest

import java.util.*
import kotlin.collections.ArrayList

/**
 * 349. 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 解决方法：1.去重复后对比
 *         2.排序后双指针判断
 *
 */
fun main() {

}

/**
 * 去重复后对比
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    //1.先将num1的内容去重存到集合中
    var set = TreeSet<Int>()
    for (i in nums1) {
        set.add(i)
    }

    //2.遍历num2的内容有多少个能在set中找到
    var arr = ArrayList<Int>()
    for (j in nums2) {
        if (set.contains(j)) {
            arr.add(j)
            //3.为防止num2中也有重复的元素，找到后并删除掉，
            //4.避免再有，保证唯一性。
            set.remove(j)
        }
    }

    //5.由于返回的是int数组，所以要转换
    var res = IntArray(arr.size)
    for (i in arr.indices) {
        res[i] = arr[i]
    }

    return res
}