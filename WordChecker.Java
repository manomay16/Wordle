package wordle;

public class WordChecker {

	public String checkWord(String guess, String answer) {
		// 0 = not there; 1 = there, wrong place; 2 = there right place
		StringBuffer result = new StringBuffer();
		String modifiedanswer = "";
		for (int i = 0; i < 5; i++) {
			if (guess.charAt(i) == (answer.charAt(i))) {
				result.append("2");
				modifiedanswer += "%";
			} else {
				result.append("_");
				modifiedanswer += answer.charAt(i);
			}
		}
		for (int i = 0; i < 5; i++) {
			if (modifiedanswer.charAt(i) != '%') {
				if (!modifiedanswer.contains(guess.charAt(i) + "")) {
					result.setCharAt(i, '0');
					continue;
				}
				if (modifiedanswer.contains(guess.charAt(i) + "")) {
					result.setCharAt(i, '1');
				}
			}
		}
		return (result.toString());

	}
}
