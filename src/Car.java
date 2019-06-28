import java.util.*;

public class Car implements Runnable{
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }


    private Race race;
    private int speed;
    private String name;


    public String getName(){
        return name;
    }

    public int getSpeed(){
        return speed;
    }


    public Car(Race race, int speed){
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник №" + CARS_COUNT;
        race.change(this.name, true);
    }


    @Override
    public void run(){
        try{
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 2000));
            System.out.println(this.name + " готов "  + new Date().toString().substring(11,20));
            race.ready();
            Thread.sleep(1000);
        } catch (Exception e){
            e.getMessage();
            System.out.println("Ошибка при подготовке участника");
        }
        for(int i = 0; i < race.getStages().size(); i++){
            race.getStages().get(i).go(this);

        }
        System.out.println(getName() +" завершил гонку! " + new Date().toString().substring(11,20));

        race.finished(getName());

        if(race.isEmpty()){
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>>> Гонка завершилась!");
        }

    }
}
