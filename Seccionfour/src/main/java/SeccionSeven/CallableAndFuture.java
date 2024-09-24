package SeccionSeven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String>{

    private int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception{
        Thread.sleep(2000);
        return "id: "+this.id;
    }
}


public class CallableAndFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<String>  future =  executor.submit(new Processor(i));
            list.add(future);
        }
        for(Future<String> f: list){
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
    }







}
