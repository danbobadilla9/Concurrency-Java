package SeccionSix;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);


    public static void main(String[] args){
        LiveLockExample livelock = new LiveLockExample();
        new Thread(livelock::worker1,"worker1").start();
        new Thread(livelock::worker2,"worker2").start();
    }

    public void worker1(){
        while(true){
            try{
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("worker1 acquires the lock1");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("worker1 tries to get lock2");
            if(lock2.tryLock()){
                System.out.println("worker1 acquires the lock2");
                lock2.unlock();
            }else{
                System.out.println("worker1 can not acquire lock2...");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
    public void worker2(){
        while(true){
            try{
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("worker2 acquires the lock2");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("worker2 tries to get lock1");
            if(lock2.tryLock()){
                System.out.println("worker2 acquires the lock1");
                lock2.unlock();
            }else{
                System.out.println("worker2 can not acquire lock1...");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

}

