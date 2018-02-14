/**
 * Created by Теймур on 11.02.2015.
 */
public class LoopThread implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                Database.getResults();
                Database.getLisTests();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
