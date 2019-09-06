import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class StringTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()){
//            String a = sc.nextLine();
//            String b = sc.nextLine();
//            System.out.println(longestCommonSubstring(a, b));
//        }
        String a = "123cababababa";
        String b = "123ababababa";
        System.out.println(longestCommonSubstring(a, b));
    }

    public static String longestCommonSubstring(String a, String b){
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                dp[i][j] = 0;
            }
        }
        int max = 0;
        int pos = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    pos = j;
                }
            }
        }
        return a.substring(pos - max + 1, pos + 1);
    }

    private static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int max;
        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < n && j < n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(j - i, ans);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   l   r
        // 如果 dp[l, r] = true 那么 dp[l + 1, r - 1] 也一定为 true
        // 关键在这里：[l + 1, r - 1] 一定至少有 2 个元素才有判断的必要
        // 因为如果 [l + 1, r - 1] 只有一个元素，不用判断，一定是回文串
        // 如果 [l + 1, r - 1] 表示的区间为空，不用判断，也一定是回文串
        // [l + 1, r - 1] 一定至少有 2 个元素 等价于 l + 1 < r - 1，即 r - l >  2

        // 写代码的时候这样写：如果 [l + 1, r - 1]  的元素小于等于 1 个，即 r - l <=  2 ，就不用做判断了

        // 因为只有 1 个字符的情况在最开始做了判断
        // 左边界一定要比右边界小，因此右边界从 1 开始
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // 区间应该慢慢放大
                // 状态转移方程：如果头尾字符相等并且中间也是回文
                // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                // 否则要继续看收缩以后的区间的回文性
                // 重点理解 or 的短路性质在这里的作用
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

    public static int longestPalindromeSubSeq(String s){
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--){
            dp[i][i] = 1;
            for (int j = 0; j < i; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n - 1];
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

}
