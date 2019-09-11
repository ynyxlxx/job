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

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

}
