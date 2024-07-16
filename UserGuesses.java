package wordle;
import java.util.*;

public class UserGuesses {


	private ArrayList<String> wordsGuessed;
	private ArrayList<String> results;
	

	public UserGuesses() {
		
		wordsGuessed=new ArrayList<String>();
		results = new ArrayList<String>();
	}
	
	public void addWord(String word, String result) {
		wordsGuessed.add(word);
		results.add(result);
		
	
	}
	public void print() {
		for(int i = 0; i < wordsGuessed.size(); i++) {
			print(wordsGuessed.get(i),results.get(i));
		}
	}
	public void print(String guess, String result){
		for(int i =0; i < 5; i++) {
			if(result.charAt(i) == '0') {
				System.out.print("\u001B[30m"+ " " + guess.charAt(i));
			}
			else if(result.charAt(i) == '1') {
				System.out.print("\u001B[33m"+ " " + guess.charAt(i));

			}
			else {
				System.out.print("\u001B[32m" + " " + guess.charAt(i));

			}
		}
		System.out.println("\u001B[30m");
		System.out.println();
	}
}
