package start;

public class AppTwo {

    public static void main (String[] args){

        // java los ejecuta de una manera secuencial
        System.out.println("Hello word ");
        System.out.println("Hello word ");
        System.out.println("Hello word ");
        // otra muestra de que se ejecuta de manera secuencial
        Thread runner1 = new Thread(new Runner1());
        Thread runner2 = new Thread(new Runner2());
        runner1.start();
        runner2.start();
        // utilizando clases anonimas
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    System.out.println("Runner 3: "+i);
                }
            }
        });
        t1.start();


    }

}

// hay dos maneras para implementar hilos, la primera es implementar la interfaz
// runnable y el metodo run
// como veremos java utiliza le timeslising algoritmo para darles un tiempo a ambos
// hilos para poder ejecutarse una despues de otro,
// NO SE ESTAN EJECUTANDO DE MANERA PARALELA
class Runner1 implements  Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("Runner 1: "+i);
        }
    }


}

class Runner2  implements  Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("Runner 2: "+i);
        }
    }


}
