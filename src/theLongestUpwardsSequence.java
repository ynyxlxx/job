import java.util.ArrayList;

public class theLongestUpwardsSequence {
    public static void main(String[] args) {
        int[] a = new int[]{1,5,3,4,6,0};
        Solution solution = new Solution();
        System.out.println(solution.longestSequence(a));
    }
}

class Solution {
    public int longestSequence(int[] array) {

        if (array.length <= 0 || array == null) return 0;

//        if (array.length == 1){
//            res.add(array[0]);
//            return res;
//        }

        int N = array.length;
        int[] dp = new int[N];

        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (res < dp[i]) {
                res = dp[i];
            }

        }
        return res;
    }
}