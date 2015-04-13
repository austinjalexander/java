// File: TextFieldHandler.java
// Student: Austin J. Alexander
// Assignment: Homework Assignment 5
// Course: MET CS565 (SPRING 2015)


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TextFieldHandler extends JFrame implements ActionListener {


// process text field events
@Override
public void actionPerformed(ActionEvent event) {
    if (event.getSource() == "1") {
        setBackground(Color.BLACK);
    }

} //end: public void actionPerformed(ActionEvent event)




} //end: TextFieldHandler implements ActionListener 


