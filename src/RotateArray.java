public class RotateArray {
    public static void main(String[] args){
        int[] a = {3,4,5,1,2};
        int[] b = {8,9,10,6,7};
        System.out.println("result: " + minNumberInRotateArray(a));
        System.out.println("result: " + minNumberInRotateArray(b));
    }


    private static int minNumberInRotateArray(int [] array) {
        int front = 0;
        int tail = array.length - 1;
        int mid = 0;

        if (array[front] < array[tail]) return array[front];

        while (front < tail){
            if (tail - front == 1) {
                mid = tail;
                break;
            }

            mid = (front + tail) >> 1;
            if (array[mid] <= array[tail]) tail = mid;
            if (array[mid] >= array[front]) front = mid;
        }
        return array[mid];
    }

}
