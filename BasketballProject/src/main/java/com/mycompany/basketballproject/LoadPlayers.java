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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;




public final class LoadPlayers {
    ArrayList<PlayerInfo> allPlayers = new ArrayList<>();
    ArrayList<YearlyStats> allYearlyStats  = new ArrayList<>();
    ArrayList<TeamInfo> allTeamsInfo = new ArrayList<>();
    ArrayList<TeamByYear> allTeamsByYear = new ArrayList<>();
    TreeMap<Integer, TreeSet<String>> allYearAndTeams = new TreeMap();
    // stores the unique acronym of teams from 1980-present
    Set<String> teamSet = new HashSet<>();
    TreeMap<String, String> allTeamsMap = new TreeMap();
    AllTimeLeaders allTimeLeaders;
    TreeMap<Integer, Integer> gamesPlayedMap = new TreeMap();
    TreeMap<Integer, String> leagueChampsByYearMap = new TreeMap();
    ArrayList<NBAYears> nbaYears = new ArrayList<>();

    public LoadPlayers() throws FileNotFoundException, IOException {
        // loads the team name and their repsective acronym
        loadTeams();
        // loads the number of games player per season in a map
        loadGamesPlayed();
        // loads the team that won the championship per year in a map
        loadNBAChamps();
        // loads all the players and their individual stats per season over 41 years
        loadPlayers();
        // for these next 3 
        setYearlyStats();
        setTeamInfoByYearStats();
        setAllTimeStats();
        setNBAYears();
        // sorts teams high to low based on getWeightedAverage().
        sortNBAYearsData();
        
    }
    
    String statsFile = "dat/NBA.txt";
    public final void loadPlayers() throws FileNotFoundException, IOException {
        // we loop through the NBA.txt file which contains the locations of 
        // the csv files for all 41 years of data and the while looop reads each line
        // and sends it to the csv read method. after the loop, we update the player points
        // using the data from the objects created.
        int startIndexForSubstring = 4; 
        
        BufferedReader br = new BufferedReader(new FileReader(statsFile));  
        String line = null;  
        while ((line = br.readLine()) != null) {
            int fileYear = Integer.parseInt(line.substring(startIndexForSubstring, startIndexForSubstring+4)); 

            csvRead(line, fileYear);

   
        } 

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
                    // all csv files are comma delimited
                    tempArr = line.split(",");
                    // splits the first field with the backslash to get the name and the player ID
                    // from here, we assign all the unique attributes to the stats from the csv
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
                        // a player could have been traded mid season
                        // hence TOT (two other teams). we ignore TOT
                        // stats because we want individual team stats
                        continue;
                    }
                    // for every occurence of a stat, we create a PlayerStats object
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
                    // we are creating an object for each unique player and this
                    // is differentiated with their playerID. we append the playerStat
                    // to that player for all the years he played
                    PlayerInfo tempPlayer;
                    tempPlayer = getPlayerInfo(playerID, playerName);
                    tempPlayer.addPlayerStats(tempPlayerStats);
                    // creates an object for each year and stores the player for each year
                    YearlyStats tempYear;
                    tempYear = getYearInfo(fileYear);
                    tempYear.addPlayerStats(tempPlayerStats);
                    
                    teamSet.add(teamName);
                    // creates an object for the team and collects all the playerStats that played for that team
                    // this is for every player that played for the team across the 41 years
                    TeamInfo tempTeamInfo;
                    tempTeamInfo = getTeamInfo(teamName);
                    tempTeamInfo.addPlayerStats(tempPlayerStats);
                    tempTeamInfo.setYearsPlayed(fileYear);
                    // same as above except for the fact that TeamByYear has playerStats for the players that
                    // played for that team in that specific season
                    TeamByYear tempTeamByYear;
                    tempTeamByYear = getTeamByYearinfo(teamName, fileYear);
                    tempTeamByYear.addPlayerStats(tempPlayerStats);
                    
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
        // some players had blank values in certain categories
        // this method converts the blanks to 0 else it converts the 
        // the string value to a double
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
        // excel sheets don't give total stats for a player but rather stats per game
        // we loop through all the PlayerInfo that we collected
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
            tempPlayer.setTotalGamesPlayed();
            tempPlayer.setPpg();
            tempPlayer.setApg();
            tempPlayer.setRpg();
            tempPlayer.setBpg();
            tempPlayer.setSpg();
        }
        
    }
    
    public PlayerInfo getPlayerInfo(String playerID, String playerName){
         // if a playerID already exists we return the player object
         // else we create a new player object and add it to the allPlayers ArrayList<>()
        
        PlayerInfo tempPlayerInfo;
        
        for(PlayerInfo x : allPlayers){
            if(x.getPlayerID().equals(playerID)){
               
                return x;
            }
        }
        
        tempPlayerInfo = new PlayerInfo(playerID, playerName);
        allPlayers.add(tempPlayerInfo);
        return tempPlayerInfo;
        
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
    
    public TeamInfo getTeamInfo(String teamAcronym){
        TeamInfo tempTeamInfo;
        
        for(TeamInfo x : allTeamsInfo){
            if (x.getTeamAcronym().equals(teamAcronym)){
                return x;
            }
        }
        
        tempTeamInfo = new TeamInfo(teamAcronym);
        tempTeamInfo.setTeamName(allTeamsMap.get(teamAcronym));
        allTeamsInfo.add(tempTeamInfo);
        return tempTeamInfo;
        
    }
    
    public TeamByYear getTeamByYearinfo(String teamAcronym, int fileYear){
        TeamByYear tempTeamByYear;
        for(TeamByYear x : allTeamsByYear){
            if (x.getTeamAcronym().equals(teamAcronym) && x.getTeamYear() == fileYear){
                return x;
            }
            
        }
        tempTeamByYear = new TeamByYear(teamAcronym, allTeamsMap.get(teamAcronym), fileYear, gamesPlayedMap.get(fileYear));
        allTeamsByYear.add(tempTeamByYear);
        return tempTeamByYear;
        
    }
    public void loadTeams() {
        // adds team names and their acronyms. the acronym serves as the key for the team
        // special exceptions: charlotte hornets were renamed twice, NOK is for the hornets but K means katrina
        // since they were displaced after Hurrican Katrina in 2005
        allTeamsMap.put("CHH", "Charlotte Hornets (Old)");
        allTeamsMap.put("VAN", "Vancouver Grizzlies");
        allTeamsMap.put("UTA", "Utah Jazz");
        allTeamsMap.put("SAS", "San Antonio Spurs");
        allTeamsMap.put("CHI", "Chicago Bulls");
        allTeamsMap.put("ORL", "Orlando Magic");
        allTeamsMap.put("WAS", "Washington Wizards");
        allTeamsMap.put("CHO", "Charlotte Hornets");
        allTeamsMap.put("PHI", "Philadelphia 76ers");
        allTeamsMap.put("SDC", "San Diego Clippers");
        allTeamsMap.put("NJN", "New Jersey Nets");
        allTeamsMap.put("PHO", "Phoenix Suns");
        allTeamsMap.put("NYK", "New York Knicks");
        allTeamsMap.put("MIA", "Miami Heat");
        allTeamsMap.put("NOH", "New Orleans Hornets");
        allTeamsMap.put("OKC", "Oklahoma City Thunder");
        allTeamsMap.put("BOS", "Boston Celtics");
        allTeamsMap.put("WSB", "Washington Bullets");
        allTeamsMap.put("GSW", "Golden State Warriors");
        allTeamsMap.put("NOK", "New Orleans Hornets (Katrina)");
        allTeamsMap.put("DEN", "Denver Nuggets");
        allTeamsMap.put("DAL", "Dallas Mavericks");
        allTeamsMap.put("SEA", "Seattle SuperSonics");
        allTeamsMap.put("NOP", "New Orleans Pelicans");
        allTeamsMap.put("HOU", "Houston Rockets");
        allTeamsMap.put("LAC", "Los Angeles Clippers");
        allTeamsMap.put("MIL", "Milwaukee Bucks");
        allTeamsMap.put("POR", "Portland TrailBlazers");
        allTeamsMap.put("DET", "Detroit Pistons");
        allTeamsMap.put("KCK", "Kansas City Kings");
        allTeamsMap.put("MIN", "Minnesota Timberwolves");
        allTeamsMap.put("SAC", "Sacramento Kings");
        allTeamsMap.put("MEM", "Memphis Grizzlies");
        allTeamsMap.put("LAL", "Los Angeles Lakers");
        allTeamsMap.put("TOR", "Toronto Raptors");
        allTeamsMap.put("ATL", "Atlanta Hawks");
        allTeamsMap.put("BRK", "Brooklyn Nets");
        allTeamsMap.put("CLE", "Cleveland Cavaliers");
        allTeamsMap.put("CHA", "Charlotte Bobcats");
        allTeamsMap.put("IND", "Indiana Pacers");
        
    }
    
    public void loadGamesPlayed(){
        // in a typical NBA season, teams play a total of 82 games
        // special exceptions were NBA lockouts in 1998 and 2011
        // and a reduced number of games due to COVID-19 in 2019 and 2020.
        // we attribute the number of games to a season
        // and add the values to the gamesPlayedMap
        gamesPlayedMap.put(1980, 82);
        gamesPlayedMap.put(1981, 82);
        gamesPlayedMap.put(1982, 82);
        gamesPlayedMap.put(1983, 82);
        gamesPlayedMap.put(1984, 82);
        gamesPlayedMap.put(1985, 82);
        gamesPlayedMap.put(1986, 82);
        gamesPlayedMap.put(1987, 82);
        gamesPlayedMap.put(1988, 82);
        gamesPlayedMap.put(1989, 82);
        gamesPlayedMap.put(1990, 82);
        gamesPlayedMap.put(1991, 82);
        gamesPlayedMap.put(1992, 82);
        gamesPlayedMap.put(1993, 82);
        gamesPlayedMap.put(1994, 82);
        gamesPlayedMap.put(1995, 82);
        gamesPlayedMap.put(1996, 82);
        gamesPlayedMap.put(1997, 82);
        gamesPlayedMap.put(1998, 50);
        gamesPlayedMap.put(1999, 82);
        gamesPlayedMap.put(2000, 82);
        gamesPlayedMap.put(2001, 82);
        gamesPlayedMap.put(2002, 82);
        gamesPlayedMap.put(2003, 82);
        gamesPlayedMap.put(2004, 82);
        gamesPlayedMap.put(2005, 82);
        gamesPlayedMap.put(2006, 82);
        gamesPlayedMap.put(2007, 82);
        gamesPlayedMap.put(2008, 82);
        gamesPlayedMap.put(2009, 82);
        gamesPlayedMap.put(2010, 82);
        gamesPlayedMap.put(2011, 66);
        gamesPlayedMap.put(2012, 82);
        gamesPlayedMap.put(2013, 82);
        gamesPlayedMap.put(2014, 82);
        gamesPlayedMap.put(2015, 82);
        gamesPlayedMap.put(2016, 82);
        gamesPlayedMap.put(2017, 82);
        gamesPlayedMap.put(2018, 82);
        gamesPlayedMap.put(2019, 75);
        gamesPlayedMap.put(2020, 72);
        gamesPlayedMap.put(2021, 82);
    }
    
    public void loadNBAChamps(){
        // attributes champion to a year and adds it to the leagueChampsByYearMap
        leagueChampsByYearMap.put(1980, "Boston Celtics");
        leagueChampsByYearMap.put(1981, "Los Angeles Lakers");
        leagueChampsByYearMap.put(1982, "Philadelphia 76ers");
        leagueChampsByYearMap.put(1983, "Boston Celtics");
        leagueChampsByYearMap.put(1984, "Los Angeles Lakers");
        leagueChampsByYearMap.put(1985, "Boston Celtics");
        leagueChampsByYearMap.put(1986, "Los Angeles Lakers");
        leagueChampsByYearMap.put(1987, "Los Angeles Lakers");
        leagueChampsByYearMap.put(1988, "Detroit Pistons");
        leagueChampsByYearMap.put(1989, "Detroit Pistons");
        leagueChampsByYearMap.put(1990, "Chicago Bulls");
        leagueChampsByYearMap.put(1991, "Chicago Bulls");
        leagueChampsByYearMap.put(1992, "Chicago Bulls");
        leagueChampsByYearMap.put(1993, "Houston Rockets");
        leagueChampsByYearMap.put(1994, "Houston Rockets");
        leagueChampsByYearMap.put(1995, "Chicago Bulls");
        leagueChampsByYearMap.put(1996, "Chicago Bulls");
        leagueChampsByYearMap.put(1997, "Chicago Bulls");
        leagueChampsByYearMap.put(1998, "San Antonio Spurs");
        leagueChampsByYearMap.put(1999, "Los Angeles Lakers");
        leagueChampsByYearMap.put(2000, "Los Angeles Lakers");
        leagueChampsByYearMap.put(2001, "Los Angeles Lakers");
        leagueChampsByYearMap.put(2002, "San Antonio Spurs");
        leagueChampsByYearMap.put(2003, "Detroit Pistons");
        leagueChampsByYearMap.put(2004, "San Antonio Spurs");
        leagueChampsByYearMap.put(2005, "Miami Heat");
        leagueChampsByYearMap.put(2006, "San Antonio Spurs");
        leagueChampsByYearMap.put(2007, "Boston Celtics");
        leagueChampsByYearMap.put(2008, "Los Angeles Lakers");
        leagueChampsByYearMap.put(2009, "Los Angeles Lakers");
        leagueChampsByYearMap.put(2010, "Dallas Mavericks");
        leagueChampsByYearMap.put(2011, "Miami Heat");
        leagueChampsByYearMap.put(2012, "Miami Heat");
        leagueChampsByYearMap.put(2013, "San Antonio Spurs");
        leagueChampsByYearMap.put(2014, "Golden State Warriors");
        leagueChampsByYearMap.put(2015, "Cleveland Cavaliers");
        leagueChampsByYearMap.put(2016, "Golden State Warriors");
        leagueChampsByYearMap.put(2017, "Golden State Warriors");
        leagueChampsByYearMap.put(2018, "Toronto Raptors");
        leagueChampsByYearMap.put(2019, "Los Angeles Lakers");
        leagueChampsByYearMap.put(2020, "Milwaukee Bucks");
    }
    
    public void setYearlyStats() {
        // loops through all the playerStats for that year and sets the highest for each category
        for(YearlyStats x: this.allYearlyStats){
            x.setHighestReboundsPlayer();
            x.setHighestPointsPlayer();
            x.setHighestAssistsPlayer();
            x.setHighestBlocksPlayer();
            x.setHighestStealsPlayer();
            x.setHighestPPGPlayer();
            x.setHighestAPGPlayer();
            x.setHighestRPGPlayer();
            x.setHighestBPGPlayer();
            x.setHighestSPGPlayer();
        }
    }
    
    public void setTeamInfoByYearStats() {
        // loops through allTeamsByYear and sets the highest for each category
        for(TeamByYear x: this.allTeamsByYear){
            x.setHighestReboundsPlayer();
            x.setHighestPointsPlayer();
            x.setHighestAssistsPlayer();
            x.setHighestBlocksPlayer();
            x.setHighestStealsPlayer();
            x.setHighestPPGPlayer();
            x.setHighestAPGPlayer();
            x.setHighestRPGPlayer();
            x.setHighestBPGPlayer();
            x.setHighestSPGPlayer();
            x.setAveragePointGaurd();
            x.setAverageShootingGaurd();
            x.setAverageSmallForward();
            x.setAveragePowerForward();
            x.setAverageCenter();
            x.setAverageOfPlayers();
            x.setTotalTeamPoints();
            x.setTotalTeamAssists();
            x.setTotalTeamRebounds();
            x.setTotalTeamBlocks();
            x.setTotalTeamSteals();
            x.setTeamAverage();
            x.setWeightedAverage();
        }
    }
    
    public void setAllTimeStats(){
        // loops through 
        AllTimeLeaders allTime = new AllTimeLeaders();
        allTime.setAllStats(this.allPlayers);
        this.allTimeLeaders = allTime;
        
        for(TeamInfo team : this.allTeamsInfo){
            team.setTeamPlayerInfo();
            
        }
        for(TeamInfo x : this.allTeamsInfo){
            for(TeamPlayerInfo y : x.teamPlayerInfo){
                y.setTotalPoints();
                y.setTotalAssists();
                y.setTotalRebounds();
                y.setTotalBlocks();
                y.setTotalSteals();
                y.setTotalGamesPlayed();
                
                y.setPpg();
                y.setApg();
                y.setRpg();
                y.setBpg();
                y.setSpg();
            }
            
        }
        
        for(TeamInfo z : this.allTeamsInfo){
            z.setHighestPointsPlayer();
            z.setHighestAssistsPlayer();
            z.setHighestReboundsPlayer();
            z.setHighestBlocksPlayer();
            z.setHighestStealsPlayer();
            
            z.setHighestPPGPlayer();
            z.setHighestAPGPlayer();
            z.setHighestBPGPlayer();
            z.setHighestRPGPlayer();
            z.setHighestSPGPlayer();
            
        }
    }
    
    public void setNBAYears(){
        for(TeamByYear x : this.allTeamsByYear){
            NBAYears tempNBAYear;
            tempNBAYear = getNBAYear(x.getTeamYear());
            tempNBAYear.setTeamsPlayed(x);
        }
    }
    
    public void sortNBAYearsData(){
        // according to our calculated average, we sort from highest to lowest who was the "best" team overall for that season
        for(NBAYears x : this.nbaYears){
            x.teamsPlayed.sort(Comparator.comparing(a -> a.getWeightedAverage()));
            Collections.reverse(x.teamsPlayed);
        }
        
        
    }
    
    public NBAYears getNBAYear(int fileYear){
        NBAYears tempNBAYear;
        for(NBAYears x : this.nbaYears){
            if (x.getYearPlayed() == fileYear){
                // if the year is existing return the value
                return x;
            }
            
        }
        // else create a new object for the year
        tempNBAYear = new NBAYears( fileYear);
        nbaYears.add(tempNBAYear);
        return tempNBAYear;
    }
}
