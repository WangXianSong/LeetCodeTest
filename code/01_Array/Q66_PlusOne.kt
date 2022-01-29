package ArrayTest

/**
 * 66. 加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
fun main() {

    var aaa: IntArray = intArrayOf(9, 9, 9)
    var temp = plusOne(aaa)
    for (index in temp) {
        println(index)
    }
}

/**
 * 末尾追加方法
 */
fun plusOne(digits: IntArray): IntArray {
    // 获取数组长度
    val length: Int = digits.size
    // 如果当前位是9，设置当前为0
    for (index in length - 1 downTo 0) {
        if (digits[index] != 9) {  // 如果不是9，那么就加1并结束循环
            digits[index]++
            return digits
        } else { // 如果当前位是9，设置当前为0
            digits[index] = 0
        }
    }

    // 除非是999，否则不会来到这一步，直接新建一个数组，设置首位为0即可
    var temp = IntArray(length + 1)
    temp[0] = 1
    return temp
}