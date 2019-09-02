import java.util.LinkedList;
import java.util.Queue;

public class MultiThread3 {
    private static final int MAX_CAPACITY = 5;
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();

        Producer a = new Producer(queue, MAX_CAPACITY);
        Consumer b = new Consumer(queue, MAX_CAPACITY);

        a.start();
        b.start();
    }

}

class Producer extends Thread{
    Queue<Integer> queue;
    int max;

    public Producer(Queue<Integer> queue, int max){
        this.queue = queue;
        this.max = max;
    }

    public void run(){
        try{
            while (true){
                synchronized (queue){
                    while (queue.size() == max){
                        System.out.println("stop producing, the queue is full. ");
                        queue.wait();
                    }
                    queue.offer(1);
                    System.out.println(queue);
                    queue.notifyAll();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

class Consumer extends Thread{
    Queue<Integer> queue;
    int max;

    public Consumer(Queue<Integer> queue, int max){
        this.queue = queue;
        this.max = max;
    }

    public void run(){
        try{
            while (true){
                synchronized (queue){
                    while(queue.isEmpty()){
                        System.out.println("all sold out, waiting...");
                        queue.wait();
                    }
                    queue.poll();
                    System.out.println(queue);
                    queue.notifyAll();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}