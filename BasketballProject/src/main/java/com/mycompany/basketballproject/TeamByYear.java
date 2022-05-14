/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;

import java.util.ArrayList;


public class TeamByYear {
    String teamAcronym;
    String teamName;
    int teamYear;
    ArrayList<PlayerStats> playerStats = new ArrayList<>();
    ArrayList<Double> playerAverages = new ArrayList<>();
    
    private PlayerStats highestPointsPlayer;
    private PlayerStats highestAssistsPlayer;
    private PlayerStats highestReboundsPlayer;
    private PlayerStats highestBlocksPlayer;
    private PlayerStats highestStealsPlayer;
    
    private PlayerStats highestPPGPlayer;
    private PlayerStats highestAPGPlayer;
    private PlayerStats highestRPGPlayer;
    private PlayerStats highestBPGPlayer;
    private PlayerStats highestSPGPlayer;
    
    private double sgAverage = 0;
    private double pgAverage = 0;
    private double pfAverage = 0;
    private double sfAverage = 0;
    private double cAverage = 0;
    
    

    public TeamByYear(String teamAcronym, String teamName, int teamYear) {
        this.teamAcronym = teamAcronym;
        this.teamName = teamName;
        this.teamYear = teamYear;
    }
    
    public void addPlayerStats(PlayerStats playerStat){
        this.playerStats.add(playerStat);
    }

    public String getTeamAcronym() {
        return teamAcronym;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamYear() {
        return teamYear;
    }
    
    public PlayerStats getHighestPointsPlayer() {
        return highestPointsPlayer;
    }
      
    public void setHighestPointsPlayer() {
        if(this.highestPointsPlayer != null){
            return;
        }
        int highestScore = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getTotalPointsScored() > highestScore) {
                this.highestPointsPlayer = x;
                highestScore = x.getTotalPointsScored();
            }
        }
    }
    
    public PlayerStats getHighestAssistsPlayer() {
        return highestAssistsPlayer;
    }

    public void setHighestAssistsPlayer() {
        if(this.highestAssistsPlayer != null){
            return;
        }
        int totalAssists = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getTotalAssistsMade() > totalAssists) {
                this.highestAssistsPlayer = x;
                totalAssists = x.getTotalAssistsMade();
            }
        }
    }

    public PlayerStats getHighestBlocksPlayer() {
        return highestBlocksPlayer;
    }

    public void setHighestBlocksPlayer() {
        if(this.highestBlocksPlayer != null){
            return;
        }
        int totalBlocks = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getTotalBlocksMade() > totalBlocks) {
                this.highestBlocksPlayer = x;
                totalBlocks = x.getTotalBlocksMade();
            }
        }
    }

    public PlayerStats getHighestStealsPlayer() {
        return highestStealsPlayer;
    }

    public void setHighestStealsPlayer() {
        if(this.highestStealsPlayer != null){
            return;
        }
        int totalSteals = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getTotalStealsMade() > totalSteals) {
                this.highestStealsPlayer = x;
                totalSteals = x.getTotalStealsMade();
            }
        }
    }

    public PlayerStats getHighestPPGPlayer() {
        return highestPPGPlayer;
    }

    public void setHighestPPGPlayer() {
        if(this.highestPPGPlayer != null){
            return;
        }
        
        double ppg = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getPoints() > ppg && x.getGamesPlayed() > 19) {
                this.highestPPGPlayer = x;
                ppg = x.getPoints();
            }
        }
    }

    public PlayerStats getHighestAPGPlayer() {
        return highestAPGPlayer;
    }

    public void setHighestAPGPlayer() {
        if(this.highestAPGPlayer != null){
            return;
        }
        
        double apg = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getAssists() > apg && x.getGamesPlayed() > 19) {
                this.highestAPGPlayer = x;
                apg = x.getAssists();
            }
        }
    }

    public PlayerStats getHighestRPGPlayer() {
        return highestRPGPlayer;
    }

    public void setHighestRPGPlayer() {
        if(this.highestRPGPlayer != null){
            return;
        }
        
        double rpg = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getTotalRebounds() > rpg && x.getGamesPlayed() > 19) {
                this.highestRPGPlayer = x;
                rpg = x.getTotalRebounds();
            }
        }
        
    }

    public PlayerStats getHighestBPGPlayer() {
        return highestBPGPlayer;
    }

    public void setHighestBPGPlayer() {
        if(this.highestBPGPlayer != null){
            return;
        }
        
        double bpg = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getBlocks() > bpg && x.getGamesPlayed() > 19) {
                this.highestBPGPlayer = x;
                bpg = x.getBlocks();
            }
        }
    }

    public PlayerStats getHighestSPGPlayer() {
        return highestSPGPlayer;
    }

    public void setHighestSPGPlayer() {
        if(this.highestSPGPlayer != null){
            return;
        }
        
        double spg = 0;
        
        for(PlayerStats x : this.playerStats){
            
            if (x.getSteals() > spg && x.getGamesPlayed() > 19) {
                this.highestSPGPlayer = x;
                spg = x.getSteals();
            }
        }
    }

    
    public PlayerStats getHighestReboundsPlayer() {
        return highestReboundsPlayer;
    }
    public void setHighestReboundsPlayer() {
        if(this.highestReboundsPlayer != null){
            return;
        }
        
        double totalRebounds = 0;
        
        for(PlayerStats x : this.playerStats){
            if (x.getTotalReboundsMade() > totalRebounds) {
                this.highestReboundsPlayer = x;
                totalRebounds = x.getTotalReboundsMade();
            }
        }
    }
    
    public void setAverageShootingGaurd(){
        if (this.sgAverage !=0) {
            return;
        }
       
        this.sgAverage = averageScoreByPostion("SG");
    }
    public void setAveragePointGaurd(){
        if (this.pgAverage !=0) {
            return;
        }
        
        this.pgAverage = averageScoreByPostion("PG");
    }
    public void setAveragePowerForward(){
        if (this.pfAverage !=0) {
            return;
        }
        
        this.pfAverage = averageScoreByPostion("PF");
    }
    public void setAverageSmallForward(){
        if (this.sfAverage !=0) {
            return;
        }
        
        this.sfAverage = averageScoreByPostion("SF");
    }
    public void setAverageCenter(){
        if (this.cAverage !=0) {
            return;
        }
        
        this.cAverage = averageScoreByPostion("C");
    }
    
    public double averageScoreByPostion(String positionPlayed){
        double tempAverage = 0;
        int numberOfPlayers = 0;
        for(PlayerStats x : this.playerStats){
            if (!(x.getPositionPlayed().equals(positionPlayed))) {
                continue;
            }
            tempAverage += x.getPoints()/x.getMinutesPlayed();
            numberOfPlayers +=1;
            
        }
        return (tempAverage/numberOfPlayers)*48;
    }
    
    public int predictedTeamScore(){
        return (int)(this.cAverage + this.pfAverage + this.sfAverage + this.pgAverage + this.sgAverage);
    }
}
