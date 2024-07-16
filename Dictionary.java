package wordle;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Dictionary {

private String finalWord;
private String[] finalWordList;
private List<String> diction= new ArrayList<String>();

public Dictionary() throws IOException {
	
	diction = initializer("/Users/manomaysaggeri/eclipse-workspace/Wordle/src/wordle/Words");
}

private List<String> initializer(String fileName) throws IOException {
	List<String> result;
	try(Stream<String>lines = Files.lines(Path.of(fileName))){
		result= lines.collect(Collectors.toList());
	}
	
	for(int i = 0; i < diction.size(); i++) {
		diction.set(i,diction.get(i).toUpperCase());
	}
	return result;
}

public String getRandomWord(){
	finalWord = diction.get((int)(Math.random()*diction.size()));
	return finalWord;

}

public boolean isValidWord(String word) {
	for(int i = 0; i < diction.size(); i++) {
		if(word.equalsIgnoreCase(diction.get(i))){
			return true;
		}
	}
	return false;
}

}
