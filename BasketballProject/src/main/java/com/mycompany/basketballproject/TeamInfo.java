/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class TeamInfo {
   String teamAcronym;
   String teamName;
   ArrayList<PlayerStats> playerStats = new ArrayList<>();
   Set<Integer> yearsPlayed = new HashSet<>();
   ArrayList<TeamPlayerInfo> teamPlayerInfo = new ArrayList<>();
    private TeamPlayerInfo highestPointsPlayer;
    private TeamPlayerInfo highestAssistsPlayer;
    private TeamPlayerInfo highestReboundsPlayer;
    private TeamPlayerInfo highestBlocksPlayer;
    private TeamPlayerInfo highestStealsPlayer;
    
    private TeamPlayerInfo highestPPGPlayer;
    private TeamPlayerInfo highestAPGPlayer;
    private TeamPlayerInfo highestRPGPlayer;
    private TeamPlayerInfo highestBPGPlayer;
    private TeamPlayerInfo highestSPGPlayer;

    public TeamInfo(String teamAcronym) {
        this.teamAcronym = teamAcronym;
    }

    public String getTeamAcronym() {
        return teamAcronym;
    }

    
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public void addPlayerStats(PlayerStats playerStat){
        this.playerStats.add(playerStat);
    }

    public Set<Integer> getYearsPlayed() {
        return yearsPlayed;
    }

    public void setYearsPlayed(int yearPlayed){
        this.yearsPlayed.add(yearPlayed);
    }

    public TeamPlayerInfo getHighestPointsPlayer() {
        return highestPointsPlayer;
    }

    public void setHighestPointsPlayer() {
        int points = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getTotalPoints() > points){
                this.highestPointsPlayer = x;
                points = x.getTotalPoints();
            }
        }
    }

    public TeamPlayerInfo getHighestAssistsPlayer() {
        return highestAssistsPlayer;
    }

    public void setHighestAssistsPlayer() {
        int assists = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getTotalAssists() > assists){
                this.highestAssistsPlayer = x;
                assists = x.getTotalAssists();
            }
        }
    }

    public TeamPlayerInfo getHighestReboundsPlayer() {
        return highestReboundsPlayer;
    }

    public void setHighestReboundsPlayer(){
        int rebounds = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getTotalRebounds() > rebounds){
                this.highestReboundsPlayer = x;
                rebounds = x.getTotalRebounds();
            }
        }
    }

    public TeamPlayerInfo getHighestBlocksPlayer() {
        return highestBlocksPlayer;
    }

    public void setHighestBlocksPlayer() {
        int blocks = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getTotalBlocks() > blocks){
                this.highestBlocksPlayer = x;
                blocks = x.getTotalBlocks();
            }
        }
    }

    public TeamPlayerInfo getHighestStealsPlayer() {
        return highestStealsPlayer;
    }

    public void setHighestStealsPlayer() {
        int steals = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getTotalSteals() > steals){
                this.highestStealsPlayer = x;
                steals = x.getTotalSteals();
            }
        }
    }

    public TeamPlayerInfo getHighestPPGPlayer() {
        return highestPPGPlayer;
    }

    public void setHighestPPGPlayer() {
        double ppg = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getPpg() > ppg){
                this.highestPPGPlayer = x;
                ppg = x.getPpg();
            }
        }
    }

    public TeamPlayerInfo getHighestAPGPlayer() {
        return highestAPGPlayer;
    }

    public void setHighestAPGPlayer() {
        double apg = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getApg() > apg){
                this.highestAPGPlayer = x;
                apg = x.getApg();
            }
        }
    }

    public TeamPlayerInfo getHighestRPGPlayer() {
        return highestRPGPlayer;
    }

    public void setHighestRPGPlayer(){
        double rpg = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getRpg() > rpg){
                this.highestRPGPlayer = x;
                rpg = x.getRpg();
            }
        }
    }

    public TeamPlayerInfo getHighestBPGPlayer() {
        return highestBPGPlayer;
    }

    public void setHighestBPGPlayer() {
        double bpg = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getBpg() > bpg){
                this.highestBPGPlayer = x;
                bpg = x.getBpg();
            }
        }
    }

    public TeamPlayerInfo getHighestSPGPlayer() {
        return highestSPGPlayer;
    }

    public void setHighestSPGPlayer() {
        double spg = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            //System.out.println(x.getPlayerName() + " " + x.getTeamName() + " " + x.getTotalPoints());
            if(x.getSpg() > spg){
                this.highestSPGPlayer = x;
                spg = x.getSpg();
            }
        }
    }
    
    
    
    public void setTeamPlayerInfo(){
        for(PlayerStats x : this.playerStats){
            TeamPlayerInfo tempTeamPlayerInfo;
            tempTeamPlayerInfo = getTeamPlayerInfo(x.getPlayerID(), x.getPlayerName());
            tempTeamPlayerInfo.addPlayerStats(x);
            
        }
    }
    
    public void setAllTimeTeamPlayerPoints(){
        int points = 0;
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            if(x.getTotalPoints() > points){
                this.highestPointsPlayer = x;
            }
        }
    }
    
    public TeamPlayerInfo getTeamPlayerInfo(String playerID, String playerName){
        TeamPlayerInfo tempTeamPlayerInfo;
        
        for(TeamPlayerInfo x : this.teamPlayerInfo){
            if(x.getPlayerID().equals(playerID) && x.getPlayerName().equals(playerName)){
                return x;
            }
        }
        
        tempTeamPlayerInfo = new TeamPlayerInfo(playerID, playerName);
        tempTeamPlayerInfo.setTeamName(this.teamName);
        tempTeamPlayerInfo.setTeamAcronym(this.teamAcronym);
        this.teamPlayerInfo.add(tempTeamPlayerInfo);
        return tempTeamPlayerInfo;
        

    }
    
    
}
