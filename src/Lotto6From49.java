import java.util.*;
import java.util.function.Predicate;

public  class Lotto6From49 extends Thread {

    static Scanner sc = new Scanner(System.in);
    static boolean keepPlaying = true;

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
                    System.out.print("Between 1 " + "and 49, please! Try again: ");
                 for (int j = 0; j < chosenNumbers.length; j++) {
                        if( number == chosenNumbers[j]){
                            System.out.println("aoleu ce ai facut");
                        }
                    }
                } else chosenNumbers [i] = number;

                System.out.println("Your 6 chosen numbers are: " + Arrays.toString(chosenNumbers));
            }
        } while (valid < 5);


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
            }while (luckyNumbers.size() < 6 );

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


