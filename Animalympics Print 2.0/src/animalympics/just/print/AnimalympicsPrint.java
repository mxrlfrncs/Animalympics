
package animalympics.just.print;

import java.util.Random;
import java.util.Scanner;

/**
 * @author maruruii
 */
public class AnimalympicsPrint {
    public static void main(String[] args) {
       
        //DECLARATIONS
        Scanner marl = new Scanner(System.in);
        int birdbet, lionbet, catbet, dogbet, inibal = 1000, prize = 0, betty = 0; //need to initialize to zero
        String winner = null;
        
        //INPUT: IN LOOP (this part only as the declarations above are permanent)
        do {
            System.out.println("================================================");
            System.out.println("Welcome to Animalympics: Print!");
            System.out.println("Balance: " + inibal + " Coins");
            System.out.println("Choose your Animal:");
            
            System.out.println();
            System.out.println("Animal#1 - BIRD");
            System.out.println("Bet(x2)");
            System.out.print("Enter Bet Amount: ");
            birdbet = marl.nextInt();

            System.out.println();
            System.out.println("Animal#2 - LION");
            System.out.println("Bet(x10)");
            System.out.print("Enter Bet Amount: ");
            lionbet = marl.nextInt();

            System.out.println();
            System.out.println("Animal#3 - CAT");
            System.out.println("Bet(x7)");
            System.out.print("Enter Bet Amount: "); //need .print for input to be in the same line
            catbet = marl.nextInt();

            System.out.println();
            System.out.println("Animal#4 - DOG");
            System.out.println("Bet(x4)");
            System.out.print("Enter Bet Amount: ");
            dogbet = marl.nextInt();
            
            //Formulas + Balance Showcase
            int totalbet = birdbet + lionbet + catbet + dogbet;
            System.out.println("\nTotal Bet           : " + totalbet);
            inibal -= totalbet;
            System.out.println("Balance before race : " + inibal);
            
        //Commence Race
        System.out.println("\n================================================");
        System.out.println("\n              THE RACE STARTS IN\n");
        System.out.println("                       3\n");
        System.out.println("                       2\n");
        System.out.println("                       1\n");
        System.out.println("                      GO!\n");
        System.out.println("................................................");
        System.out.println("................................................");
        System.out.println("................................................");
        System.out.println("................................................\n");
        System.out.println("================================================\n");
        
        // Randomizer
        int winnerno = getRandomNumber(1,101); //total of 100 points
        
        //My scheme hehehe :p
        //BIRD 60%
        if (winnerno > 0 && winnerno <= 60) {
            betty = birdbet;
            prize = birdbet *2;
            inibal +=  prize; 
            winner = "BIRD(x2)"; }

        //LION 5%
        else if (winnerno > 60 && winnerno <= 65) {
            betty = lionbet;
            prize = lionbet *10;
            inibal +=  prize; 
            winner = "LION(x10)"; }

        //CAT 15%
        else if (winnerno > 65 && winnerno <= 80) {
            betty = catbet;
            prize = catbet *7;
            inibal += prize; 
            winner = "CAT(x7)"; }

        //DOG 20%
        else if (winnerno > 80 && winnerno <= 100) {
            betty = dogbet;
            prize = dogbet *4;
            inibal += prize;  
            winner = "DOG(x4)"; }
        
        //OUTPUT: Results
        System.out.println("Winner      : " + winner);
        System.out.println("Bet Amount  : " + betty);
        System.out.println("Win Amount  : " + prize);
        System.out.println("New Balance : " + inibal + " Coins");
        System.out.print("\nDo you want to try again? (yes/no): ");
        
        } while (marl.next().equalsIgnoreCase("yes")); //accepts the characters, ignore cases
        System.out.println("Goodbye! Thanks for playing.");
        marl.close(); //closing foe efficency 
        }
    
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min,max).findFirst().getAsInt();
        }
}