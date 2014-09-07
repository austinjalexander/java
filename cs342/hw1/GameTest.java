import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests for {@link Foo}
 *
 * @author austinja@bu.edu (Austin J. Alexander)
 *
 */

public class GameTest {
  
  @Test
  public void testPlay() {
    System.out.println("Test that play() works.");
    Game new_game = new Game();
    new_game.play();
  }

} 