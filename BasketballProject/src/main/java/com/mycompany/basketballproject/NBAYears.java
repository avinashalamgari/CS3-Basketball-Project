/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class NBAYears {
    private int yearPlayed;
    ArrayList<TeamByYear> teamsPlayed = new ArrayList<>();

    public NBAYears(int yearPlayed) {
        this.yearPlayed = yearPlayed;
    }

    public int getYearPlayed() {
        return yearPlayed;
    }

    public void setTeamsPlayed(TeamByYear teamsPlayed) {
        // stores the teams that played in the NBA for that given season
        this.teamsPlayed.add(teamsPlayed);
    }
    
    
}
