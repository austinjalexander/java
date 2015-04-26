// Figure 23.10 Deitels Java HTP p979

import java.security.SecureRandom;

public class Producer1 implements Runnable
{
   private static final SecureRandom generator = new SecureRandom();
   private final Buffer sharedLocation1;
   
   public Producer1 (Buffer sharedLocation1)
   {
      this.sharedLocation1 = sharedLocation1;
   }
   
   public void run()
   {
      int sum = 0;
      for (int count = 1; count <= 10; count++)
      {
         try
         {
            Thread.sleep (generator.nextInt(3000));
            System.out.println("Producer1 enters blockingPut()");
            sharedLocation1.blockingPut(count);
            sum += count;
//            System.out.printf ("\t\t%2d%n", sum);
            //System.out.printf("(p1-sum: %2d)\n", sum); /*** AJA ***/
         }
         catch (InterruptedException exception)
         {
            Thread.currentThread().interrupt();
         }
      }
      System.out.printf (
         "Producer1 done producing%nTerminating producer1%n");
   }
}