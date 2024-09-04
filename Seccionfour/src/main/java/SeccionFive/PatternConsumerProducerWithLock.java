package SeccionFive;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws  InterruptedException{
        lock.lock();
        System.out.println("Producer method....");
        condition.await();
        System.out.println("Again the producer method");
        lock.unlock();
    }

    public void consume() throws  InterruptedException{

        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer method....");
        Thread.sleep(3000);
        // notify
        condition.signal();
        lock.unlock();
    }
}



public class PatternConsumerProducerWithLock {

    public static void main(String [] args){
        Worker process = new Worker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    process.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    process.consume();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

}
