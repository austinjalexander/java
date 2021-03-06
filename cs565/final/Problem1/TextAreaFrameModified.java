// Fig. 12.47: TextAreaFrameModified.java (Deitels Java HTP p 540)
// Copying selected text from one JTextArea to another
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrameModified extends JFrame {
   private final JTextArea textArea1; // displays demo string
   private final JTextArea textArea2; // highlighted text is copied here
   private final JButton copyJButton; // initiates copying of text

   // no-argument constructor
   public TextAreaFrameModified() {
      super("TextArea Demo");
      Box box = Box.createHorizontalBox(); // create box
      String demo = "This is a demo string to\n" +
         "illustrate copying text\nfrom one textarea to \n" +
         "another textarea using an\nexternal event\n";

      textArea1 = new JTextArea(demo, 10, 15);
      box.add(new JScrollPane(textArea1)); // add scrollpane

      copyJButton = new JButton("Copy >>>"); // create copy button
      box.add(copyJButton); // add copy button to box

      textArea2 = new JTextArea(10, 15);
      textArea2.setEditable(false);
      box.add(new JScrollPane(textArea2)); // add scrollpane

      /*** AJA NOTES ***/
      // ASIDE FROM MOVING SOME THINGS AROUND, THE FOLLOWING TWO LINES
      // ARE THE PRIMARY LINES MODIFIED FROM THE ORIGINAL TextAreaFrame.java FILE:
      GetAction get_action = new GetAction(textArea1,textArea2);
      copyJButton.addActionListener(get_action);

      add(box); // add box to frame
   }

} // end class TextAreaFrameModified
