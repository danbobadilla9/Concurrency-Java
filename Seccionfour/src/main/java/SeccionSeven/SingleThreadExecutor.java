package SeccionSeven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {

    public static void main(String[] args) {
        // es un solo hilo que ejecutara las tareas de manera secuencial, una detras de otra
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i <5; i++) {
            executor.execute(new Task(i));
        }
        executor.shutdown();



    }

}


class Task implements Runnable{
    private int id;

    public Task(int id){
        this.id = id;
    }

    @Override
    public void run(){
        System.out.println("Task with id: "+id+" is in work - thread id : "+Thread.currentThread().getName()+" id thread: "+Thread.currentThread().getId());
        long duration = (long)Math.random() * 5;
        try {
            TimeUnit.SECONDS.sleep(duration);// otra forma de dormir el hilo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
