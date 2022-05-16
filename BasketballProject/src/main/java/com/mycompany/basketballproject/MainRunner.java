/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class MainRunner {
    
    public static ArrayList<Integer> nbaYears = new ArrayList();
    //hello world
    public static void main(String[] args) throws IOException {
        load_nba_years(nbaYears);
        load_nba_players();
        
    }
    
    public static void load_nba_years(ArrayList<Integer> nbaYears){
        for(int i = 1980; i <2022; i++){
            nbaYears.add(i);
        }
        
    }
    
    public static void load_nba_players() throws IOException {
        LoadPlayers loadPlayers = new LoadPlayers();
        
//        for(PlayerInfo tempPlayer : loadPlayers.allPlayers){
//            System.out.println(tempPlayer.getPlayerID());
//            for(PlayerStats tempStats: tempPlayer.playerStats){
//                System.out.println(tempStats.getPositionPlayed() + " " + tempStats.getTotalRebounds() + " " + tempStats.getPoints() + " " + tempStats.getTotalPointsScored());
//            }
//        }


//        for(YearlyStats x: loadPlayers.allYearlyStats){
//            x.setHighestReboundsPlayer();
//            x.setHighestScoringPlayer();
//            for(PlayerStats tempStats : x.playerStats){
//                System.out.println(tempStats.getPlayerName() + " " + tempStats.getPositionPlayed() + " " + tempStats.getTotalRebounds() + " " + tempStats.getPoints() + " " + tempStats.getTotalPointsScored());
//            }
//            
//            System.out.println("The highest rebounder was " + " " + x.getHighestReboundsPlayer().getPlayerName() + " " + x.getHighestReboundsPlayer().getTotalRebounds());
//            System.out.println("The highest scorer was " + " " + x.getHighestScoringPlayer().getPlayerName()  + " " + x.getHighestScoringPlayer().getTotalPointsScored());
//        }

//        for(YearlyStats x: loadPlayers.allYearlyStats){
//            System.out.println(x.getYearPlayed());
//            x.setHighestReboundsPlayer();
//            x.setHighestPointsPlayer();
//            x.setHighestReboundsPlayer();
//            System.out.println("The highest rebounder was " + " " + x.getHighestReboundsPlayer().getPlayerName() + " " + x.getHighestReboundsPlayer().getTotalRebounds());
//            System.out.println("The highest scorer was " + " " + x.getHighestPointsPlayer().getPlayerName()  + " " + x.getHighestPointsPlayer().getTotalPointsScored());
//            System.out.println("The highest rebounder total was " + " " + x.getHighestReboundsPlayer().getPlayerName() + " " + x.getHighestReboundsPlayer().getTotalReboundsMade());
//            
//        }
         PlayerInfo tempPlayer = null;
         int totalPoints = 0;
         for(PlayerInfo x : loadPlayers.allPlayers){
             if(x.getTotalRebounds() > totalPoints){
                 tempPlayer = x;
                 totalPoints = x.getTotalRebounds();
             }
         }
         System.out.println("Name and score of player: " + tempPlayer.getPlayerName() + " " + tempPlayer.getTotalRebounds());
         
        
         
         for(NBAYears z : loadPlayers.nbaYears){
             if(z.getYearPlayed() == 2021){
                 for(TeamByYear x : z.teamsPlayed){
                     System.out.println("Team and Score: " + x.teamName + " " + x.getTeamAverage());
                 }
                 //System.out.println(z.getYearPlayed() + " " + z.teamsPlayed.size());
             }

         }
    }
    
    
    
}
