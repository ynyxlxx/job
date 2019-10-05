import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiThread4 {
    static Object lock = new Object();
    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Printer("a"));
        service.submit(new Printer("b "));
        service.shutdown();
//        Thread a = new Thread(new Printer("a"));
//        Thread b = new Thread(new Printer("b"));
//        a.start();
//        b.start();
    }

    private static class Printer implements Runnable{
        String toPrint;

        public Printer(String in){
            this.toPrint = in;
        }

        @Override
        public void run(){
            int i = 0;
            while (i < 50){
                synchronized (lock){
                    try {
                        lock.notify();
                        System.out.print(toPrint);
                        i++;
                        Thread.sleep(100);
                        lock.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }
    }


}
