package com.teamtreehouse.controller;

import com.teamtreehouse.model.League;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;


import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Prompter {

  private Map<String, String>mMenu; //member variable for menu options
  private BufferedReader mReader;
  private League mLeague;
  private Player[] mPlayers;
  

  public Prompter(League league, Player[] players) {
    mReader = new BufferedReader (new InputStreamReader(System.in));
    mLeague = league;
    mPlayers = players;
    
    //creating the menu and adding options
    mMenu = new HashMap<String, String>();
    mMenu.put("create", "Create a new team.");
    mMenu.put("add", "Add player to a team.");
    mMenu.put("remove", "Remove a player from a team.");
    mMenu.put("print", "Print a roster of a team.");
    mMenu.put("quit", "Exit the program.");
  }
  
  //method to print all the menu options and ask user what they want to do
  private String promptAction() throws IOException {
    //loops through each menu option and prints them out
    for (Map.Entry<String, String> option : mMenu.entrySet()) {
      System.out.printf("%s - %s %n",
                        option.getKey(),
                        option.getValue());
    }
    System.out.printf("What do you want to do?: ");
    String choice = mReader.readLine(); //reads in what user has entered and assigns it to choice
    return choice.trim().toLowerCase(); //returns user's choice, trims off excess at beginning and end,converts to lowercase
  }
  
  //keeps asking the user what they want to do until they enter quit
  public void run() {
    String choice = ""; //initializing user's choice to nothing
    do { //goes through and asks user what they want to do at least one time
      try {
        choice = promptAction(); //assign user's choice to what they entered
        System.out.printf("Your choice is %s %n",
                          choice);
        switch(choice) { //does something depending on what the user entered
          case "create": //create a new team
            Team team = promptNewTeam();
            mLeague.addTeam(team);
            break;
          case "add": //ask what team to add to, in alphabetical order, asks what player you want to add
            System.out.printf("What team do you want the player to be on?%n");
            String teamChoice = chooseTeam();
            Team chosenTeam = mLeague.getTeam(teamChoice);
          
            System.out.printf("What player do you want to add to %s?%n", teamChoice);
            int playerChoice = Integer.parseInt(choosePlayer().trim());
            Player chosenPlayer = mPlayers[playerChoice];
            System.out.printf("You chose player %s", chosenPlayer.toString());
            chosenTeam.addPlayer(chosenPlayer);
          
            chosenTeam.printPlayers();
            break;
          case "remove":
            System.out.printf("What team do you want to remove a player from?%n");
            String removeTeamChoice = chooseTeam();
            Team removeFromChosenTeam = mLeague.getTeam(removeTeamChoice);
          
            System.out.printf("What player do you want to remove from %s?%n", removeTeamChoice);
            int removePlayerChoice = Integer.parseInt(choosePlayerFromTeam(removeFromChosenTeam));
            Player removeChosenPlayer = mPlayers[removePlayerChoice];
            removeFromChosenTeam.removePlayer(removeChosenPlayer);
          
            break;
          case "print":
            System.out.printf("What team do you want to print?");
            String printTeamChoice = chooseTeam();
            Team printChosenTeam = mLeague.getTeam(printTeamChoice);
            
            printChosenTeam.printPlayers();
            break;
          case "quit": //quit the program
            System.out.printf("Quitting the program. %n%n%n");
            break;
          default:
            System.out.printf("Unknown choice: %s. Try again. %n",
                             choice);
        }
      } catch(IOException ioe) {
        System.out.println("Problem with input");
        ioe.printStackTrace();
      }
    } while (!choice.equals("quit"));
  }
  
  //prompt user to enter all the fields needed to create a new team
  private Team promptNewTeam() throws IOException {
    System.out.print("Enter the team name: ");
    String teamName = mReader.readLine();
    System.out.print("Enter the coach's name: ");
    String coachName = mReader.readLine();
    
    return new Team(teamName, coachName);
  }
  
  //prints a list of teams alphabetically so user can choose 
  private String chooseTeam() throws IOException {
    Set<String> teamList = mLeague.getTeams();  
    for (String team : teamList) {
      System.out.println(team);
    }
    String teamChoice = mReader.readLine();
    return teamChoice;
   }
 
  
  private String choosePlayer() throws IOException {
    Arrays.sort(mPlayers);
    for(int i = 0; i < mPlayers.length; i++) {
      System.out.printf("%s - %s%n", i, mPlayers[i].toString());
    }
    
    String playerChoice = mReader.readLine();
    return playerChoice;
  }
  
  private String choosePlayerFromTeam(Team team) throws IOException {
    Player playersOnTeam[] = team.getPlayers().toArray(new Player[team.getPlayers().size()]);
    Arrays.sort(playersOnTeam);
    for(int i = 0; i < playersOnTeam.length; i++) {
      System.out.printf("%s - %s%n", i, playersOnTeam[i].toString());
    }
    String playerChoice = mReader.readLine();
    return playerChoice;
  }
  
  
}

