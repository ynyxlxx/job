import java.util.Arrays;

public class Matrix {
    public static void main(String[] args){
        int[][] a = {{1,2,3},{1,2,3},{1,2,3}};
        int[][] b = {{1,0,0},{1,0,0},{1,0,0}};
        printMatrix(product(a,b));
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
}
