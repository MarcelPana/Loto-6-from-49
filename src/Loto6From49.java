import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Loto6From49 extends Thread {

    static Scanner sc = new Scanner(System.in);
    static boolean keepPlaying = true;
    static Thread delay = new Thread();

    public static void main(String[] args) {
        System.out.println("Let's play!");
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

        int[] chosenNumbers = new int[6];
        int valid = 0;
        do {

            for (int i = 0; i < chosenNumbers.length; i++) {
                System.out.print("Choose yours 6 numbers, please!");
                valid = i;
                int number = sc.nextInt();
                // System.out.println("You have chosen number " + number);
                if ((number < 1) || (number > 49)) {
                    i--;
                    System.out.print("Between 1 " + "and 10, please! Try again: ");
                } else chosenNumbers[i] = number;

                System.out.println("Your 6 chosen numbers are: " + Arrays.toString(chosenNumbers));
            }
        } while (valid < 5);


// The lucky 6 random numbers
        System.out.println("And now, let's see the lucky numbers");
        int[] winningNumbers = new int[6];

        for (int i = 0; i < winningNumbers.length; i++) {
            int index = i + 1;
            int number = (int) (Math.random() * 49) + 1;
            winningNumbers[i] = number;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            System.out.println("The " + index + " lucky number is: " + winningNumbers[i]);
        }
        System.out.println("The lucky numbers are: " + Arrays.toString(winningNumbers));
// Check the guess

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


