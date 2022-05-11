/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;

import java.util.ArrayList;

/**
 *
 * @author husker@us.ibm.com
 */
public class PlayerInfo {
    private String playerID;
    private String playerName;
    private int totalPoints;
    private int totalAssists;
    private int totalRebounds;
    private int totalBlocks;
    private int totalSteals;
    ArrayList<PlayerStats> playerStats = new ArrayList<>();

    public PlayerInfo(String playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }
    
    public void addPlayerStats(PlayerStats playerStat){
        this.playerStats.add(playerStat);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints() {
        int points = 0;
        for(PlayerStats x : this.playerStats){
            points += x.getTotalPointsScored();
        }
        this.totalPoints = points;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists() {
        int assists = 0;
        for(PlayerStats x : this.playerStats){
            assists += x.getTotalAssistsMade();
        }
        this.totalAssists = assists;
    }

    public int getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds() {
        int rebounds = 0;
        for(PlayerStats x : this.playerStats){
            rebounds += x.getTotalReboundsMade();
        }
        this.totalRebounds = rebounds;
    }

    public int getTotalBlocks() {
        return totalBlocks;
    }

    public void setTotalBlocks() {
        int blocks = 0;
        for(PlayerStats x : this.playerStats){
            blocks += x.getTotalBlocksMade();
        }
        this.totalBlocks = blocks;
    }

    public int getTotalSteals() {
        return totalSteals;
    }

    public void setTotalSteals() {
        int steals = 0;
        for(PlayerStats x : this.playerStats){
            steals += x.getTotalStealsMade();
        }
        this.totalSteals = steals;
    }
    
    
    
    
    
}
