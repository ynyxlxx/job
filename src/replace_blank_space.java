public class replace_blank_space {
    public static void main(String[] args)
    {
        String input = new String("We Are Happy");
        StringBuffer temp = new StringBuffer(input);

        String res = replacement(temp);
        System.out.println(res);
    }

    private static String replacement(StringBuffer in)
    {

        for (int i = 0; i < in.length(); i++)
        {
            if (in.charAt(i) == ' ')
            {
                in.replace(i,i+1, new String("%20"));
            }
        }

        return in.toString();
    }
}
