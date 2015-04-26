// Figure 23.9 Deitels Java HTP p 978

public interface Buffer
{
   public void blockingPut (int value) throws InterruptedException;
   
   public int blockingGet () throws InterruptedException;
}