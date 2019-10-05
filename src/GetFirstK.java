import java.util.Collections;

public class GetFirstK {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 3, 3, 3, 4, 5};
        int res1 = GetFirstK(a, 3);
        int res2 = GetLastK(a, 3);
        int res3 = count(a, 3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    public static int GetFirstK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        boolean exist = false;

        while (left < right) {
            middle = (left + right) >>> 1;

            if (array[middle] < k) left = middle + 1;
            else if (array[middle] > k) right = middle - 1;

            if (array[middle] == k) {
                exist = true;
                if (((middle > 0) && array[middle - 1] != k) || middle == 0)
                    return middle;
                right = middle - 1;
            }
        }
        return exist ? right : -1;
    }

    public static int GetLastK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        boolean exist = false;

        while (left < right) {
            middle = (left + right) >>> 1;

            if (array[middle] < k) left = middle + 1;
            else if (array[middle] > k) right = middle - 1;

            if (array[middle] == k) {
                exist = true;
                if (((middle < array.length - 1) && array[middle + 1] != k) || middle == array.length - 1)
                    return middle;
                left = middle + 1;
            }
        }
        return exist ? right : -1;
    }

    public static int count(int[] array, int k){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] == k){
                count = 1;
                for (int j = i + 1; j < array.length; j++){
                    if (array[j] == k) count++;
                }
                return count;
            }
        }
        return count;
    }
}
