import javax.sound.midi.Soundbank;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

public class Lotto6From49 extends Thread {

    static Scanner sc = new Scanner(System.in);
    static boolean keepPlaying = true;
    static int chosenNumber;
    static String path = "C:\\Users\\Acasa\\0 SDA\\7 Proiecte Java Maven Colegi\\Loto6From49\\players";
    static File players = new File(path);
    //static BufferedWriter bufferedWriter = new BufferedWriter(new BufferedWriter(players));

    //Main
    public static void main(String[] args) throws IOException {
        Lotto6From49.creatingFile();
        Lotto6From49.addUser();
        Lotto6From49.readingUsers();
        System.out.println("Let's play!");
        while (keepPlaying) {
            playARound();
        }
        System.out.println("\nThank you for playing!");
    }
// Creating file
    public static void creatingFile() throws IOException {

        if (!players.exists()) {
            System.out.println("The input file does not exist!");
        }else System.out.println("The input file already file exist!");
        if (players.createNewFile())
            System.out.println("File created.");
        else
            System.out.println("File could not be created.");
        System.out.println(players.toString());
    }

  //  Add into file
    public static void addUser(){
        System.out.print("Your name Please" );
    String user = sc.nextLine();
        System.out.println("You have subscribed as: "+ user);

    }

    // Reading File

    public static void readingUsers() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(players));
        String line = in.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = in.readLine();
        }
        try {
            String[] listaUseri = line.split("\t");
            String title = listaUseri[0];

            System.out.println(Arrays.toString(listaUseri));
        }catch (NullPointerException ignored){

        }
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-YYYY; hh:mm;");
        System.out.println("Your chosen numbers are: " + userNumbers);
        System.out.println("The lucky numbers are:   " + luckyNumbers);
        System.out.println("The guessed numbers are: " + guessedNumbers);
        System.out.println("Today " + LocalDateTime.now().format(formatter) + " You have shot " + guessedNumbers.size() + " numbers");

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




