import  java.util.ArrayList;

public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer> > result = new ArrayList<>();

    public static void main(String[] args){
        int sum = 10;
        FindContinuousSequence(sum);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if (sum <= 0) return result;

        int small = 1;
        int big = 2;

        ArrayList<Integer> sequence = new ArrayList<>();
        sequence.add(1);
        sequence.add(2);

        while (small < (1 + sum) / 2) {
            int tempSum = getSum(small, big);

            if (tempSum == sum) {
                result.add(new ArrayList<>(sequence));
                big++;
            }

            if (tempSum > sum) {
                sequence.remove(0);
                small++;
            }
            if (tempSum < sum) {
                big++;
                sequence.add(big);
            }
            System.out.println(sequence);
        }
        return result;
    }

    public static int getSum(int small, int big){
        return (big * small) + (big * (big - 1)) / 2;
    }
}
