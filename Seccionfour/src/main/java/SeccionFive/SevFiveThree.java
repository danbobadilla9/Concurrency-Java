package SeccionFive;

class Process{

    // ambos metodos utilizan el lock intrinseco del objeto process, por lo que no pueden ser ejecutados al mismo tiempo
    // cuando llamamos a wait este hilo va a esperar y liberara el lock para que sea utilizdo por el segundo metodo
    // cuando llama al metodo notify, indica que termino su proceso y libero el lock y ahora el metodo producer va a poder volver a utilizar el lock y continuar con su ejecución
    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Running the produce method");
            wait();
            System.out.println("Again in the producer metod ");
        }
    }

    public void consume () throws InterruptedException{
        Thread.sleep(1000);
        synchronized (this){
            System.out.println(" Consume method is executed....");
            notify();
            // despues de notify primero tiene que terminar todo el codigo que esta despues del notify y hasta ese entonces va a liberar el lock
            Thread.sleep(1000);
        }
    }

}


public class SevFiveThree {

    public static void main(String [] args){
        Process process = new Process();
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
                    process.consume();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }

}
