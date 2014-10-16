package Gameplay;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Date;

public class BibleTruth {

    private String[][] list;  //col 1 for question, col2 for answer
    private String option[] = new String[4];
    private int oldQues[]; //being created to ensure no duplicate questions
    private boolean duplicated;
    Players player;

    
   /*
    @param passing the name of the file
    */
    BibleTruth(String file) {
        
        //construct the two dim array-questions & answers
        this.list = new String[10][7];
        this.oldQues = new int[list.length];

        try {
            Scanner in = new Scanner(new File(file));

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
///////////////////////ending multiple choice-----Starting Reference/////////////////////////////////
                 gTemp = in.next();//getting next line
                String reference = "";
             
                while (!(gTemp.equalsIgnoreCase("#"))) //get the answer
                {
                    //concatenate the sentence
                    reference = reference + " " + gTemp;
                    gTemp = in.next();
                }//eo reference
                this.list[num][5] = reference; //save the answer
////////////////////////Level of Difficulty//////////////////////////////////////////////
                gTemp = in.next();//getting next line
                String levelOfDiff = "";
             
                while (!(gTemp.equalsIgnoreCase("#"))) //get the answer
                {
                    //concatenate the sentence
                    levelOfDiff = levelOfDiff + " " + gTemp;
                    gTemp = in.next();
                }//eo option4
                this.list[num][6] = levelOfDiff; //save the levelofDiff
                
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

    }//end of printArray
     public void randomQuestionGenerator()
    {
        Random r = new Random();
        int num = 0;  //random question number from the text file;
        int count = 1;  //the current question number; starting from 1 to end
        String name = GetData.getWord("Enter your name");
        player = new Players(name);

        for(int i=0; i<this.list.length-1; i++)
        {
            num = 1 + r.nextInt(this.list.length - 1); //gets a random question number
            if(i==0)//filling in the first array index with the first question
            {
                oldQues[0] = num;
            }
            else
            {
                /*
                @param if the number isnt a duplicate, then the while statement is false and its automatically exited, if it is 
                a duplicate then it enters into the while statement until it isnt
                */
                while(this.isNumADuplicateQues(num))//making sure that we are not going to have duplicate questions
             //   while(!duplicated)
                {
                    num = 1 + r.nextInt(this.list.length - 1); //gets a random question number
                    this.isNumADuplicateQues(num);

                }
                oldQues[i] = num;
                
            }
            String choice = getMultipleQuestions(num);
            getQuestions(num, count, choice);
            count++;

        }//end of for loop
        JOptionPane.showMessageDialog(null, "Congratulations!! You have successfully learned some things today!\nCome back and play again another time! God bless! ");

    }//end of randomQuestionGenerator
      public void getQuestions(int num, int count, String choices)
    {
        String result = "";
        String gTemp = "";
        String ques = this.list[num][0] + "\n" + choices;
        JOptionPane.showMessageDialog(null, this.list[num][0] + "\n(Click ok to see the choices)");
        //the code above asks the question w/o multiple choice
        String input = JOptionPane.showInputDialog(null, ques, "Question " + count, 3);
        //pass the input to the method checkAnswer(input);
        if(checkAnswer(input, num))//if answer is correct
        {
            JOptionPane.showMessageDialog(null, "You Got It Right!!!\nReference: " + this.list[num][5]);
            //System.out.println(this.list[num][6] + "testing!!!!!!!!!!!fcdwfdsafdsa");
            //player.incrementPoints(this.list[num][6]); //determines how much points player gets for correct response
            gTemp = count + " " + this.list[num][0] + " " + "The answer is: " + this.list[num][1]
                    + " [You got this question correct!!!!]";
            result = gTemp + " " + result;
            player.viewResults(result);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sorry, but it looks like you were wrong.\nReference: " + this.list[num][5]);
            gTemp = count + " " + this.list[num][0] + " " + "The answer is: " + this.list[num][1]
                    + " [You got this question incorrect]";
            result = gTemp + " " + result;
            player.viewResults(result);
        }
    }//end of getQuestions
      /*
      @param number is the number of a random question that will be extracted
      from the text file
      */
      public String getMultipleQuestions(int number)
      {
        option = new String[4];
        Random rand = new Random();
        int e;  //random number
        int counter = 1;    //counter is the number representing the multiple choice options
        //there are 4 options and the counter represents each one
        
        for (int i = 0; i < option.length; i++) 
        {
            e = rand.nextInt(4);    //random number from 0-3
                
            if(option[e] == null)
            {
                option[e] = this.list[number][counter]; //its extracting the MCOptions
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
      }//end of getMultipleQuestions
      
      public boolean checkAnswer(String input, int num)
      {
          boolean correct = false;
          
         if(input.equalsIgnoreCase("A"))
         {
             if(option[0].equals(this.list[num][1])) //comparing the random question in option[0] to the actual answer of the question
             {
                  correct = true;
             }
         }
         else if(input.equalsIgnoreCase("B"))
         {
             if(option[1].equals(this.list[num][1]))//comparing the random question in option[1] to the actual answer of the question
             {
                 correct = true;
             }
         }
         else if(input.equalsIgnoreCase("C"))
         {
             
             if(option[2].equals(this.list[num][1]))//comparing the random question in option[2] to the actual answer of the question
             {
                  correct = true;
             }
         }
         else if(input.equalsIgnoreCase("D"))
         {
              if(option[3].equals(this.list[num][1]))//comparing the random question in option[3] to the actual answer of the question
              {
                  correct = true;
              }
         }
         else
         {
              JOptionPane.showMessageDialog(null, "Invalid Input");//////////////Delete!!!!
         }
          return correct;
      }//end of checkAnswer
      /*
      @param testing for duplicated questions. dupNumCheck is the number of
      the question being checked to see if it hasnt already occured
      */
      public boolean isNumADuplicateQues(int dupNumCheck)
      {
          duplicated = false;
          int k = 0;
          //oldQues[k] can't equal 0 unless it hasnt yet been assigned a number, dupNumCheck will 
          //always be > 0 since the question numbers start from 1 to the end
          while(oldQues[k] != 0) 
          {
              if(oldQues[k] == dupNumCheck)
              {
                  duplicated = true;
                  break;
              }
              else
              {
                  k++;
              }
          }
          return duplicated;
      }
      public void openFile() throws IOException
      {
          Runtime rt=Runtime.getRuntime();
          
          String file = "C:\\Users\\Patrick\\Documents\\NetBeansProjects\\TheTruthBibleGame\\testthisfilething1.txt";
          Process p = rt.exec("notepad " + file);
      }
}//eof
