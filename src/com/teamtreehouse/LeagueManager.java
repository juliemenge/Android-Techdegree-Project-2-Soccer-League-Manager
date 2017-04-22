import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.controller.Prompter;
import com.teamtreehouse.model.League;

import java.util.HashMap;
import java.util.Map;

public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!
    League league = new League();
    Prompter prompter = new Prompter(league, players);
    prompter.run();
    
  }

}
