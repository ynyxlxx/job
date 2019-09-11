import java.util.Arrays;

public class DP {

    public static int knapsack(int capacity, int[] weights, int[] values) {
        int len = weights.length;
        if(len == 0){
            return 0;
        }
        //dp表示i个物品放进容量为c的背包的效益
        int[][] dp = new int[len][capacity+1];
        //初始化第一列，第一列表示背包容量为0的时候，所以第一列的值都为0
        for (int i = 0; i < len ; i++) {
            dp[i][0] = 0;
        }
        //初始化第一行。第一行表示只有一个物品。所以只要capacity >= weights[0]，就初始化为values[0]
        for (int j = 1; j <= capacity ; j++) {
            dp[0][j] = capacity >= weights[0] ? values[0] : 0;
        }
        for (int i = 1; i < len ; i++) {
            for (int j = 1; j <= capacity ; j++) {
                //第i个物品放不时的结果，和只有i-1个物品的结果一样
                dp[i][j] = dp[i-1][j];
                //第i个物品能放下
                if(j >= weights[i]){
                    //比较放和不放哪种能产生更高的价值
                    dp[i][j] = Math.max(dp[i][j],values[i]+dp[i-1][j-weights[i]]);
                }
            }
        }
        return dp[len-1][capacity];

    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];


        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //dp[i] 表示 金额为i时的最小硬币数量；
        for (int i = 0; i <= amount; i++){
            for (int j = 0; j < n; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++){
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n-1][0];

    }
}
