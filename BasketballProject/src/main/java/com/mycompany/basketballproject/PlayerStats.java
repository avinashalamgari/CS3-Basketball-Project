/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basketballproject;

/**
 *
 * @author husker@us.ibm.com
 */
public class PlayerStats {
    private String playerID;
    private int yearPlayed;
    private String teamName;
    private String positionPlayed;
    private int gamesPlayed;
    private double minutesPlayed;
    private double fieldGoals;
    private double fieldGoalsAttempted;
    private double fieldGoalPercentage;
    private double threePointsMade;
    private double threePointsAttempted;
    private double threePointsPercentage;
    private double twoPointsMade;
    private double twoPointsAttempted;
    private double twoPointsPercentage;
    private double totalFieldGoalPercentage;
    private double freeThrows;
    private double freeThrowsAttempted;
    private double freeThrowsPercentage;
    private double offensiveRebounds;
    private double defensiveRebounds;
    private double totalRebounds;
    private double assists;
    private double steals;
    private double blocks;
    private double turnOvers;
    private double personalFouls;
    private double points;
    private String playerName;
// to be calculated
    private int totalPointsScored;
    private int totalReboundsMade;
    private int totalAssistsMade;
    private int totalBlocksMade;
    private int totalStealsMade;

    
    
    

    public PlayerStats(String playerID, int yearPlayed, String teamName, String positionPlayed, int gamesPlayed, double minutesPlayed, double fieldGoals, double fieldGoalsAttempted, double fieldGoalPercentage, double threePointsMade, double threePointsAttempted, double threePointsPercentage, double twoPointsMade, double twoPointsAttempted, double twoPointsPercentage, double totalFieldGoalPercentage, double freeThrows, double freeThrowsAttempted, double freeThrowsPercentage, double offensiveRebounds, double defensiveRebounds, double totalRebounds, double assists, double steals, double blocks, double turnOvers, double personalFouls, double points, String playerName) {
        this.playerID = playerID;
        this.yearPlayed = yearPlayed;
        this.teamName = teamName;
        this.positionPlayed = positionPlayed;
        this.gamesPlayed = gamesPlayed;
        this.minutesPlayed = minutesPlayed;
        this.fieldGoals = fieldGoals;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.fieldGoalPercentage = fieldGoalPercentage;
        this.threePointsMade = threePointsMade;
        this.threePointsAttempted = threePointsAttempted;
        this.threePointsPercentage = threePointsPercentage;
        this.twoPointsMade = twoPointsMade;
        this.twoPointsAttempted = twoPointsAttempted;
        this.twoPointsPercentage = twoPointsPercentage;
        this.totalFieldGoalPercentage = totalFieldGoalPercentage;
        this.freeThrows = freeThrows;
        this.freeThrowsAttempted = freeThrowsAttempted;
        this.freeThrowsPercentage = freeThrowsPercentage;
        this.offensiveRebounds = offensiveRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.totalRebounds = totalRebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.turnOvers = turnOvers;
        this.personalFouls = personalFouls;
        this.points = points;
        this.playerName = playerName;
    }

    public String getPlayerID() {
        return playerID;
    }

    public int getYearPlayed() {
        return yearPlayed;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getPositionPlayed() {
        return positionPlayed;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public double getMinutesPlayed() {
        return minutesPlayed;
    }

    public double getFieldGoals() {
        return fieldGoals;
    }

    public double getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    public double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public double getThreePointsMade() {
        return threePointsMade;
    }

    public double getThreePointsAttempted() {
        return threePointsAttempted;
    }

    public double getThreePointsPercentage() {
        return threePointsPercentage;
    }

    public double getTwoPointsMade() {
        return twoPointsMade;
    }

    public double getTwoPointsAttempted() {
        return twoPointsAttempted;
    }

    public double getTwoPointsPercentage() {
        return twoPointsPercentage;
    }

    public double getTotalFieldGoalPercentage() {
        return totalFieldGoalPercentage;
    }

    public double getFreeThrows() {
        return freeThrows;
    }

    public double getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }

    public double getFreeThrowsPercentage() {
        return freeThrowsPercentage;
    }

    public double getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public double getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public double getTotalRebounds() {
        return totalRebounds;
    }

    public double getAssists() {
        return assists;
    }

    public double getSteals() {
        return steals;
    }

    public double getBlocks() {
        return blocks;
    }

    public double getTurnOvers() {
        return turnOvers;
    }

    public double getPersonalFouls() {
        return personalFouls;
    }

    public double getPoints() {
        return points;
    }

    public int getTotalPointsScored() {
        return totalPointsScored;
    }
    
    public void updateTotalPoints() {
        this.totalPointsScored = (int)(this.getPoints() * this.getGamesPlayed());
    }
    
    public void updateTotalRebounds() {
        this.totalReboundsMade = (int)(this.getTotalRebounds() * this.getGamesPlayed());
    }
    
    public void updateTotalAssists() {
        this.totalAssistsMade = (int)(this.getAssists() * this.getGamesPlayed());
    }
    
    public void updateTotalBlocks() {
        this.totalBlocksMade = (int)(this.getBlocks() * this.getGamesPlayed());
    }
    public void updateTotalSteals() {
        this.totalStealsMade = (int)(this.getSteals() * this.getGamesPlayed());
    }
    
    

    public String getPlayerName() {
        return playerName;
    }
    
    public int getTotalReboundsMade() {
        return totalReboundsMade;
    }

    public int getTotalAssistsMade() {
        return totalAssistsMade;
    }

    public int getTotalBlocksMade() {
        return totalBlocksMade;
    }

    public int getTotalStealsMade() {
        return totalStealsMade;
    }
    
}
