package SeccionSix;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLocks {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);



    public static void main(String [] args){
    // creando threads utilizando lambas, esto utilizando > java 8
        DeadLocks deadLocks = new DeadLocks();
        new Thread(deadLocks::worker1,"worker1").start();
        new Thread(deadLocks::worker2,"worker2").start();
    }

    public void worker1(){
        lock1.lock();
        System.out.println("Worker1 acquires the lock1....");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("Worker1 acquired the lock2.....");
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2(){
        // para corregir el error solo hay que cambiar el orden de los locks utilizando el del worker1
        lock2.lock();
        System.out.println("Worker2 acquires the lock2....");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock1.lock();
        System.out.println("Worker2 acquired the lock1.....");
        lock1.unlock();
        lock2.unlock();
    }


}
