import java.util.Date;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{

    Semaphore semaphore;
    public Tunnel(Semaphore semaphore){
        this.semaphore = semaphore;
        this.length = 100;
        this.description = "Тоннель, протяженностью " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try{
            System.out.println(c.getName() + " подъехал к туннелю. " + new Date().toString().substring(11,20));
            semaphore.acquire();
            Thread.sleep(100);
            System.out.println(c.getName() + " заехал внутрь туннеля. "+ new Date().toString().substring(11,20));

            Thread.sleep(length/ c.getSpeed() * 1000);
            semaphore.release();
            System.out.println(c.getName()+ " выехал из туннеля! "+ new Date().toString().substring(11,20));

        } catch (InterruptedException e){
            e.getMessage();
            System.out.println("Ошибка рядом с туннелем!");
        }
    }
}
