
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main{
    public static final int CARS_COUNT = 4;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(4, new BarReady());
    private static final Semaphore SEMAPHORE = new Semaphore(2, true);
    private static final Map<String,Boolean> isOnRun = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Участники, готовимся к старту!");

        Race race = new Race(BARRIER, isOnRun, new Road(100), new Tunnel(SEMAPHORE), new Road(50));

        Car cars[] = new Car[CARS_COUNT];

        for (int i = 0; i<cars.length; i++){
            cars[i] = new Car(race, 20 + (int)(Math.random() * 10));

        }



        for (int i = 0; i< cars.length; i++){
            new Thread(cars[i]).start();

        }









    }
}