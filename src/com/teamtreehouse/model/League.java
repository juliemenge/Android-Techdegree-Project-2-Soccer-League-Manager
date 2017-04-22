package com.teamtreehouse.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class League {
  private Map<String, Team> mTeams;
  
  public League() {
    mTeams = new TreeMap<String, Team>();
  }
  
  //return all the team names
  public Set<String> getTeams() {
    return mTeams.keySet();
  }
  
  //returns team if it exists
  public Team getTeam(String teamName) {
     return mTeams.get(teamName);
  }
  
  public void addTeam(Team team) {
    mTeams.put(team.getTeamName(), team);
  }
  
  
}