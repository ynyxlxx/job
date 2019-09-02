import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

public class MultiThread2 {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition printChar1 = lock.newCondition();
    public static Condition printChar2 = lock.newCondition();
    public static Condition printChar3 = lock.newCondition();
    public static void main(String[] args){
//        ExecutorService executor = Executors.newCachedThreadPool();
//        executor.submit(new PrintTesk("A"));
//        executor.submit(new PrintTesk2("B"));
//        executor.submit(new PrintTesk3("C"));
//        executor.shutdown();
        Thread a = new Thread(new PrintTesk("A"));
        Thread b = new Thread(new PrintTesk2("B"));
        Thread c = new Thread(new PrintTesk3("C "));

        try{
            a.start();
            Thread.sleep(100);
            b.start();
            c.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static class PrintTesk implements Runnable {
        private String toPrint;

        public PrintTesk(String s) {
            this.toPrint = s;
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 10) {
                try {
                    lock.lock();
                    System.out.print(toPrint);
                    Thread.sleep(100);
                    printChar2.signal();
                    i++;
                    printChar1.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class PrintTesk2 implements Runnable {
        private String toPrint;

        public PrintTesk2(String s){
            this.toPrint = s;
        }

        @Override
        public void run(){
            int i = 0;
            while (i < 10){
                try{
                    lock.lock();
                    System.out.print(i);
                    Thread.sleep(100);
                    printChar3.signal();
                    i++;
                    printChar2.await();
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class PrintTesk3 implements Runnable {
        private String toPrint;

        public PrintTesk3(String s){
            this.toPrint = s;
        }

        @Override
        public void run(){
            int i = 0;
            while (i < 10){
                try{
                    lock.lock();
                    System.out.print(toPrint);
                    Thread.sleep(100);
                    printChar1.signal();
                    i++;
                    printChar3.await();
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}


