/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pkg2048;
import java.util.Scanner;
 
/**
*
* @author Dan
*/
public class Main {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameBoard gb = new GameBoard();
        gb.printBoard();
        String dir;
        
        do
        {
            System.out.println("Enter next move(Left,Right,Up,Down): ");
            dir = input.next();
            dir = dir.toLowerCase();
            
            switch(dir)
            {
                case "left": case "l":
                    gb.left();
                    break;
                case "right": case "r":
                    gb.right();
                    break;
                case "up": case "u":
                    gb.right();
                    break;
                case "down": case "d":
                    gb.down();
                    break;
                case "quit": case "q":
                    break;
                default:
                    System.out.println("Invalid direction");
                    break;
            }
        }while(!"q".equals(dir));
    }
   
}
