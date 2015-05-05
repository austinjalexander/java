// Fig. 12.48: TextAreaDemo.java (Deitels Java HTP p 541)
// Testing TextAreaFrame
import javax.swing.JFrame;

public class TextAreaDemo {
   public static void main(String[] args) {
      TextAreaFrameModified textAreaFrame = new TextAreaFrameModified();
      textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textAreaFrame.setSize(425, 200);
      textAreaFrame.setVisible(true);
   }
} // end class TextAreaDemo
