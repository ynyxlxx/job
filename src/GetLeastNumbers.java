import java.util.Arrays;

public class GetLeastNumbers {
    public static void main(String[] args){
        int [] a = new int[]{4,5,1,6,2,7,3,8};
        int [] b = new int[]{4,5,1,6,2,7,3,8};

        sort(a, 0, a.length - 1);
        System.out.println("Kth: " + selectKth(b, 0));
        System.out.println("Sorted arrays: " + Arrays.toString(a));
        System.out.println("binary search for 4: " + binarySearch(a, 4));
        System.out.println("binary search for 9: " + binarySearch(a, 9));

        int index = Partitation(b, 0, a.length - 1);
        int end = b.length - 1;
        int start = 0;
        int k = 5;
        while (index != k - 1){
            if (index > k - 1){
                end = index - 1;
                index = Partitation(b, start, end);
            }
            if (index < k - 1){
                start = index + 1;
                index = Partitation(b, start, end);
            }
        }
        for (int m = 0; m < k; m++) System.out.print(b[m] + " ");
    }

    public static int Partitation(int[] array, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int v = array[lo];

        while (true){
            while (array[++i] < v) if (i == hi) break;
            while (array[--j] > v) if (j == lo) break;

            if (i >= j) break;
            exch(array, i, j);
        }
        exch(array, lo, j);
        return j;
    }

    public static void exch(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array, int lo, int hi){
        if(hi <= lo) return;

        int p = Partitation(array, lo, hi);
        sort(array, lo, p - 1);
        sort(array, p + 1, hi);
    }

    public static int selectKth(int[] arr, int k){
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi){
            int p = Partitation(arr, lo, hi);
            if (p == k) return arr[k];
            if (p < k) lo = p + 1;
            if (p > k) hi = p - 1;
        }
        return arr[k];
    }

    private static int binarySearch(int[] arr, int target){
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;

        while (lo <= hi){
            mid = (lo + hi) >>> 1;
            if (arr[mid] == target) return mid;

            if (arr[mid] > target) hi = mid - 1;
            if (arr[mid] < target) lo = mid + 1;
        }
        return -1;
    }
}
