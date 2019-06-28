import java.util.Date;

public class Road extends Stage {

    public Road(int length){
        this.length = length;
        this.description = "Дорога, протяженностью " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try{
            System.out.println(c.getName() + " начал этап: " + description +" " + new Date().toString().substring(11,20));
            Thread.sleep(length/c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description +" " + new Date().toString().substring(11,20));
        } catch (InterruptedException e){
            e.getMessage();
            System.out.println("Ошибка при проезде по отрезку 'Road'");
        }
    }
}
