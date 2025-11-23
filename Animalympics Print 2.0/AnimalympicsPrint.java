package animalympics.just.print;

import java.util.Random;
import java.util.Scanner;

/**
 * @author maruruii
 */

//Thee ultimate class
class Animalss {
    String name;
    int multiplier;
    int betAmount;

    // Constructor
    public Animalss (String name, int multiplier) {
        this.name = name;
        this.multiplier = multiplier;
        this.betAmount = 0; 
    }

    // Animal betting 
    public void displayyy (int number) {
        System.out.println("Animal#" + number + " - " + name);
        System.out.println("Bet(x" + multiplier + ")");
        System.out.print("Enter Bet Amount: ");
    }
    
    // Check valid bet amount
    public static int getValidBetAmount(Scanner scanner, int inibal) {
        int bet;
        while (true) { 
            try {
                bet = scanner.nextInt();
                
                if (bet < 0) {
                    System.out.println("Bet must be a positive number.");
                    System.out.print("Enter Bet Amount: ");
                } else if (bet > inibal) { 
                    System.out.println("\nBet exceeds balance, try again.");
                    System.out.println("Add funds through GCASH: 09691781539");
                    System.out.print("Enter Bet Amount: "); 
                } else {
                    break; // Exit loop 
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please input digits only.");
                System.out.print("Enter Bet Amount: ");
                scanner.next(); 
            }
        }  
        return bet; // Return valid bet amount
    }
    
    // Balance is zero or less?
    public static void checkBalanceStatus(int balance) {
        if (balance <= 0) {
            System.out.println("Empty balance.");
            System.out.println("Add funds through GCASH: 09691781539");
        }
    } 
}

public class AnimalympicsPrint {
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner marl = new Scanner(System.in);
        int inibal = 100; 

        // INPUT LOOP
        do {
            System.out.println("================================================");
            System.out.println("Welcome to Animalympics: Print!");
            System.out.println("Balance: " + inibal + " Coins");
            System.out.println("Choose your Animals:\n");

            // Objects
            Animalss animals[] = {
                new Animalss("BIRD", 2),
                new Animalss("LION", 10),
                new Animalss("CAT", 7),
                new Animalss("DOG", 4)
            };

            // Get bets
            for (int i = 0; i < animals.length; i++) {
                animals[i].displayyy(i + 1); 
                animals[i].betAmount = animals[i].getValidBetAmount(marl, inibal); 
    
                inibal -= animals[i].betAmount; 

                // Updated balance
                System.out.println("\nCurrent Balance: " + inibal + " Coins");
                
                // Check balance (from the Animalss class)
                if (inibal == 0) {
                    Animalss.checkBalanceStatus(inibal);
                    System.out.println("Race stated due to empty balance");
                    break; // Exit early 
                }
            }

            // Calculations
            int totalbet = 0;
            for (Animalss animal : animals) { 
                totalbet += animal.betAmount; 
            }

            // Show bets
            System.out.println("Total Bet       : " + totalbet);
            
            // Commence Race
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
            int winnerno = getRandomNumber(1, 101);

            // Determine the winner through array
            Animalss winanimal = null; 

            // My scheme hehehe :p
            if (winnerno > 0 && winnerno <= 60) {
                winanimal = animals[0]; // BIRD (60%)
            } else if (winnerno > 60 && winnerno <= 65) {
                winanimal = animals[1]; // LION (5%)
            } else if (winnerno > 65 && winnerno <= 80) {
                winanimal = animals[2]; // CAT (15%)
            } else if (winnerno > 80 && winnerno <= 100) {
                winanimal = animals[3]; // DOG (20%)
            }
            
            int prize = 0, betty = 0; // Need to initialize to zero ehh
            String winner = null;
            
            // Calculate prize and update balance
            if (winanimal != null) {
                betty = winanimal.betAmount; 
                prize = betty * winanimal.multiplier; 
                inibal += prize; 
                winner = winanimal.name + "(x" + winanimal.multiplier + ")";
            }

            // OUTPUT: Results
            System.out.println("Winner      : " + winner);
            System.out.println("Bet Amount  : " + betty);
            System.out.println("Win Amount  : " + prize);
            System.out.println("New Balance : " + inibal + " Coins");

        }  while (askToTryAgain(marl));
        System.out.println("Goodbye! Thanks for playing.");
        marl.close(); // Closing for efficiency
    }

    // Like a randomizer machine
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    // Appropriate input to try again
    public static boolean askToTryAgain (Scanner scanner) {
        String input;
        while (true) {
            System.out.print("\nDo you want to try again? (y/n): ");
            input = scanner.next();

            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please type 'y' or 'n'.");
            }
        }
    }
}
