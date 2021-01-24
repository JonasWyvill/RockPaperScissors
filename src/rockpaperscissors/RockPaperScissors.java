package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        // my special rule for RPS: draw = double points next round (double lasts for one round)
        int playerScore = 0;
        int pcScore = 0;
        boolean draw = false;
        int playerPlay = 0;
        String pcPlayText;
        String playerInput = null;
        int loopCount = 0;

        Scanner playerScanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to Rock Paper Scissors!");

        try {
            System.out.println("Please input the number of times you want to play (including draws)");
            loopCount = playerScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid choice made. Game ends 0 - 0.");
        }

        for (int i = 0; i < loopCount; i++) {

            int pcPlay = rand.nextInt(3) + 1;

            try {

                System.out.println("Please input your move (eg. R, S)");
                playerInput = playerScanner.next();
                if (!"R".equals(playerInput)) {
                    System.out.println("Invalid choice made. Game ends.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice made. Game ends.");

            }

            if ("R".equals(playerInput)) {
                playerPlay = 1;
            }
            if ("P".equals(playerInput)) {
                playerPlay = 2;
            }
            if ("S".equals(playerInput)) {
                playerPlay = 3;
            }

            switch (pcPlay) {

                case 1:
                    pcPlayText = "R";
                    break;

                case 2:
                    pcPlayText = "P";
                    break;

                default:
                    pcPlayText = "S";
                    break;
            }

            System.out.println(playerInput + " VS " + pcPlayText);

            // Result of round
            switch (playerPlay - pcPlay) {

                case (0):      // Draw
                    System.out.println("Draw! Points are doubled next round!");
                    draw = true;
                    break;

                case 1:     // Paper > Rock, Scissors > Paper
                case -2:    // Rock > Scissors

                    if (draw == true) {
                        System.out.println("You win! You gain two points!");
                        playerScore = playerScore + 2;
                        draw = false;
                    } else {
                        System.out.println("You win! You gain a point!");
                        playerScore = playerScore + 1;
                    }
                    break;

                default: // PC won

                    if (draw == true) {
                        System.out.println("You lose! The opponent gains two points!");
                        pcScore = pcScore + 2;
                        draw = false;
                    } else {
                        System.out.println("You lose! The opponent gains a point!");
                        pcScore = pcScore + 1;
                    }
                    break;
            }
            System.out.println("Running totals: Your Score = " + playerScore + ", PC Score = " + pcScore);

        }
        System.out.println("The Total Scores are as follows:\nYour Score = " + playerScore + "\nPC Score = " + pcScore);
    }

}
