import java.util.Random;
import java.util.Scanner;

public class WordGuesser {

    private final static String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic",
            "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private final static String WRONG_GUESS_PATTERN = "#############";

    private final String wordToGuess;
    private StringBuilder playerGuess;
    private final String playerName;


    public WordGuesser(final String playerName) {
        this.playerName = playerName;
        this.wordToGuess = pickRandomWord();
        this.playerGuess =  initPlayerGuess(this.wordToGuess);
        launchGame();
    }

    private void launchGame() {

        Scanner scanner = new Scanner(System.in);

        boolean flag = false;
        while (!flag) {
            System.out.println("Please enter a word (only lower-case letters): ");
            flag = checkForGuessedLetters(scanner.nextLine());
        }
        scanner.close();

    }

    private boolean checkForGuessedLetters(String playerGuess) {

        if (playerGuess.equals(this.wordToGuess)) {
            System.out.println(getName() + ", you've guessed the word - " + this.wordToGuess + ". Congratulations!");
            return true;
        }

        for (int i = 0; i < this.wordToGuess.length(); i++) {
            if (playerGuess.charAt(i) == this.wordToGuess.charAt(i)) {
                this.playerGuess.setCharAt(i, playerGuess.charAt(i));
            }
        }

        System.out.println("Your guess is wrong, here is a hint: " + this.playerGuess + WRONG_GUESS_PATTERN);
        return false;
    }

    private String pickRandomWord() {
        int randomIndex = new Random().nextInt(0, WORDS.length);
        System.out.println("Hi " + this.playerName + ", a random word has been picked for you to guess!");
        return WORDS[randomIndex];
    }

    private StringBuilder initPlayerGuess(String playerGuess) {
        this.playerGuess = new StringBuilder().repeat('#', this.wordToGuess.length());;
        return this.playerGuess;
    }

    private String getName() {
        return this.playerName;
    }

    public static void main(String[] args) {
        WordGuesser wordGuesser = new WordGuesser("Nikita");
    }

}
