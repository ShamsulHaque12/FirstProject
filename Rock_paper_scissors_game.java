
package rock_paper_scissours_game;

import java.util.Random;
import java.util.Scanner;

public class Rock_paper_scissors_game {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of rounds you want to play: ");
        int endGame = scanner.nextInt();

        String[] choices = {"Rock", "Paper", "Scissors"};
        boolean playAgain = true;

        int roundCounter = 0;
        int ties = 0;
        int userWin = 0;
        int computerWin = 0;

        while (playAgain && roundCounter < endGame) {
            int roundsLeft = endGame - roundCounter;
            System.out.println("Choose: "
                    + "\n1 for Rock,"
                    + "\n2 for Paper, "
                    + "\n3 for Scissors");
            
            int userChoice = scanner.nextInt() - 1;

            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid choice. \nPlease choose a valid number.");
                continue;
            }

            int computerChoice = random.nextInt(3);

            System.out.println("You chose: " + choices[userChoice]);
            System.out.println("Computer chose: " + choices[computerChoice]);

            if (userChoice == computerChoice) {
                System.out.println("It's a tie!");
                ties++;
            } else if ((userChoice == 0 && computerChoice == 2) ||
                       (userChoice == 1 && computerChoice == 0) ||
                       (userChoice == 2 && computerChoice == 1)) {
                System.out.println("You win!");
                userWin++;
            } else {
                System.out.println("You lose!");
                computerWin++;
            }

            roundCounter++;
            System.out.println("Rounds left: " + (roundsLeft - 1));

            if (roundCounter < endGame) {
                System.out.println("Do you want to play again? (yes/no)");
                String response = scanner.next();
                playAgain = response.equalsIgnoreCase("yes");
            }
        }

        System.out.println("\t.............Final Result:................"
                + "\n##########################################################");
        System.out.println("User Win Points: " + userWin);
        System.out.println("Computer Win Points: " + computerWin);
        System.out.println("Ties: " + ties);

        if (userWin > computerWin) {
            System.out.println("You are the overall winner!");
        } else if (computerWin > userWin) {
            System.out.println("The computer is the overall winner!");
        } else {
            System.out.println("The game is a tie overall!");
        }

        scanner.close();
        System.out.println("Thanks for playing!");

    }
    
}
