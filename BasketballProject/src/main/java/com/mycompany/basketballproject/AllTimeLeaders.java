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
public class AllTimeLeaders {
    private PlayerInfo highestPointsPlayer;
    private PlayerInfo highestAssistsPlayer;
    private PlayerInfo highestReboundsPlayer;
    private PlayerInfo highestBlocksPlayer;
    private PlayerInfo highestStealsPlayer;
    
    private PlayerInfo highestPPGPlayer;
    private PlayerInfo highestAPGPlayer;
    private PlayerInfo highestRPGPlayer;
    private PlayerInfo highestBPGPlayer;
    private PlayerInfo highestSPGPlayer;
    
    public AllTimeLeaders(){
        
    }

    public PlayerInfo getHighestPointsPlayer() {
        return highestPointsPlayer;
    }

    public void setHighestPointsPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         int totalPoints = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getTotalPoints() > totalPoints){
                 tempPlayer = x;
                 totalPoints = x.getTotalPoints();
             }
             
         }
         this.highestPointsPlayer = tempPlayer;
         
        
    }

    public PlayerInfo getHighestAssistsPlayer() {
        return highestAssistsPlayer;
    }

    public void setHighestAssistsPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         int totalAssists = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getTotalAssists() > totalAssists){
                 tempPlayer = x;
                 totalAssists = x.getTotalAssists();
             }
             
         }
         this.highestAssistsPlayer = tempPlayer;
    }

    public PlayerInfo getHighestReboundsPlayer() {
        return highestReboundsPlayer;
    }

    public void setHighestReboundsPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         int totalRebounds = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getTotalRebounds() > totalRebounds){
                 tempPlayer = x;
                 totalRebounds = x.getTotalRebounds();
             }
             
         }
         this.highestReboundsPlayer = tempPlayer;
    }

    public PlayerInfo getHighestBlocksPlayer() {
        return highestBlocksPlayer;
    }

    public void setHighestBlocksPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         int totalBlocks = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getTotalBlocks() > totalBlocks){
                 tempPlayer = x;
                 totalBlocks = x.getTotalBlocks();
             }
             
         }
         this.highestBlocksPlayer = tempPlayer;
    }

    public PlayerInfo getHighestStealsPlayer() {
        return highestStealsPlayer;
    }

    public void setHighestStealsPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         int totalSteals = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getTotalSteals() > totalSteals){
                 tempPlayer = x;
                 totalSteals = x.getTotalSteals();
             }
             
         }
         this.highestStealsPlayer = tempPlayer;
    }

    public PlayerInfo getHighestPPGPlayer() {
        return highestPPGPlayer;
    }

    public void setHighestPPGPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         double ppg = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getPpg() > ppg){
                 tempPlayer = x;
                 ppg = x.getPpg();
             }
             
         }
         this.highestPPGPlayer = tempPlayer;
    }

    public PlayerInfo getHighestAPGPlayer() {
        return highestAPGPlayer;
    }

    public void setHighestAPGPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         double apg = 0;
         for(PlayerInfo x : allPlayers){
             
             if(x.getApg() > apg){
                 tempPlayer = x;
                 apg = x.getApg();
             }
             
         }
         this.highestAPGPlayer = tempPlayer;
    }

    public PlayerInfo getHighestRPGPlayer() {
        return highestRPGPlayer;
    }

    public void setHighestRPGPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         double rpg = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getRpg() > rpg){
                 tempPlayer = x;
                 rpg = x.getRpg();
             }
             
         }
         this.highestRPGPlayer = tempPlayer;
    }

    public PlayerInfo getHighestBPGPlayer() {
        return highestBPGPlayer;
    }

    public void setHighestBPGPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         double bpg = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getBpg() > bpg){
                 tempPlayer = x;
                 bpg = x.getBpg();
             }
             
         }
         this.highestBPGPlayer = tempPlayer;
    }

    public PlayerInfo getHighestSPGPlayer() {
        return highestSPGPlayer;
    }

    public void setHighestSPGPlayer(ArrayList<PlayerInfo> allPlayers) {
        PlayerInfo tempPlayer = null;
         double spg = 0;
         for(PlayerInfo x : allPlayers){
             if(x.getSpg() > spg){
                 tempPlayer = x;
                 spg = x.getSpg();
             }
             
         }
         this.highestSPGPlayer = tempPlayer;
    }
    
    
    
    public void setAllStats(ArrayList<PlayerInfo> allPlayers){
        setHighestPointsPlayer(allPlayers);
        setHighestAssistsPlayer(allPlayers);
        setHighestReboundsPlayer(allPlayers);
        setHighestBlocksPlayer(allPlayers);
        setHighestStealsPlayer(allPlayers);
        
        setHighestPPGPlayer(allPlayers);
        setHighestAPGPlayer(allPlayers);
        setHighestRPGPlayer(allPlayers);
        setHighestBPGPlayer(allPlayers);
        setHighestSPGPlayer(allPlayers);
    }
    
    
    
    
    
}
