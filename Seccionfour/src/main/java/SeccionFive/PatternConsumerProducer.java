package SeccionFive;

import java.util.ArrayList;
import java.util.List;

class ProcessPattern {

    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;
    public void produce() throws InterruptedException{

        synchronized(lock){
            while(true){
                if(list.size() == UPPER_LIMIT){
                    System.out.println("esperando a que el consumidor inicie");
                    lock.wait();
                }else{
                    System.out.println("adding: "+value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }

    }

    public void consumer() throws InterruptedException{
        synchronized(lock){
            while(true){
                if(list.size() == LOWER_LIMIT){
                    System.out.println("esperando a que el producer inicie");
                    value = 0;
                    lock.wait();
                }else{
                    System.out.println("remove : "+list.remove(list.size() -1));
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }


}




public class PatternConsumerProducer {

    public static void main(String [] args){
        ProcessPattern process = new ProcessPattern();
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
                    process.consumer();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

}
