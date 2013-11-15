
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    private String[][] list;  //col 1 for question, col2 for answer
    //question Number
    //Game

    Game() {

        //construc the two dim array-questions & answers
        this.list = new String[100][100];

        try {

            Scanner in = new Scanner(new File("Q&A.txt"));
            int count = 1;
            String gTemp = ""; //temp string
            while (in.hasNext()) {

                int num = in.nextInt();
                // System.out.println("num is " + num );/////////////////////////

                gTemp = in.next();//getting next line
                //System.out.println( "gTemp is "+ gTemp );////////////////////

                String question = "";

                //get the question
                while (!(gTemp.equalsIgnoreCase("#"))) {
                //    System.out.println("gTemp " + gTemp);
                    //concatenate the sentence
                    question = question + " " + gTemp;
                   // System.out.println("value is " + question);//////////////////////////////////
                    gTemp = in.next();
                }//eo question
                System.out.println("question is " + question);
                this.list[num][count] = question; //save the question

                gTemp = in.next();//getting next line
                String answer = "";
                if (gTemp.equalsIgnoreCase("ans:")) {

                    //get the answer
                    while (!(gTemp.equalsIgnoreCase("#"))) {
                    //    System.out.println("answer  " + answer);
                        //concatenate the sentence
                        answer = answer + " " + gTemp;
                       // System.out.println("answer is " + answer);//////////////////////////////////
                        gTemp = in.next();
                    }//eo answer
                }//eo answer
                this.list[count][num] = answer; //save the answer
            count++;
            }//eol

            in.close();//closing scanner

        
           
            
            
        } catch (FileNotFoundException b) {
            System.out.println("File Not Found ");
        } catch (Exception d) {
            d.getMessage();
        }

    }//eoc

//method for creating a new game
//test method for displaying
    public   void printArray() {
         System.out.println(this.list[0][0]);
            System.out.println(this.list[0][1]);
            System.out.println(this.list[1][0]);
            System.out.println(this.list[1][1]);
            System.out.println(this.list[2][1]);
       /* 
        String out = "";
        for (int row = 0; row < this.list.length; row++) 
        {
            for (int col = 0; col < this.list[row].length; col++) {
                
                System.out.println("Question is "+ row + " answer is " + col);
                        System.out.print(" "+this.list[row][col]);
            }//eo col 
            out += "\n";  }//eo row
        return out;
               
               */
    }
}//eof
