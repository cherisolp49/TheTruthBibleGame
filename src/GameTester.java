/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gameplay;

import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;

public class GameTester {

    public static void main(String[] args) throws IOException 
    {
        Date date = new Date();

        boolean more = true;
        while(more)
        {
            String welcome = JOptionPane.showInputDialog(null, "Welcome to the Truth Bible Game!!\nPlease select "
                + "a game mode:\n1) Bible Truth\n2) Whats That Verse!\n3) Where's That Place!!"
                    + "\n4) Who's That Person!\n5) Bible Topics!\n6) View Results\n7) Exit");
            String players = "Select number of players:\n1) 1 Player\n2) 2 Players\n3) 3 Players\n4) 4 Players";
            int i = Integer.parseInt(welcome);
            switch(i)
            {
                case 1:
                    JOptionPane.showMessageDialog(null, players);
                    BibleTruth new1 = new BibleTruth("Q&A.txt");
                    new1.randomQuestionGenerator();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, players);
                    WhatsThatVerse obj = new WhatsThatVerse("WhatsThatVerse.txt");
                    obj.randomQuestionGenerator();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, players);
                    JOptionPane.showMessageDialog(null, "Currently Under Construction");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, players);
                    JOptionPane.showMessageDialog(null, "Currently Under Construction");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, players);
                    JOptionPane.showMessageDialog(null, "Currently Under Construction");
                    break;
                case 6:
                    openFile();
                case 7:
                    more = false;
                    break;
                default:
                    System.out.println("Not Valid");
                    break;
                
            }        
        }
    }
    /*
     *This method basically opens up a file without having to go through the hassle of opening it manually.
    */
    static void openFile() throws IOException
    {
          Runtime rt=Runtime.getRuntime();
          
          String file = "C:\\Users\\Patrick\\Documents\\NetBeansProjects\\TheTruthBibleGame\\testthisfilething1.txt";
          Process p = rt.exec("notepad " + file);
        
    }
    
    
}
