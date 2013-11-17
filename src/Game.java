
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    private String[][] list;  //col 1 for question, col2 for answer
   
    Game() {

        //construc the two dim array-questions & answers
        this.list = new String[300][2];

        try {

            Scanner in = new Scanner(new File("Q&A.txt"));

            String gTemp = ""; //temp string
            while (in.hasNext()) {
                int num = in.nextInt();
                gTemp = in.next();//getting next line
                String question = "";

                //get the question
                while (!(gTemp.equalsIgnoreCase("#"))) {
                  
                    //concatenate the sentence
                    question = question + " " + gTemp;
                    gTemp = in.next();
                }//eo question
                  this.list[num][0] = question; //save the question

                gTemp = in.next();//getting next line
                String answer = "";
             
                while (!(gTemp.equalsIgnoreCase("#"))) //get the answer
                {
                    //concatenate the sentence
                    answer = answer + " " + gTemp;
                      gTemp = in.next();
                }//eo answer
                this.list[num][1] = answer; //save the answer
            }//eol
            in.close();//closing scanner
          // System.out.println( printArray() ); //used this to test the array
        } catch (FileNotFoundException b) {
            System.out.println("File Not Found ");
        } catch (Exception d) {
            d.getMessage();
        }

    }//eoc

//method for creating a new game
//test method for displaying
    
    //this method is for testing the array 
    private String printArray() {

        String out = "NOW PRINTING THE LIST \n";
        for (int row = 0; row < this.list.length; row++) {
            for (int col = 0; col < this.list[row].length; col++) {

                if (col == 0) {
                    out = out + "Question " + row + " is " + this.list[row][col] + "\n";
                } else {
                    out += "Answer " + " is " + this.list[row][col] + "\n";
                }
            }//eo col 
            out += "\n";
        }//eo row
        return out;

    }
}//eof
