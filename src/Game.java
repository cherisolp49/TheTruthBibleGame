import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class BibleTruth {

    private String[][] list;  //col 1 for question, col2 for answer
    private String option[] = new String[4];
    
   
    BibleTruth() {
        
        //construc the two dim array-questions & answers
        this.list = new String[6][5];

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
    //////////////////////////////////////////////////////////////////////////////starting the multiple choice below            
                gTemp = in.next();//getting next line
                String option2 = "";
             
                while (!(gTemp.equalsIgnoreCase("#"))) //get the answer
                {
                    //concatenate the sentence
                    option2 = option2 + " " + gTemp;
                    gTemp = in.next();
                }//eo option2
                this.list[num][2] = option2; //save the answer
                
                gTemp = in.next();//getting next line
                String option3 = "";
             
                while (!(gTemp.equalsIgnoreCase("#"))) //get the answer
                {
                    //concatenate the sentence
                    option3 = option3 + " " + gTemp;
                    gTemp = in.next();
                }//eo option3
                this.list[num][3] = option3; //save the answer
                
                gTemp = in.next();//getting next line
                String option4 = "";
             
                while (!(gTemp.equalsIgnoreCase("#"))) //get the answer
                {
                    //concatenate the sentence
                    option4 = option4 + " " + gTemp;
                    gTemp = in.next();
                }//eo option4
                this.list[num][4] = option4; //save the answer
    /////////////////////////////////////////////////////////////////////////////ending multiple choice            
            }//eol
            in.close();//closing scanner
          //System.out.println( printArray() ); //used this to test the array
        } catch (FileNotFoundException b) {
            System.out.println("File Not Found ");
        } catch (Exception d) {
            d.getMessage();
        }

    }//eoc

//method for creating a new game
//test method for displaying
    
    //this method is for testing the array 
    public String printArray() {

        String out = "NOW PRINTING THE LIST \n";
        for (int row = 1; row < this.list.length; row++) {
            for (int col = 0; col < this.list[row].length; col++) {
                if (col == 0) {
                    out = out + "Question " + row + " is " + this.list[row][col] + "\n";
                } else {
                    
                    out += "Answer " + " is " + this.list[row][col] + "\n";
                }
            }//eo col 
            out += "\n";
        }//eo row
        System.out.println(out);
        return out;

    }
     public void randomQuestionGenerator()
    {
        Random r = new Random();
        int num = 0;  //question number from the text file;
        int count = 0;  //the current question number; starting from 0 to end
        for(int i=0; i<this.list.length; i++)
        {
            count++;
            num = 1 + r.nextInt(this.list.length - 1); //random question number    just testing uncomment!!!
            System.out.println(count + "\t" + num);
            String choice = getMultipleQuestions(num);
            getQuestions(num, count, choice);
        }        

    }
      public void getQuestions(int num, int count, String choices)
    {
        
        String ques = this.list[num][0] + "\n" + choices; 
        String input = JOptionPane.showInputDialog(null, ques, "Question " + count, 3);
        //pass the input to the method checkAnswer(input);
        if(checkAnswer(input, num))
        {
            JOptionPane.showMessageDialog(null, "You Got It Right!!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sorry, but it looks like you were wrong.");
        }
    }
      public String getMultipleQuestions(int number)
      {
        option = new String[4];
        Random rand = new Random();
        int e;
        int counter = 1;
        
        for (int i = 0; i < option.length; i++) 
        {
            e = rand.nextInt(4);
                
            if(option[e] == null)
            {
                //option[e] = "Question number " + counter;//extract multiple choice options from text and isert here!!!!
                option[e] = this.list[number][counter]; //testing this out if it works delete the one on top....its extracting the MCQs??
                counter++;
            }
            else
            {
                boolean empty = true;
                
                while(empty == true)
                {
                    e = rand.nextInt(4);
                    if(option[e] == null) //is this spot empty?
                    {
                        //option[e] = "Question number " + counter; //extract the multiple choices and put them here!!!
                        option[e] = this.list[number][counter];
                        counter++;
                        empty = false;
                    }

                }
                
            }
               
        }
        String choice = "A) " + option[0] + "\nB) " + option[1] + "\nC) " + option[2] + "\nD) " + option[3] + "\n";
        
        return choice;
      }//end of multiple choice
      
      public boolean checkAnswer(String input, int num)
      {
          boolean correct = false;
          
          switch(input)
          {
              case "A":
                  if(option[0].equals(this.list[num][1])) //comparing the random question in option[0] to the actual answer of the question
                  {
                      correct = true;
                  }
                  break;
             
              case "B":
                  if(option[1].equals(this.list[num][1]))//comparing the random question in option[0] to the actual answer of the question
                  {
                      correct = true;
                  }
                  break;
              
              case "C":
                  if(option[2].equals(this.list[num][1]))//comparing the random question in option[0] to the actual answer of the question
                  {
                      correct = true;
                  }
                  break;
              
              case "D":
                  if(option[3].equals(this.list[num][1]))//comparing the random question in option[0] to the actual answer of the question
                  {
                      correct = true;
                  }
                  break;
               
               default:
                   System.out.println("Invalid Input");
                   break;
          }
          
          return correct;
      }
}//eof
