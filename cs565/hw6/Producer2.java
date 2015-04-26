// Figure 23.10 Deitels Java HTP p979

import java.security.SecureRandom;

public class Producer2 implements Runnable
{
   private static final SecureRandom generator = new SecureRandom();
   private final Buffer sharedLocation2;
   
   public Producer2 (Buffer sharedLocation2)
   {
      this.sharedLocation2 = sharedLocation2;
   }
   
   public void run()
   {
      int sum = 0;
      for (int count = 1; count <= 10; count++)
      {
         try
         {
            Thread.sleep (generator.nextInt(3000));
            sum += count; 
            System.out.println("Producer2 enters blockingPut()");
            sharedLocation2.blockingPut(sum);
//            System.out.printf ("\t\t%2d%n", sum);
            //System.out.printf("(p2-sum: %2d)\n", sum); /*** AJA ***/
         }
         catch (InterruptedException exception)
         {
            Thread.currentThread().interrupt();
         }
      }
      System.out.printf (
         "Producer2 done producing%nTerminating producer2%n");
   }
}