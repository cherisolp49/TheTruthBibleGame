
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
//import java.io.File;

public class Game {

    //array
    //question Number
    //Game
    
    Game()
    {
        try {
       
           Scanner in = new Scanner ( new FileReader("The truth Bible Game Questions and Answers.txt"));
          
            while(in.hasNext())
            {
               //is this a question?
               int num =  in.nextInt();  
               System.out.println(num);
            }
            
        } catch (IOException a) {
            System.out.println("Wrong Input file");
        } 
        catch (Exception b) {
            System.out.println("Something else went wrong");
        }
    }


    }//eof
