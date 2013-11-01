
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
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
       
           Scanner in = new Scanner ( new File("Questions.txt"));
          
         //  while(in.hasNext())
         //   {
              
              int num =  in.nextInt();  
              System.out.println("num is " + num );
        //    }//eol
            
           
           in.close();//closing scanner
           
         } catch(FileNotFoundException b){ System.out.println("File Not Found ");}
        catch (Exception d) {
            System.out.println("Something else went wrong" + d.toString());
        }
        
    }//eoc


    }//eof
