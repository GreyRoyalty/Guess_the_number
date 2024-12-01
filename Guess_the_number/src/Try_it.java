import java.util.*;

public class Try_it {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        //Generating a 6-digit random number!
        int target_number = 100000 + random.nextInt(900000);
        String target = String.valueOf(target_number);

        //Welcoming to the game!!
        System.out.println("Welcome to the Guess The NUmber Game!!!");
        System.out.println("You have 6 chances to guess a 6-digit number.");
        System.out.println("Let's Begin!!");

        //Storing the user's progress
        char[] guessed_digits = new char[6];
        for (int i =0; i<6; i++){
            //Initialize as blanks
            guessed_digits[i] = '_';
        }

        int wrong_guesses = 0;
        boolean game_lost = false;

        while (new String(guessed_digits).contains("_") && !game_lost){
            System.out.println("Current progress: ");
            for (char digit : guessed_digits){
                System.out.print(digit + " ");
            }
            System.out.println();

            System.out.println("Enter your guess for a digit: ");
            char guess = sc.next().charAt(0);

            if (Character.isDigit(guess)){
                boolean correctGuess = false;
                for (int i = 0; i < target.length(); i++){
                    if (target.charAt(i) == guess && guessed_digits[i] == '_'){
                        guessed_digits[i] = guess;
                        correctGuess = true;
                    }
                }
                if (correctGuess){
                    System.out.println("Correct guess!");
                }
                else{
                    wrong_guesses++;
                    System.out.println("Wrong Guess! You have " + (6-wrong_guesses) + " wrong attempts left.");
                }
                if (wrong_guesses >= 6){
                    game_lost = true;
                }
            }
            else{
                System.out.println("Invalid input. Please enter a single digit (0-9).");
            }
        }
        if (game_lost){
            System.out.println("You've used all your attempts. You lose!");
            System.out.println("The correct number was: " + target);
        }
        else{
            System.out.println("Congratulations! You have guessed the number " + target);
        }
        sc.close();
    }
}
