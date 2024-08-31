package SeccionFive;

public class SecFiveSecond {

    // para utiliar multiples locks podemos crear lo siguiente, creando objetos de manera independiente y utilizando sus locks
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static long counter = 0;
    public static long counter2 = 0;
    public static void main(String [] args){

    }
    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(long i = 0; i< 100000L; i++){
                    incrementS2();
                }
            }


        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(long i = 0; i< 100000; i++){
                    incrementS();
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


    public static void  incrementS(){
        synchronized(lock1){
            counter++;
        }
    }
    public static  void  incrementS2(){
        synchronized (lock2){
            counter2++;
        }

    }
}
