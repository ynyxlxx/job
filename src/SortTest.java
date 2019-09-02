import java.util.Arrays;

public class SortTest {
    public static void main(String[] args){
        int[] a = new int[]{7,2,5,6,3,8,4,1};

        int[] a1 = Arrays.copyOf(a,a.length);
        Solution.bubbleSort(a1);
        System.out.println("BubbleSort: " + Arrays.toString(a1));

        int[] a2 = Arrays.copyOf(a,a.length);
        Solution.selectSort(a2);
        System.out.println("SelectSort: " + Arrays.toString(a2));

        int[] a3 = Arrays.copyOf(a,a.length);
        Solution.insertSort(a3);
        System.out.println("InsertSort: " + Arrays.toString(a3));

        int[] a4 = Arrays.copyOf(a,a.length);
        Solution.quickSort(a4, 0, a4.length - 1);
        System.out.println("QuickSort: " + Arrays.toString(a4));

        int[] a5 = Arrays.copyOf(a,a.length);
        Solution.MergeSort(a5, 0, a5.length - 1);
        System.out.println("MergeSort: " + Arrays.toString(a5));

        int[] a6 = Arrays.copyOf(a,a.length);
        Solution.shellSort(a6);
        System.out.println("ShellSort: " + Arrays.toString(a6));

        int[] a7 = Arrays.copyOf(a,a.length);
        Arrays.sort(a7);
        System.out.println("Arrays.sort(): " + Arrays.toString(a7));

    }

    private static class Solution{
        public Solution(){}

        public static void exch(int[] array, int i, int j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public static Boolean less(int[] array, int i, int j){
            return array[i] < array[j];
        }

        public static void bubbleSort(int[] array){      //O(n^2)
            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array.length - 1 - i; j++){
                    if(array[j] > array[j + 1])
                        exch(array, j, j+1);
                }
            }
        }

        public static void selectSort(int[] array){     //O(n^2)
            for (int i = 0; i < array.length; i++) {
                int min = i;
                for (int j = i + 1; j < array.length; j++){
                    if (array[min] > array[j]) min = j;
                }
                exch(array, i, min);
            }
        }

        public static void insertSort(int[] array){
            for (int i = 1; i < array.length; i++){
                for (int j = i; j > 0; j--){
                    if (array[j] < array[j - 1])
                        exch(array, j, j -1);
                }
            }
        }

        public static int partition(int[] array, int lo, int hi){
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

        public static void quickSort(int[] array, int lo, int hi){
            if(hi <= lo) return;

            int p = partition(array, lo, hi);
            quickSort(array, lo, p - 1);
            quickSort(array, p + 1, hi);
        }

        // first array [l, m], second array [m+1, r]
        public static void merge(int[] array, int l, int m, int r){
            int n1 = m - l + 1;
            int n2 = r - m;

            int[] L = new int[n1];
            int[] R = new int[n2];

            for (int i = 0; i < n1; i++)
                L[i] = array[l + i];
            for (int j = 0; j < n2; j++)
                R[j] = array[m + 1 + j];

            /* Merge the temp arrays */
            int i = 0;
            int j = 0;
            int k = l;

            while (i < n1 && j < n2){
                if (L[i] <= R[j]) {
                    array[k] = L[i];
                    i++;
                }else{
                    array[k] = R[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1){
                array[k] = L[i];
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2){
                array[k] = R[j];
                j++;
                k++;
            }
        }
        // first array [l, m], second array [m+1, r]
        public static void MergeSort(int[] array, int l, int r){
            if (l < r)
            {
                int m = (l + r) / 2;

                MergeSort(array, l, m);
                MergeSort(array, m + 1, r);

                merge(array, l, m, r);
            }
        }

        /*使数组中任意间隔为h的数都是有序的.*/
        public static void shellSort(int[] arr){     //O(n^2)
            int N = arr.length;
            int h = 1;

            while (h < N/3) h = 3*h + 1;
            while (h >= 1){
                for (int i = h; i < N; i++){
                    for (int j = i; j >= h; j -= h){
                        if (arr[j] < arr[j - h]){
                            exch(arr, j, j - h);
                        }
                    }
                }
                h = h/3;
            }
        }
    }
}

