import java.util.Random;
import java.util.Scanner;

public class WordGuesser {

    private final static String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic",
            "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private final static String WRONG_GUESS_PATTERN = "#############";

    private String wordToGuess;
    private final String playerName;


    public WordGuesser(final String playerName) {
        this.playerName = playerName;
        launchGame();
    }

    private void launchGame() {
        pickRandomWord();
        guess();
    }

    private void guess() {

        Scanner scanner = new Scanner(System.in);

        char[] guessedCharacters = new char[wordToGuess.length()];

        boolean flag = false;
        while (!flag) {
            System.out.println("Please enter your guess: ");
            String playerGuess = scanner.next();
            flag = checkForGuessedLetters(playerGuess, guessedCharacters);
        }

        scanner.close();

    }

    private boolean checkForGuessedLetters(String playerGuess, char[] guessedCharacters) {

        if(this.wordToGuess.equals(playerGuess)) {
            return true;
        }

        for (int i = 0; i < this.wordToGuess.length(); i++) {
            if (playerGuess.charAt(i) == this.wordToGuess.charAt(i)) {
                guessedCharacters[i] = playerGuess.charAt(i);
            }
            else {
                guessedCharacters[i] = '#';
            }
        }
        return false;
    }

    private void pickRandomWord() {
        int randomIndex = new Random().nextInt(0, WORDS.length - 1);
        this.wordToGuess = WORDS[randomIndex];
        System.out.println("A random word has been picked, it's time to guess!");
    }

    private String getName() {
        return this.playerName;
    }

    public static void main(String[] args) {
        WordGuesser wordGuesser = new WordGuesser("Nikita");
    }

}
