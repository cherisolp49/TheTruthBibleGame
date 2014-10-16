package Gameplay;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Players
{
    private String playerName;      
    private int points;         
    private char currentAnswer;
    private int numOfPlayers;
    Date date = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("EMM.dd.yyyy'['hh.mm.ssa']'");
    String t = ft.format(date) + "";
    File f = new File("C:/Users/Patrick/Documents/NetBeansProjects/TheTruthBibleGame/viewResults/" + t + ".txt");        
    public Players(String name)
    {
        System.out.println(name);
        this.playerName = name;
        this.points = 0;
    }
//    public void info(int numPlayers)
//    {
//        for(int i=0; i<numPlayers; i++)
//        {
//            String name = GetData.getWord("Enter Player " + i+1 + " name: ");
//            
//        }
//    }
    /*
     *This method is to get the results of the player to see where it is that they went wrong
     *and to learn from their mistakes. This method should be sent to a text file.
    */
    public void viewResults(String result)
    {
        System.out.println(t + "kjhbkhbjhbjbhj");
        try{
//            if(!f.exists()){
//    			f.createNewFile();
//    		}
            FileWriter fw = new FileWriter(f.getName(),true);
            fw.write(result + System.getProperty("line.separator"));    //line separator creates a new line
            fw.close();
        }catch(Exception ex){
            
        }
        try{
            FileWriter fw = new FileWriter("TestingTextFile.txt");
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println(result);
            pw.close();    
        }catch (IOException e) {
            System.out.println("ERROR!");
        }
    }
    public String getPlayerName()
    {
        return playerName;
    }
    public int getPoints()
    {
        return points;
    }
    public char getCurrentAnswer()
    {
        return currentAnswer;
    }
    public void incrementPoints(String levelOfDiff)
    {
        System.out.println("testing!!!! " + levelOfDiff);
        if(levelOfDiff.equalsIgnoreCase("EASY"))    //easy questions are worth 25 points
        {
            this.points = this.points + 25;
        }
        else if(levelOfDiff.equalsIgnoreCase("MEDIUM"))
        {
            this.points = this.points + 35;
        }
        else if(levelOfDiff.equalsIgnoreCase("HARD"))
        {
            this.points = this.points + 50;
        }
    }

}
