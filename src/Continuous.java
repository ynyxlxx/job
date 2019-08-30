import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Continuous {
    public static void main(String[] args){
        int [] a = new int[]{1, 2, 4, 0, 5};
        System.out.println(isContinuous(a));
    }

    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0) return false;
        List<Integer> list = new ArrayList<>();
        int n = 0;
        for(int i : numbers){
            if(i == 0) {
                n++;
            }else {
                list.add(i);
            }
        }
        Collections.sort(list);
        int m = list.get(list.size() - 1) - list.get(0);
        return m <= 4 && 4 - m <= n;
    }

}
