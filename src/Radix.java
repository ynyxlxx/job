import java.util.HashMap;
import java.util.Map;

public class Radix {
    private static char[] array = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static void main(String[] args) {
        int a = 168;
        System.out.println(radix(a, 16));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static String radix(int number, int radix) {
        StringBuffer res = new StringBuffer();
        while (number > 0) {
            res.insert(0, array[number % radix]);
            number /= radix;
        }
        return res.toString();
    }

    private static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        int i = 0;
        while (i < s.length()){
            if (map.containsKey(s.substring(i, i+2)) && i + 1 < s.length()){
                ans += map.get(s.substring(i, i+2));
                i += 2;
            }else{
                ans += map.get(s.substring(i, i+1));
                i += 1;
            }
        }

        return ans;
    }
}
    /*
    * while(gets(str))//用于多次输入
    {
        count=strlen(str);//计算字符串的长度
        sum=0;
        for(i=count-1;i>=0;i--)//从十六进制个位开始，每位都转换成十进制
        {
        if(str[i]>='0'&&str[i]<='9')//数字字符的转换
        {
            sum+=(str[i]-48)*pow(16,count-i-1);
        }
        else if(str[i]>='A'&&str[i]<='F')//字母字符的转换
        {
            sum+=(str[i]-55)*pow(16,count-i-1);
        }
        }
        printf("%d\n",sum);*/

