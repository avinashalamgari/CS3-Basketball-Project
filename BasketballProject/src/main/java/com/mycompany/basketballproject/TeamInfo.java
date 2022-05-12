/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author husker@us.ibm.com
 */
public class TeamInfo {
   String teamAcronym;
   String teamName;
   ArrayList<PlayerStats> playerStats = new ArrayList<>();
   Set<Integer> yearsPlayed = new HashSet<>();

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
    
}
