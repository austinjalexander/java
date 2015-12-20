// GetAction.java: NAMED, EXTERNAL CLASS REPLACEMENT FOR THE ANONYMOUS INNER CLASS
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class GetAction implements ActionListener {

   // INSTANCE VARIABLES
   private final JTextArea textArea1; // displays demo string
   private final JTextArea textArea2; // highlighted text is copied here

   // CONSTRUCTOR
   public GetAction(JTextArea textArea1, JTextArea textArea2) {
      this.textArea1 = textArea1;
      this.textArea2 = textArea2;
   }

   // METHODS
   // set text in textArea2 to selected text from textArea1
   @Override
   public void actionPerformed(ActionEvent event) {
      this.textArea2.setText(this.textArea1.getSelectedText());
   }
} // end class GetAction
