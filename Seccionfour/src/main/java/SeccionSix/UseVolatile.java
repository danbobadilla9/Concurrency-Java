package SeccionSix;

public class UseVolatile {

    public static void main(String [] args){
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        worker.setTerminated(true);
        System.out.println("Algorithm is terminated....");

    }

}

class Worker implements Runnable{
    // sera guardado en la memoria principal
    // puede que las variables se guarden en la memoria principal sin la keyword volatile
    // o puede que ambos hilos usen la misma cache o cpu core, por eso puede que funcione sin que utilicemos la keyword volatile
    private volatile boolean terminated;

    @Override
    public void run(){
        // esta manera de terminar el hilo es correcta ya que Thread.stop esta deprecado de acuerdo a la documentacion de java
        while(!terminated){
            System.out.println("Working class is runing ....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTerminated(){
        return terminated;
    }

    public void setTerminated(boolean terminated){
        this.terminated = terminated;
    }

}