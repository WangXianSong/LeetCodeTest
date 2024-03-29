package ArrayTest

import kotlin.math.max
import kotlin.math.min


/**
 * 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 *
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 */
//class Q122_BestTimetoBuyandSellStock2 {

fun main() {
    var prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit1(prices))
}

fun maxProfit1(prices: IntArray): Int {

    var max_profit = 0

    for (i in 0 until prices.size - 1) {
        if (prices[i] < prices[i + 1]) {
            max_profit += prices[i + 1] - prices[i]
        }
    }

    return max_profit
}


//}