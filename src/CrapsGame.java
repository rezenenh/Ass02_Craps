import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            System.out.println("Welcome to Assignment 2, Let's play some Craps!");
            int firstRoll = rollDice(random);
            System.out.println("You rolled: " + firstRoll);

            if (firstRoll == 7 || firstRoll == 11) {
                System.out.println("You win!");
            } else if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
                System.out.println("Craps! You lose.");
            } else {
                int point = firstRoll;
                System.out.println("Your point is: " + point);
                boolean gameContinues = true;

                while (gameContinues) {
                    int nextRoll = rollDice(random);
                    System.out.println("You rolled: " + nextRoll);

                    if (nextRoll == point) {
                        System.out.println("You win!");
                        gameContinues = false;
                    } else if (nextRoll == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        gameContinues = false;
                    } else {
                        System.out.println("Keep rolling.......");
                    }
                }
            }

            System.out.println("Do you want to play again? (Y/N)");
            playAgain = scanner.next().equalsIgnoreCase("Y");
        } while (playAgain);

        System.out.println("Thank you for playing Craps!");
        scanner.close();
    }

    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Rolled a " + die1 + " and a " + die2 + " for a total of " + sum);
        return sum;
    }
}
