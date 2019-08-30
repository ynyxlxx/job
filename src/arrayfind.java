public class arrayfind {
    public static void main(String[] args)
    {
        boolean res = false;
        int target = 7;
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,3},{6,8,11,15}};

        res = Solution(target, array);
        System.out.println(res);

    }

    public static boolean Solution(int target, int[][] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
//                System.out.println(array[i][j]);
                if (array[i][j] == target) return true;
        }

        return false;
    }
}
