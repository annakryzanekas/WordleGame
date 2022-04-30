import java.util.*;

public class WordleGame {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! Welcome to this 2-Player Wordle Game!");
        System.out.println("To play, player one will enter a word. Player two then has 6 tries to guess the word.");
        System.out.println("Each time player two guesses a word, a 'R', 'Y', or 'G' will appear.");
        System.out.println("'R' means the letter is not in the word.");
        System.out.println("'Y' means the letter is in the word BUT in the wrong place.");
        System.out.println("'G' means the letter is in the word AND in the right place.");
        System.out.println("Please note that when player one enters their word, it will be invisble to player two.");
        System.out.println("Now that we understand the game, it is time to play!");
        System.out.println("Player one, please enter a 5 letter word: ");
        char[] wordInput = System.console().readPassword();
        String word = String.valueOf(wordInput);
        while (word == null || word.length() < 5 || word.length() > 5 ) {
            System.out.println("The word entered is not valid. Please enter a 5 letter word: ");
            wordInput = System.console().readPassword();
            word = String.valueOf(wordInput);
        }

        int count = 0; // counter to ensure player two only gets 6 tries
        Boolean[] correctLetter = new Boolean[5]; // boolean to track if word is correct
        while (count < 6) {
            System.out.println("\n");
            System.out.println("Player two, please enter your guess: ");
            String guessWord = scan.nextLine();
            for (int i = 0; i < word.length(); i++) {
                if (word.contains(Character.toString(guessWord.charAt(i)))) {
                    if (word.charAt(i) == guessWord.charAt(i)) {
                        System.out.print("G ");
                        correctLetter[i] = true;
                    } else {
                        System.out.print("Y ");
                        correctLetter[i] = false;
                    }
                } else {
                    System.out.print("R ");
                    correctLetter[i] = false;
                }

            }

            System.out.print("\n");
            List<Boolean> correctWord = Arrays.asList(correctLetter);

            if (!correctWord.contains(false)) {
                System.out.println("Player 2 guessed the word correctly. Congrats!");
                break; 
            }
            else if (correctWord.contains(false) && count == 5) {
                System.out.println("Sorry Player 2, the correct word was " + word + "!");
            }
            count++;
        }
        scan.close();
    }
}
