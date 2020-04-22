package EKG;

import java.time.LocalDateTime;
import java.security.Timestamp;

public class EKGSimulator implements EKGSampler, Runnable {
    private EKGListener listener;

    public void run() {
        while(){
            try(true){
                Thread.sleep(1000);
                if(listener !=null){
                    LocalDateTime now = LocalDateTime.now();
                    listener.notify(
                            new EKGData(1000*Math.random(), new Timestamp(LocalDateTime.now().getNano()/1000)));
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
    @Override
    public void register(EKGListener listener){
        this.listener = listener;
    }
}
