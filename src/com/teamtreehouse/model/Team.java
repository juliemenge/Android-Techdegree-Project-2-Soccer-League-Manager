package com.teamtreehouse.model;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

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

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }

    //creates a map of players on a team grouped by height
    public Map<String, List<Player>> playersByHeight() {
        Map<String, List<Player>> byHeight = new TreeMap<>();
        //add things to the map below with function to group height in player object
        for (Player player : mPlayers) {
            List<Player> playerHeightGroups = byHeight.get(player.playerHeightGroup());
            if (playerHeightGroups == null) {
                playerHeightGroups = new ArrayList<>();
                byHeight.put(player.playerHeightGroup(), playerHeightGroups);
            }
            playerHeightGroups.add(player);
        }
        return byHeight;
    }

    public void printPlayersByHeightGroup() {
        for (Map.Entry<String, List<Player>> entry : playersByHeight().entrySet()) {
            String key = entry.getKey();
            List<Player> players = entry.getValue();
            System.out.println(key);

            Iterator iterator;
            iterator = players.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next() + " ");
            }
            System.out.printf("%n");

        }
    }

    //get count of experienced and inexperienced players on a team
    public int getCountOfExperiencedPlayers() {
        int experienceCount = 0;

        for (Player player : mPlayers) {
            if (player.isPreviousExperience()) {
                experienceCount++;
            }
        }
        return experienceCount;
    }

    public int getCountOfInexperiencedPlayers() {
        int inexperiencedCount = 0;
        for (Player player : mPlayers) {
            if (!player.isPreviousExperience()) {
                inexperiencedCount++;
            }
        }
        return inexperiencedCount;
    }

}