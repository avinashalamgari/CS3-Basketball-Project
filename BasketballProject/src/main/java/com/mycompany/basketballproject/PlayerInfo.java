/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;

import java.util.ArrayList;


public class PlayerInfo {
    private String playerID;
    private String playerName;
    private int totalPoints;
    private int totalAssists;
    private int totalRebounds;
    private int totalBlocks;
    private int totalSteals;
    
    private double ppg;
    private double apg;
    private double rpg;
    private double bpg;
    private double spg;
    private int totalGamesPlayed;
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

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }
    
    
    public void setTotalGamesPlayed(){
        int games = 0;
        for(PlayerStats x : this.playerStats){
            games += x.getGamesPlayed();
        }
        this.totalGamesPlayed = games;
    }

    public double getPpg() {
        return ppg;
    }

    public void setPpg() {
        double tempPPG = (double)(this.getTotalPoints() * 1.0 / this.getTotalGamesPlayed());
        this.ppg = Math.round(tempPPG * 100.0) / 100.0;
    }

    public double getApg() {
        return apg;
    }

    public void setApg() {
        double tempAPG = (double)(this.getTotalAssists() * 1.0 / this.getTotalGamesPlayed());
        this.apg = Math.round(tempAPG * 100.0) / 100.0;
    }

    public double getRpg() {
        return rpg;
    }

    public void setRpg() {
        double tempRPG = (double)(this.getTotalRebounds() * 1.0 / this.getTotalGamesPlayed());
        this.rpg = Math.round(tempRPG * 100.0) / 100.0;
    }

    public double getBpg() {
        return bpg;
    }

    public void setBpg() {
        double tempBPG = (double)(this.getTotalBlocks() * 1.0 / this.getTotalGamesPlayed());
        this.bpg = Math.round(tempBPG * 100.0) / 100.0;
    }

    public double getSpg() {
        return spg;
    }

    public void setSpg() {
        double tempSPG = (double)(this.getTotalSteals() * 1.0 / this.getTotalGamesPlayed());
        this.spg = Math.round(tempSPG * 100.0) / 100.0;
    }
    
    
    
    
    
}
