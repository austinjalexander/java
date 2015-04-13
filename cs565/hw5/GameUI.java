// File: GameUI.java
// Student: Austin J. Alexander
// Assignment: Homework Assignment 5
// Course: MET CS565 (SPRING 2015)

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GameUI extends JFrame {

  // INSTANCE VARIABLES
  private final JLabel game_instruct;
  private final JLabel prompt;
  private final JLabel message;
  private final JButton game_restart_button;
  private final JButton game_exit_button;

  private int number_to_guess;
  private int last_user_guess;
  private int current_guess_diff;
  private Integer last_guess_diff;
  private JTextField user_text_input;

  private UserTextInputHandler user_text_input_handler;
  private GameRestartButtonHandler game_restart_button_handler;
  private GameExitButtonHandler game_exit_button_handler;


  // CONSTRUCTOR 
  public GameUI() {

    // call parent JFrame constructor; provide title for title bar
    super("GUESS THE NUMBER");
    // set layout type
    setLayout(new FlowLayout());
    // set background to light gray
    getContentPane().setBackground(Color.LIGHT_GRAY);

    // set secret number
    number_to_guess = 13;

    // display game instructions
    game_instruct = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
    add(game_instruct);

    // guess prompt and text field
    last_guess_diff = null;
    prompt = new JLabel("Please enter your guess: ");
    add(prompt);
    user_text_input = new JTextField(5);
    add(user_text_input);

    // register user text input event handler
    user_text_input_handler = new UserTextInputHandler();
    user_text_input.addActionListener(user_text_input_handler);

    // display game exit button
    game_exit_button = new JButton("Exit");
    add(game_exit_button);

    // register game exit button event handler
    game_exit_button_handler = new GameExitButtonHandler();
    game_exit_button.addActionListener(game_exit_button_handler);

    // message label
    message = new JLabel();
    add(message);

    // play again restart button (will not display until game is won)
    game_restart_button = new JButton("Play again?");

    // register game restart button event handler
    game_restart_button_handler = new GameRestartButtonHandler();
    game_restart_button.addActionListener(game_restart_button_handler);
      
  }//end: public GameUI()


  // INNER CLASSES
  // private inner class to handle user text input event
  private class UserTextInputHandler implements ActionListener {

    // process user text input event
    @Override
    public void actionPerformed(ActionEvent event) {

      try {
        // attempt to parse string as int
        int current_user_guess = Integer.parseInt(event.getActionCommand());
        // if exception is not raised, 
        // reset warning message
        message.setText("");

        // if the user guessed the number
        if (current_user_guess == number_to_guess) {
          // disable user text input field
          user_text_input.setEditable(false);
          // display the message to the user
          message.setText("Correct!");
          // set background to green
          getContentPane().setBackground(Color.GREEN);

          // play again? (add button to JFrame)
          add(game_restart_button);

        }
        // otherwise, if the current guess is not the number to guess
        else if (current_user_guess != number_to_guess) {

          // if guess is too high
          if (current_user_guess > number_to_guess) {
            message.setText("Too High!");
          }
          // if guess is too low
          else if (current_user_guess < number_to_guess) {
            message.setText("Too Low!");
          }

          // calculate the absolute difference between the 
          // the number to guess and the current guess
          current_guess_diff = Math.abs(number_to_guess - current_user_guess);

          // if this isn't the first guess,
          // compare this guess to the last one
          if (last_guess_diff != null) {

            // if the current guess is farther away from the number to guess
            // than the last guess
            if (current_guess_diff > last_guess_diff) {
              // set background to blue
              getContentPane().setBackground(Color.BLUE);
            }
            // if the current guess is closer to the number to guess
            // than the last guess
            else if (current_guess_diff < last_guess_diff) {
              // set background to red
              getContentPane().setBackground(Color.RED);
            }
          }//end: if (last_user_guess != null)

          // set last guess difference to the current difference
          last_guess_diff = current_guess_diff;

          // set the last user guess to the current guess
          last_user_guess = current_user_guess;

        }//end: else if (current_user_guess != number_to_guess)
      }//end: public void actionPerformed(ActionEvent event)

      catch (Exception e) {
        message.setText("Integers only!");
      }//end: catch (Exception e)
      
    }//end: public void actionPerformed(ActionEvent event)
  }//end: private class UserTextInputHandler implements ActionListener

  // private inner class to handle game restart button event
  private class GameRestartButtonHandler implements ActionListener {

    // process game restart button event
    @Override
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == game_restart_button) {
        // generate at new number to guess,
        // reset or change variables to bogus values
        number_to_guess = 100;
        last_user_guess = -1;
        current_guess_diff = -1; 
        last_guess_diff = null;

        // re-enable user text input field
        user_text_input.setEditable(true);
        // remove message
        message.setText("");
        // set background to light gray
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // remove game restart button
        remove(game_restart_button);

      }
    }//end: public void actionPerformed(ActionEvent event)
  }//end: private class GameRestartButtonHandler implements ActionListener

  // private inner class to handle game exit button event
  private class GameExitButtonHandler implements ActionListener {

    // process game exit button event
    @Override
    public void actionPerformed(ActionEvent event) {
      // if user clicks exit button, terminate program
      if (event.getSource() == game_exit_button) {
        System.exit(0);
      }
    }//end: public void actionPerformed(ActionEvent event)
  }//end: private class GameExitButtonHandler implements ActionListener





}//end: public class GameUI extends JFrame




