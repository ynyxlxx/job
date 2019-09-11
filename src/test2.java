class test2 {
    String name = "parents";

    public test2(){
    }

    public void print(){
        System.out.println(name);
    }

    private static class son extends test2{
        static String name = "son";

         public son (){};

         public void print(){
             System.out.println(name);
         }

    }

    public static void main(String[] args){
        test2 A = new son();
        A.print();
        test2 B = new test2();
        B.print();
    }

}

