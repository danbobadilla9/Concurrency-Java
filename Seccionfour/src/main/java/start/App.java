package start;

public class App {

    public static void main (String[] args){

        // java los ejecuta de una manera secuencial
        System.out.println("Hello word ");
        System.out.println("Hello word ");
        System.out.println("Hello word ");
        // otra muestra de que se ejecuta de manera secuencial
        Runnerr1 runner1 = new Runnerr1();
        Runnerr2 runner2 = new Runnerr2();
        runner1.execute();
        runner2.execute();


    }

}

class Runnerr1 {
    public void execute(){
        for(int i = 0; i < 100; i++){
            System.out.println("Runner 1: "+i);
        }
    }
}

class Runnerr2 {
    public void execute(){
        for(int i = 0; i < 100; i++){
            System.out.println("Runner 2: "+i);
        }
    }
}
