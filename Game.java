/*====================================
  interface Game -- outlines basic methods of games

  METHODS:
  isGameOver() -- indicative of when game has culminated
  creditsEarned() -- returns credits user has earned
  ====================================*/ 

public interface Game {
    //returns true if the game is over, false otherwise
    boolean isGameOver();

    //returns the number of credits a player will earn towards their overall score
    //if they lose the game, will return 0
    //else will reutrn a predetermined number
    int creditsEarned();
}
    
