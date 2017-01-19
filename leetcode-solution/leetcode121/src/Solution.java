/**
 * Created by Felicity on 2017/1/17.
 */
// 动态规划法。从前向后遍历数组，记录当前出现过的最低价格，作为买入价格，并计算以
// 当天价格出售的收益，作为可能的最大收益，整个遍历过程中，出现过的最大收益就是所求
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;//如果价格只有一天的，则return 0，因为只有那一天也只能买入那一天，无profit
        int maxProfit = 0;//建立最大利润变量
        int curMin = prices[0];//将第0天的price设为当前最小的买入价格
        for (int i = 1; i < prices.length; i++) {//遍历整个天数
            curMin = Math.min(curMin, prices[i]);//找出所有天数里买入价格最低的
            maxProfit = Math.max(maxProfit, prices[i] - curMin);//找出当天价格减去最小买入价格后得到的最大利润，若前一个maxprofit更大，则不变，
            //否则用新得出的利润替换原来的利润
            
        }

        return maxProfit;//返回最大利润
        }
    }
}
