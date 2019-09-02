import java.util.ArrayList;
public class printMatrix {
    public static void main(String[] args){
        int[][] a = {{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
        System.out.println(printMatrix(a));
        System.out.println(printMatrix_ACW(a));
    }

    private static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int up = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true){
            for (int i = left; i <= right; i++){
                res.add(matrix[up][i]);
            }
            up++;

            if(up > bottom) break;

            for (int i = up; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;

            if (left > right) break;

            for (int i = right; i >= left; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;

            if (up > bottom) break;

            for (int i = bottom; i >= up; i--){
                res.add(matrix[i][left]);
            }
            left++;

            if(left > right) break;
        }

        return res;
    }

    private static ArrayList<Integer> printMatrix_ACW(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int up = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true){
            for (int i = right; i >= left; i--){
                res.add(matrix[up][i]);
            }
            up++;

            if(up > bottom) break;

            for (int i = up; i <= bottom; i++){
                res.add(matrix[i][left]);
            }
            left++;

            if (left > right) break;

            for (int i = left; i <= right; i++){
                res.add(matrix[bottom][i]);
            }
            bottom--;

            if (up > bottom) break;

            for (int i = bottom; i >= up; i--){
                res.add(matrix[i][right]);
            }
            right--;

            if(left > right) break;
        }

        return res;
    }
}
