
    // non-deterministic random-number generator
    SecureRandom random_numbers = new SecureRandom();
    // shifting value + random-number generator with scaling factor set to 1000
    // random number between 1 and 1000 (inclusive)
    int random_value = (1 + random_numbers.nextInt(1000));

    // primary program control loop
    boolean play_game = true;
    // while user wants to continue
    while (play_game == true) {

      // ask user for a new guess

      if (user_guess > random_value) {

      }
      else if (user_guess < random_value) {

      }
      else if (user_guess == random_value) {
        // congratulations

        // play again?
        
        switch (user_input.toUpperCase().charAt(0)) {
          // if yes
          case: 'Y'
            // simply get new random value
            random_value = (1 + random_numbers.nextInt(1000))
            break;
          // if no
          case: 'N'
            // break out of primary program control loop
            play_game = false;
          default: 
            break;
        }
      }


    }