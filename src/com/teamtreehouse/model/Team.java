package com.teamtreehouse.model;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mTeamName;
  private String mCoachName;
  private Set<Player> mPlayers;
  
  public Team(String teamName, String coachName) {
    mTeamName = teamName;
    mCoachName = coachName;
    mPlayers = new TreeSet<>();
  }
  
  public String getTeamName() {
    return mTeamName;
  }
  
  public String getCoachName() {
    return mCoachName;
  }
  
  //add a player to the team
  public void addPlayer(Player player) {
    mPlayers.add(player);
    int x = 1;
  }
  
  //remove a player from a team
  public void removePlayer(Player player) {
    mPlayers.remove(player);
  }
  
  //return all players on a team
  public Set<Player> getPlayers() {
    return mPlayers;
  }
  
  //print all players on a team
  public void printPlayers() {
    Iterator iterator;
    iterator = mPlayers.iterator();
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next() + " ");
    }
  }

  
}