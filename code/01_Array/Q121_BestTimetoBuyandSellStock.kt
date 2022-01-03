package ArrayTest

import kotlin.math.max
import kotlin.math.min


/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */
//class Q121_BestTimetoBuyandSellStock {

    fun main(){
        var prices = intArrayOf(7,1,5,3,6,4)
        println(maxProfit(prices))
    }

    fun maxProfit(prices: IntArray): Int {

        if (prices.size <=1){
            return 0;
        }

        var min_price:Int? = prices.max() // 最小购入价格
        var max_profit = 0; // 最大收益

        for (i in prices.indices){
            if (prices[i]< min_price!!){
                min_price = prices[i]
            }else{
                if ( (prices[i] - min_price) > max_profit){
                    max_profit = prices[i] - min_price
                }
            }
        }
        return max_profit
    }
//}