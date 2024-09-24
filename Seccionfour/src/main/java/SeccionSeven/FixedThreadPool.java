package SeccionSeven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executor.execute(new Task(i));
        }



        // no ejecuta ninguna otra tareava a ser aceptada
        executor.shutdown();

        try{
            // va  a esperrar 1 segundo a que termine todas las tareas quue se estan ejecutando
            if(executor.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                executor.shutdownNow();
            }
        }catch (InterruptedException e){
            executor.shutdownNow();
        }
    }

}
