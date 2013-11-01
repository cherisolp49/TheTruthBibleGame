public class Players 
{
    private String playerName;      
    private int points;         
    private char currentAnswer;
            
    public Players(String name)
    {
        this.playerName = name;
        this.points = 0;
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
}
