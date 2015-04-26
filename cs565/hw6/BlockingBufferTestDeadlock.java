// Figure 23.15 Deitels Java HTP p986

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTestA
{
   public static void main(String[] args) throws InterruptedException
   {
      ExecutorService eS = Executors.newCachedThreadPool();
      Buffer sharedLocation = new BlockingBuffer();
   
      eS.execute(new Producer (sharedLocation1));

      eS.execute(new Consumer(sharedLocation1)); /*** ADDED BY AJA ***/
      eS.execute(new Consumer(sharedLocation2)); /*** ADDED BY AJA ***/
   
      eS.shutdown();
      eS.awaitTermination(1, TimeUnit.MINUTES);
   } 
}
