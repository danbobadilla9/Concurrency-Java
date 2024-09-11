package SeccionSix;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesExample {

    private static int counter = 0;
    private static AtomicInteger counter2 = new AtomicInteger(0);
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //increment();
                increment2();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //increment();
                increment2();
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
        System.out.println("counter: "+counter);
        System.out.println("counter2: "+counter2);

    }


    public static void increment(){
        for(int i = 0; i < 10000; i++){
            counter++;
        }
    }

    public static void increment2(){
        for(int i = 0; i < 10000; i++){
            counter2.getAndIncrement();
        }
    }
}
