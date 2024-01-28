import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attempts = 5;
        int round = 1;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("For each round, you have " + attempts + " attempts to guess the number between " + minRange + " and " + maxRange + ".");
        System.out.println("Let's start with round " + round + "!");

        while (true) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guess;
            int attemptsLeft = attempts;

            System.out.println("I have generated a random number. You have " + attemptsLeft + " attempts to guess it.");

            do {
                System.out.print("Enter the number u are guessing: ");
                guess = scanner.nextInt();
                attemptsLeft--;

                if (guess < generatedNumber) {
                    System.out.println("Too low! You have " + attemptsLeft + " attempts left.");
                } else if (guess > generatedNumber) {
                    System.out.println("Too high! You have " + attemptsLeft + " attempts left.");
                }
            } while (guess != generatedNumber && attemptsLeft > 0);

            if (guess == generatedNumber) {
                System.out.println("Congratulations! You guessed the number correctly!");
            } else {
                System.out.println("You have used all attempts. The number was " + generatedNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }

            round++;
            attempts = 5;
            System.out.println("Starting round " + round + "...");
        }

        System.out.println("Thanks for playing the Number Guessing Game!");
        scanner.close();
    }
}
