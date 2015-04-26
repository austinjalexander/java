// Figure 23.15 Deitels Java HTP p986

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTestA
{
   public static void main(String[] args) throws InterruptedException
   {
      ExecutorService eS = Executors.newCachedThreadPool();
      Buffer sharedLocation1 = new BlockingBuffer();
      Buffer sharedLocation2 = new BlockingBuffer();
   
      eS.execute(new Producer1 (sharedLocation1));
      eS.execute(new Producer2 (sharedLocation2));

      /*** AJA NOTES: 

           // INTRODUCTION //
           THE FOLLOWING IS MY EXPLANATION REGARDING MY APPROACH TO THE 
           EXTRA CREDIT ASSIGNMENT. DURING MY EXPLANATION BELOW,
           WHERE I LIST PDF FILENAMES (E.G., output1.pdf),
           I AM INDICATING THAT I HAVE INCLUDED WITH THE SOURCE FILES 
           A PDF OF MY TERMINAL OUPTUT AT THAT POINT IN MY EXAMINATION 
           OF THE PROBLEM.

           // EXPLANTATION //
           AFTER LOOKING AT WHAT SEEMED TO BE CAUSING THE PROGRAM STALL 
           (SEE output1.pdf), IT APPEARED CLEAR THAT A TRUE DEADLOCK 
           (I.E., ONE RESOURCE WAITING FOR ANOTHER RESOURCE,
           WITH THE LATTER RESOURCE ALSO WAITING FOR THE FORMER) WAS NOT
           ACTUALLY THE PROBLEM. IN OTHER WORDS, IN THE CODE, 
           THERE IS NO PLACE WHERE Producer1 RELIES ON OR IS WAITING FOR 
           Producer2, AND VICE VERSA.

           RATHER, WHILE THERE WERE TWO Producers, THERE WERE SIMPLY
           NO Consumers, WHICH MEANT THAT THE INDEPENDENT Buffers REMAINED FULL, 
           NOT THAT ONE Producer WAS WAITING FOR THE OTHER.

           TO PROVE THIS INTERPRETATION OF THE PROBLEM, I SIMPLY SET THE SIZE 
           OF THE Buffer TO 2, WHICH IMMEDIATELY RESULTED IN THE PROGRAM STALLING 
           AFTER FOUR ITERATIONS (AS OPPOSED TO TWO). SEE output2.pdf.

           THEN I CREATED A Consumer FOR Producer1's Buffer (I.E., sharedLocation1),
           WHICH RESULTED IN THE PROGRAM COMPLETLY ITERATING THROUGH Producer1's
           FOR LOOP, ONLY STALLING AFTERWARD DUE TO Producer2 HAVING NOT
           BEEN CONSUMED (SEE output3.pdf).

           DOING THE EXACT SAME THING FOR Producer2 WHILE IGNORING Producer1
           LEADS TO THE EXPECTED RESULT (SEE output4.pdf).

           // CONCLUSION // 
           THUS, AFTER CREATING TWO Consumers (SEE THE TWO CODE LINES BELOW), 
           ONE FOR Producer1's Buffer AND ONE FOR Producer2's Buffer, 
           THE PROGRAM COMPLETELY ITERATED THROUGH BOTH Producer1's AND 
           Producer2's FOR LOOPS, ALLOWING THE PROGRAM TO TERMINATE SUCCESSFULLY 
           (SEE output5.pdf).

           FOR A TRUE EXAMPLE OF DEADLOCK, PLEASE SEE MY RESPONSE TO THE 
           HOMEWORK 6 PROBLEM STATEMENT.
      ***/
      eS.execute(new Consumer(sharedLocation1)); /*** ADDED BY AJA ***/
      eS.execute(new Consumer(sharedLocation2)); /*** ADDED BY AJA ***/
   
      eS.shutdown();
      eS.awaitTermination(1, TimeUnit.MINUTES);
   } 
}
