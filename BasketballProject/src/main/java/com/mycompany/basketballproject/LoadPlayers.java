/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author husker@us.ibm.com
 */
public class LoadPlayers {
    ArrayList<PlayerInfo> allPlayers = new ArrayList<>();
    ArrayList<YearlyStats> allYearlyStats  = new ArrayList<>();

    public LoadPlayers() throws FileNotFoundException, IOException {
        loadPlayers();
    }
    // /Users/husker@us.ibm.com/Documents/Avi Tests/nba.txt
    String statsFile = "C:\\Users\\User\\Documents\\NBA Stats\\csv files\\NBA.txt";
    public final void loadPlayers() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(statsFile));  
        String line = null;  
        while ((line = br.readLine()) != null) {
            int fileYear = Integer.parseInt(line.substring(53, 57));
//            System.out.println("The year of file is " + fileYear);
            csvRead(line, fileYear);
//            System.out.println("Processed file" + line);
   
        } 
//        String tempSeasonFile = "/Users/husker@us.ibm.com/Downloads/2001-2002.csv";
//        
//        csvRead(tempSeasonFile);
//        
        updatePlayerPoints();
    }
    
    public void csvRead(String csvFile, int fileYear) {
        boolean firstLine = true;
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                String[] tempArr;
                while((line = br.readLine()) != null) {
                    if(firstLine){
                        firstLine = false;
                        continue;
                    }
                    tempArr = line.split(",");
                    String[] tempPlayerName = tempArr[1].split("\\\\");
                    String playerName = tempPlayerName[0];
                    String playerID = tempPlayerName[1];
                    String positionPlayed = tempArr[2];
                    String teamName = tempArr[4];
                    int gamesPlayed = Integer.valueOf(tempArr[5]);
                    Double minutesPlayed = ParseDouble(tempArr[7]);
                    Double fieldGoals = ParseDouble(tempArr[8]);
                    Double fieldGoalsAttempted = ParseDouble(tempArr[9]);
                    Double fieldGoalPercentage = ParseDouble(tempArr[10]);
                    Double threePointsMade = ParseDouble(tempArr[11]);
                    Double threePointsAttempted = ParseDouble(tempArr[12]);
                    Double threePointsPercentage = ParseDouble(tempArr[13]);
                    Double twoPointsMade = ParseDouble(tempArr[14]);
                    Double twoPointsAttempted = ParseDouble(tempArr[15]);
                    Double twoPointsPercentage = ParseDouble(tempArr[16]);
                    Double totalFieldGoalPercentage = ParseDouble(tempArr[17]);
                    Double freeThrows = ParseDouble(tempArr[18]);
                    Double freeThrowsAttempted = ParseDouble(tempArr[19]);
                    Double freeThrowsPercentage = ParseDouble(tempArr[20]);
                    Double offensiveRebounds = ParseDouble(tempArr[21]);
                    Double defensiveRebounds = ParseDouble(tempArr[22]);
                    Double totalRebounds = ParseDouble(tempArr[23]);
                    Double assists = ParseDouble(tempArr[24]);
                    Double steals = ParseDouble(tempArr[25]);
                    Double blocks = ParseDouble(tempArr[26]);
                    Double turnOvers = ParseDouble(tempArr[27]);
                    Double personalFouls = ParseDouble(tempArr[28]);
                    Double points = ParseDouble(tempArr[29]);
                    
                    if (teamName.equals("TOT")){
                        continue;
                    }
                    PlayerInfo tempPlayer;
                    if (findPlayer(playerID)){
                        tempPlayer = getPlayer(playerID);
                        
                    } else {
                        tempPlayer = new PlayerInfo(playerID, playerName);
                        allPlayers.add(tempPlayer);
                    }
                    
                    PlayerStats tempPlayerStats;
                    tempPlayerStats = new PlayerStats( 
                            playerID,
                            fileYear,
                            teamName,
                            positionPlayed,
                            gamesPlayed,
                            minutesPlayed,
                            fieldGoals,
                            fieldGoalsAttempted,
                            fieldGoalPercentage,
                            threePointsMade,
                            threePointsAttempted,
                            threePointsPercentage,
                            twoPointsMade,
                            twoPointsAttempted,
                            twoPointsPercentage,
                            totalFieldGoalPercentage,
                            freeThrows,
                            freeThrowsAttempted,
                            freeThrowsPercentage,
                            offensiveRebounds,
                            defensiveRebounds,
                            totalRebounds,
                            assists,
                            steals,
                            blocks,
                            turnOvers,
                            personalFouls,
                            points,
                            playerName
                    );
                    
                    tempPlayer.addPlayerStats(tempPlayerStats);
                    
                    YearlyStats tempYear;
                    tempYear = getYearInfo(fileYear);
                    tempYear.addPlayerStats(tempPlayerStats);
                    
                }
            }
         } catch(IOException ioe) {
         }
   }
    
    public Boolean findPlayer(String playerID){
        for(PlayerInfo tempPlayer : allPlayers){
            if (tempPlayer.getPlayerID().equals(playerID)){
                return true;
            }
        }
        return false;
    }
    
    public PlayerInfo getPlayer(String playerID){
        for(PlayerInfo tempPlayer : allPlayers){
            if (tempPlayer.getPlayerID().equals(playerID)){
                return tempPlayer;
            }
        }
        return null;
    }
    
    public double ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch(NumberFormatException e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        }
        else return 0;
    }
    
    public void updatePlayerPoints(){
        
        for(PlayerInfo tempPlayer : allPlayers){
            for(PlayerStats tempPlayerStat : tempPlayer.playerStats){
                tempPlayerStat.updateTotalPoints();
                tempPlayerStat.updateTotalRebounds();
                tempPlayerStat.updateTotalAssists();
                tempPlayerStat.updateTotalBlocks();
                tempPlayerStat.updateTotalSteals();                
            }
            tempPlayer.setTotalPoints();
            tempPlayer.setTotalAssists();
            tempPlayer.setTotalRebounds();
            tempPlayer.setTotalBlocks();
            tempPlayer.setTotalSteals();
        }
        
    }
    
    public YearlyStats getYearInfo(int tempYear){
        YearlyStats tempYearlyStats;
        
        for(YearlyStats x : allYearlyStats){
            if (x.getYearPlayed() == tempYear){
                return x;
            }
        }
        
        tempYearlyStats = new YearlyStats(tempYear);
        allYearlyStats.add(tempYearlyStats);
        return tempYearlyStats;
        
    }
}
