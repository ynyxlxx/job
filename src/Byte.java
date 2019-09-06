public class Byte {
    public static void main(String[] args){
        System.out.println(hammingWeight(3));
    }

/*   将 n 和 n - 1 与运算 总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
*    x / 2 is x >> 1 and x % 2 is x & 1 */

    public static int hammingWeight(int n) {
        if (n == 0) return 0;

        int count = 0;
        while (n != 0){
            n &= n - 1;
            count++;
        }
        return count;
    }
}
