package SeccionFive;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SecFiveFour {

    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    private static void increment(){
        lock.lock(); // va a adquirir el lock intrinsect
        try{
            for(int i = 0; i < 10000; i++){
                counter++;
            }
            // si ocurre un error en la ejecución nunca llamara al lock y se quedara un lock dead, para ello se necesita utilizar: un try junto con un finally 
        }finally {
            lock.unlock();
        }




    }

    public static void main(String [] args){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               increment();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);


    }

}
