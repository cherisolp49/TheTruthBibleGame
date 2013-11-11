
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Game 
{
    ArrayList<String>questions;

    /*
     * This method will be extracting the questions and answers from the text 
     * file and placing them in a 2-D array. 
     */
    Game()
    {
        questions = new ArrayList<>();
        
            try {
       
           Scanner in = new Scanner ( new File("Questions.txt"));
          
          
              
              int num =  in.nextInt();  
              System.out.println("num is " + num );
        //    }//eol
            
           
           in.close();//closing scanner
           
         } catch(FileNotFoundException b){ System.out.println("File Not Found ");}
        catch (Exception d) {
            System.out.println("Something else went wrong" + d.toString());
        }
        
    }//eoc
    public void addQuestinos(String questions)
    {
        this.questions.add(questions);
    }
    
    /*
     * This method will produce a random number which will be the index of a 
     * question in the list.
     */
    public void randomQuestionGenerator()
    {
        Random r = new Random();
        int num=0;
        for(int i=0; i<this.questions.size(); i++)
        {
            num = r.nextInt(questions.size()-1);
            getQuestions(num);
        }
        
    }
    /*
     * This method will produce a random question. The number being passed
     * through the parameter is a random number from the randomNumberGenerator
     * which is the index of one of the questions from the list
     */
    public String getQuestions(int num)
    {
        String ques = "";
        for(int i=0; i<this.questions.size()-1; i++)
        {
            ques = questions.get(num);
        }
        return ques;
    }
    
    public static void main(String[] args) {
        Game ya = new Game();
        ya.randomQuestionGenerator();
    }
    

    }//eof
