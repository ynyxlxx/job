import java.util.Arrays;
import java.util.List;

public class MatrixTest {
    public static void main(String[] args){
        int[][] a = {{1,2,3},{1,2,3},{1,2,3}};
        int[][] b = {{1,0,0},{1,0,0},{1,0,0}};
        printMatrix(product(a,b));
        System.out.println(minPathSum(a));
        printMatrixZigZag(a);
    }

    public static int[][] product(int[][] a, int[][] b){
        int row = a.length;
        int col = a[0].length;

        if (col != b.length) return null;

        int[][] c = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                for (int k = 0; k < col; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static void printMatrix(int[][] a){
        int r = a.length;
        int c = a[0].length;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (j == c - 1) System.out.print(a[i][j] + "\n");
                else System.out.print(a[i][j] + " ");
            }
        }
    }

    public static void printMatrixZigZag(int[][] a){
        int r = a.length;
        int c = a[0].length;
        boolean goingRight = true;
        for (int i = 0; i < r; i++){
           if (goingRight) {
               int j = 0;
               while (j < c) {
                   if (j == c - 1) System.out.print(a[i][j] + "\n");
                   else System.out.print(a[i][j] + " ");
                   j++;
               }
           }
           if (!goingRight) {
               int j = c - 1;
               while (j >= 0) {
                   if (j == 0) System.out.print(a[i][j] + "\n");
                   else System.out.print(a[i][j] + " ");
                   j--;
               }
            }
            goingRight = !goingRight;
        }
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        //每次只能向下或者向右移动一步。
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0)
                    dp[i][j] = grid[0][0];
                if (i == 0 && j > 0)
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                if (j == 0 && i > 0)
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                if (j > 0 && i > 0)
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }

         for(int i = 0; i < m; i++){
             for (int j = 0; j < n; j++){
                 System.out.print(dp[i][j]);
                 if (j == n - 1)
                     System.out.print("\n");
             }
         }

        return dp[m - 1][n - 1];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;

        int[] dp = new int[triangle.get(n - 1).size()];

        int k = 0;
        for (Integer i : triangle.get(n - 1)){
            dp[k] = i;
            k++;
        }
        // System.out.println(Arrays.toString(dp));

        for (int i = n - 2; i >= 0; i--){
            for (int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    private static void rotate(int[] nums, int k) {
        int pre;
        for (int i = 0; i < k; i++){
            pre = nums[nums.length-1];
            for (int j = 0; j < nums.length; j++){
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
