package start;

public class AppFive {

    public static void main(String [] args) throws InterruptedException {
       // en java existen daemon y worker thread, en este caso el hilo main es el principal
        System.out.println("Hilo principal: "+Thread.currentThread().getName());
        // podemos crear hilos apartir del hilo principal
        // los daemon son de baja prioridad y corren en el background como el garballe collector, siempre se crean para operaciones I/O y son terminados por la JVM cuando todos los worker threads son terminados
        Thread t1 = new Thread(new DaemonWorker());
        t1.setDaemon(true); // configuramos para que sea un daemon
        System.out.println(t1.isDaemon());


        Thread t2 = new Thread(new Worker());
        t1.start();
        t2.start();
    }

}

class Worker implements Runnable{

    @Override
    public void run() {

            try {
                Thread.sleep(3000);
                System.out.println("normal  thread finish ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


    }
}


class DaemonWorker implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println("Daemon thread is running");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}