package wordle;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean win = false;
		Dictionary dictionary = null;
		try {
			dictionary = new Dictionary();
		} catch (IOException e) {
			System.out.println("Dictionary file not found!");
			return;
		}
		WordChecker wordchecker = new WordChecker();
		UserGuesses userguesses = new UserGuesses();

		String answer = dictionary.getRandomWord().toUpperCase();
		Scanner scan = new Scanner(System.in);
		//System.out.println(answer);
		int i = 0;
		while (i < 5) {
			System.out.print("Enter your five letter guess: ");
			String guess = scan.nextLine();
			guess = guess.toUpperCase();
			if (!dictionary.isValidWord(guess)) {
				System.out.println("invalid word, please enter a real word");
				continue;
			}
			String result = wordchecker.checkWord(guess, answer);
			userguesses.addWord(guess, result);
			userguesses.print();
			i++;
			if (result.equals("22222")) {
				System.out.println("You won in " + i + " guesses! Congratulations");
				win = true;
				break;
			}
		}
		if (!win) {
			System.out.println("You did not win. Try again");
			System.out.println("The correct answer was: "+answer);
		}
	}

	public void addWord() {
		Scanner guesses = new Scanner(System.in);
		System.out.print("Enter your five letter guess: ");

	}

}

