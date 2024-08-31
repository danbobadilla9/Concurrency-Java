package SeccionFive;

public class SecFiveOne {

    public static long counter = 0;
    public static long counter2 = 0;


    public static void main(String [] args){
        // Synchronization

        //el valor del contador siempre sera diferente porque no osn operaciones atomicas para eso deberemos utilizar la sincronizacion
        try {
            process();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(long i = 0; i< 100000L; i++){
                    increment2();
                }
            }


        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(long i = 0; i< 100000; i++){
                    increment();
                }
            }


        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The counter is: "+counter);
        System.out.println("The counter2 is: "+counter2);

    }
    // solo sera llamado por un solo hilo una sola vez, si no utilizamos la palabra clave: synchronized estarian entrando dos hilos al proceso
    // esto utiliza el instrinsic Lock (monitor), que toda clase en java solo tiene 1 y solo un hilo puede hacer uso de este lock y despues lo libera para que otro hilo lo pueda utilizar
    // si hay 2 synchronized tendremos problemas debido a que todos los hilos van a tener que esperar a que se libere el lock de los dos metodos
    public static synchronized void  increment(){
        counter++;
    }
    // otra forma utilizando static, en caso de que no sea static podemos utilizar this en lugar del nombre de la clase
    public static  void  increment2(){
        synchronized (SecFiveOne.class){
            counter2++;
        }

    }

}


