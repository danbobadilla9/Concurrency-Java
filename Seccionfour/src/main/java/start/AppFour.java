package start;

public class AppFour {

    public static void main (String[] args) throws InterruptedException {
        System.out.println("Hello word ");
        System.out.println("Hello word ");
        System.out.println("Hello word ");
        Thread runner1 = new RunnerF();
        Thread runner2 = new RunnerFO();
        runner1.start();
        runner2.start();
        // podemos esperar a que un hilo termine con la ayuda dle metodo join()
        // java va a esperar hasta que los dos hilos terminen y van a continuar con la ejecución de los otros hilos
        runner1.join();
        runner2.join();
        System.out.println("Finishet with threads....");
    }

}


class RunnerF extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 1: "+i);
        }
    }


}

class RunnerFO  extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            // cada hilo duerme por la cantidad que le pusimos
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 2: "+i);
        }
    }


}