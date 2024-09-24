package SeccionSeven;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecuterEx {


    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // se ejecuta cada 2 segundos
        executor.scheduleAtFixedRate(new Stock(), 1000, 2000, TimeUnit.MILLISECONDS);


    }
}


class Stock implements Runnable{

    @Override
    public void run(){
        System.out.println("Updating and downloading stock related data from web....");

    }
}