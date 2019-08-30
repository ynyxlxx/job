import java.util.LinkedList;
import java.util.Queue;

public class MultiThread3 {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        Thread a = new Producer(queue, 15);
        Thread b = new Consumer(queue, 10);
        a.start();
        b.start();
    }

}

class Producer extends Thread{
    Queue<Integer> queue = new LinkedList<>();
    int n;

    public Producer(Queue<Integer> queue, int n){
        this.queue = queue;
        this.n = n;
    }

    public void run(){
        for (int i = 0; i < n; i++){
            queue.offer(i);
            System.out.println("producer: " + i);
            try{
                sleep((int) Math.random() * 100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

class Consumer extends Thread{
    Queue<Integer> queue = new LinkedList<>();
    int n;

    public Consumer(Queue<Integer> queue, int n){
        this.queue = queue;
        this.n = n;
    }

    public void run(){
        for (int i = 0; i < n; i++){
            Integer temp = queue.poll();
            if (temp != null){
                System.out.println("    consumer: " + temp);
            }
            try{
                sleep((int) Math.random() * 100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}