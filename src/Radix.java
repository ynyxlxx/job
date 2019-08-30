public class Radix {
    private static char[] array = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static void main(String[] args){
        int a = 164;
        System.out.println(radix(a, 16));
    }

    private static String radix(int number, int radix){
        StringBuffer res = new StringBuffer();
        while (number > 0){
            res.insert(0, array[number % radix]);
            number /= radix;
        }
        return res.toString();
    }
}
