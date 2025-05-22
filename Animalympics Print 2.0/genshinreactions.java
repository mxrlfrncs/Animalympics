package mine;

import java.util.Scanner;

public class reactiongenshin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String reaction; // Declare reaction variable

        do {
            ///////////////// INPUT ////////////////
            System.out.println("Genshin Elemental Reaction Inducer!");
            System.out.println("Note: small caps only, no spaces.\n");
            System.out.print("Enter 1st Element: ");
            String element1 = in.next();
            System.out.print("Enter 2nd Element: ");
            String element2 = in.next();

            // Combine elements in one order (since order doesn't matter)
            String combo = element1 + element2;
            reaction = "No results:<"; // Default value to avoid uninitialized error

            ///////////////// DETERMINE REACTION ////////////////
            switch (combo) {
                case "cryopyro": case "pyrocryo":
                    reaction = "melt";
                    break;
                case "pyrohydro": case "hydropyro":
                    reaction = "vaporize";
                    break;
                case "pyroelectro": case "electropyro":
                    reaction = "overloaded";
                    break;
                case "cryoelectro": case "electrocryo":
                    reaction = "superconduct";
                    break;
                case "electrohydro": case "hydroelectro":
                    reaction = "electrocharged";
                    break;
                case "cryohydro": case "hydrocryo":
                    reaction = "freeze";
                    break;
                case "geoelectro": case "electrogeo":
                case "pyrogeo": case "geopyro":
                case "geohydro": case "hydrogeo":
                case "geocryo": case "cryogeo":
                    reaction = "crystallize";
                    break;
                case "anemoelectro": case "electroanemo":
                case "pyroanemo": case "anemopyro":
                case "anemohydro": case "hydroanemo":
                case "anemocryo": case "cryoanemo":
                    reaction = "swirl";
                    break;
                case "electrodendro": case "dendroelectro":
                    reaction = "quicken";
                    break;
                case "electroquiken": case "quickenelectro":
                    reaction = "aggravate";
                    break;
                case "pyrodendro": case "dendropyro":
                    reaction = "burning";
                    break;
                // DENDRO CORES: Needs a 3rd element
                case "dendrohydro": case "hydrodendro":
                    System.out.println("Reaction: dendro cores");
                    System.out.print("Enter 3rd Element (pyro/electro): ");
                    String element3 = in.next();

                    if (element3.equals("pyro")) {
                        reaction = "burgeon";
                    } else if (element3.equals("electro")) {
                        reaction = "hyperbloom";
                    } else {
                        reaction = "No valid reaction found."; // Ensure reaction is set
                    }
                    break;
                default:
                    reaction = "No results:<";
                    break;
            }

            // Print the final reaction result
            System.out.println("Reaction: " + reaction);

            // Ask if user wants to repeat
            System.out.print("\nDo you want to try again? (yes/no): ");
        } while (in.next().equalsIgnoreCase("yes"));

        System.out.println("Goodbye! Thanks for playing.");
        in.close();
    }
}
