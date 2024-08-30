package start;

public class AppThre {

    public static void main (String[] args){

        System.out.println("Hello word ");
        System.out.println("Hello word ");
        System.out.println("Hello word ");
        Thread runner1 = new RunnerO();
        Thread runner2 = new RunnerT();
        runner1.start();
        runner2.start();



    }



}

// La segunda opcion es utilizando la clase Thread
class RunnerO extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 1: "+i);
        }
    }


}

class RunnerT  extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            // cada hilo duerme por la cantidad que le pusimos
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 2: "+i);
        }
    }


}
