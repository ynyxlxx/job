import java.util.Arrays;

public class HeapSort {
//    public static void main(String [] args){
//        int[] a = {7,2,5,6,3,8,4,1};
//        int[] b = intoHeap(a);
//        int[] c = heapSort(b);
//        System.out.println("heapSort: " + Arrays.toString(c));
//    }
//
//    private static void sink(int[] arr, int k, int N){
//        while (2 * k <= N){
//            int j = 2 * k;
//            if (j + 1 < N){
//                if (arr[j] < arr[j + 1]) j++;
//            }
//            if (arr[k] >= arr[j]) break;
//            exch(arr, k, j);
//            k = j;
//        }
//    }
//
//    private static int[] heapSort(int [] arr){
//        int N = arr.length - 1;
//
//        for (int k = N / 2; k >= 1; k--){
//            sink(arr, k, N);
//        }
//
//        while (N > 1){
//            exch(arr, 1, N--);
//            sink(arr, 1, N);
//        }
//
//        arr = Arrays.copyOfRange(arr, 1, arr.length);
//        return arr;
//    }
//
//    private static int[] intoHeap(int[] arr){
//        int n = arr.length;
//        int[] heap = new int[n+1];
//        for (int i = 1; i < heap.length; i++){
//            heap[i] = arr[i - 1];
//        }
//        return heap;
//    }
//
//    private static void exch(int[] array, int i, int j){
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
public static void main(String []args){
    int []arr = {3,1,4,2,8,5,9,7,6};
    sort(arr);
    System.out.println(Arrays.toString(arr));
}
    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
