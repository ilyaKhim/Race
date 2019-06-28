import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    private Map<String,Boolean> isOnRun;
    private CyclicBarrier barrier;
    public ArrayList<Stage> getStages(){return stages;}
    public Race(CyclicBarrier barrier, Map<String,Boolean> isOnRun, Stage...stages){
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.barrier = barrier;
        this.isOnRun = isOnRun;
    }

    public void change(String name, boolean status){
        isOnRun.put(name,status);
    }

    public boolean isEmpty(){
        return isOnRun.isEmpty();
    }


    public void finished(String name){
        isOnRun.remove(name);
    }

    public void ready(){
        try {
            barrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
