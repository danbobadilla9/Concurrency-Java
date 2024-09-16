package SeccionSix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader{
    INSTANCE;
    private Semaphore semaphore = new Semaphore(3, true);

    public void download(){
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            Thread.sleep(5000);
            System.out.println("Downloading data from the web.....");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}



public class Semaphores {

    public static void main(String [] args){
        // creamos multiples hilos utilizando executor

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.download();
                }
            });
        }


    }


}
