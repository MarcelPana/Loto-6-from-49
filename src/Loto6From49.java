import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Loto6From49 {

    static Scanner sc = new Scanner(System.in);
    static boolean keepPlaying = true;


    public static void main(String[] args) {
        System.out.println("Let's play a guessing game!");
        while (keepPlaying) {
            playARound();
        }
        System.out.println("\nThank you for playing!");
    }

    public static void playARound() {
        boolean validInput;
        int numbers = 0;
        int guess;
        String answer;
        int counter = 0;


// Get the user's numbers
        int count = 0;
        System.out.println();
        System.out.print("Choose your's 6 numbers, please!");
        do {
            guess = sc.nextInt();
            validInput = true;
            if ((guess < 1) || (guess > 49)) {
                System.out.print("Between 1 " + "and 10, please! Try again: ");
            } else
                count++;
        } while (count <= 6);

// Pick 6 random numbers
        while (counter <= 6) {
            numbers = (int) (Math.random() * 49) + 1;
            counter++;
            if (counter < 7) {
                System.out.print(numbers + ";");
            }
        }
// Check the guess

        if (guess == numbers)
            System.out.println("You're right!");
        else
            System.out.println("You're wrong! " + "The number was " + numbers);
// Play again?
        do {
            System.out.print("\nPlay again? (Y or N)");
            answer = sc.next();
            validInput = true;
            if (answer.equalsIgnoreCase("Y")) ;
            else if (answer.equalsIgnoreCase("N"))
                keepPlaying = false;
            else
                validInput = false;
        } while (!validInput);
        System.out.println("\nThank you for playing!");
    }
}


