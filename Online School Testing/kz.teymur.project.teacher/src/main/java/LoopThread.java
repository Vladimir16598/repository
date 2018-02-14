public class LoopThread implements Runnable {

    @Override
    public void run() {
        while (true){
            Database.getOnlineUsers();
            Database.getLisTests();
            Database.getResults();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
