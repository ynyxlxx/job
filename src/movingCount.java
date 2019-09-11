public class movingCount {

    private int movingCount(int threshold, int m, int n){
        boolean[] visited = new boolean[m * n];

        int count = generator(threshold, 0, 0, m, n, visited);
        return count;
    }

    private int generator(int threshold, int row, int col, int m, int n, boolean[] visited){
        int count = 0;

        if (check(threshold, row, col, m, n, visited)){
            visited[row * n + col] = true;
            count = 1 + generator(threshold, row - 1, col, m, n, visited) +
                    generator(threshold, row, col - 1, m, n, visited)+
                    generator(threshold, row + 1, col, m, n, visited)+
                    generator(threshold, row, col + 1, m, n, visited);
        }

        return count;
    }


    private boolean check(int threshold, int row, int col, int m, int n, boolean[] visited){
        if (row < m && col < n && row >= 0 && col>=0 && visited[row * n + col] == false){
            if (getDigitSum(row) + getDigitSum(col) <= threshold){
                return true;
            }
        }
        return false;
    }

    private int getDigitSum(int number){
        int sum = 0;
        while(number > 0){
            int r = number % 10;
            number /= 10;
            sum += r;
        }
        return sum;
    }
}
