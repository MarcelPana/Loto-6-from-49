import java.util.*;
import java.util.function.Predicate;

public class Lotto6From49 extends Thread {

    static Scanner sc = new Scanner(System.in);
    static boolean keepPlaying = true;
    static int chosenNumber;

    public static void main(String[] args) {
        System.out.println("Let's play!");
        while (keepPlaying) {
            playARound();
        }
        System.out.println("\nThank you for playing!");
    }

    public static void playARound() {
        boolean validInput;
        String answer;
// Get the user's numbers
        System.out.println("Choose a number please!");
        ArrayList<Integer> userNumbers = new ArrayList<>(6);
        do {

            try {
                chosenNumber = sc.nextInt();
                chosenNumber = (int) (Math.random() * 49) + 1;
                if ((chosenNumber < 1) || (chosenNumber > 49)) {
                    System.out.print("Between 1 " + "and 49, please! Try again: ");
                } else if (!userNumbers.contains(chosenNumber)) {
                    userNumbers.add(chosenNumber);
                    System.out.println("Your chosen numbers are: " + userNumbers);
                }
            } catch (Exception e) {
                sc.next();
                System.out.println("Just numbers please!");
            }
        } while (userNumbers.size() < 6);
        System.out.println();
        System.out.println();
// The lucky 6 random numbers
        System.out.println("And now, let's see the lucky numbers");
        ArrayList<Integer> luckyNumbers = new ArrayList<>(6);
        do {

            int number = (int) (Math.random() * 49) + 1;
            if (!luckyNumbers.contains(number))
                luckyNumbers.add(number);
            try {
                 Thread.sleep(5000);
            } catch (InterruptedException e) {

             }
            System.out.println("The lucky numbers are: " + luckyNumbers);
        } while (luckyNumbers.size() < 6);

// Check the numbers

        System.out.println();
        System.out.println();
        ArrayList<Integer> guessedNumbers = new ArrayList<>();
        for (int s : userNumbers) {
            for (int l : luckyNumbers) {
                if (s == l) {
                    guessedNumbers.add(s);
                }
            }

        }
        System.out.println("Your chosen numbers are: " + userNumbers);
        System.out.println("The lucky numbers are:   " + luckyNumbers);
        System.out.println("The guessed numbers are: " + guessedNumbers);
        System.out.println("You have shot "+ guessedNumbers.size() + " numbers");

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




