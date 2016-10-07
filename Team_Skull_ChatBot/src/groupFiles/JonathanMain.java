package groupFiles;

import java.util.Scanner;

public class JonathanMain {
	static Scanner input;
	static String users;
	static boolean inLoop;
	static String response;
	static Topic school;
	static Topic relations;
	static Topic medical;
	static Topic psychological;
	
	public static void main(String[] args) {
		createTopic();
		promptName();
		talkForever();
		}
	
	private static void promptName() {
		print("Hello humans, I am a board with a few semiconductors"
				+ " and other such elecrical components. What is "
				+ "your name?"
				);
		users = input.nextLine();
		print("Awesome! I will call you "+users+" until you terminate me.");
	}
	
	public static void talkForever(){
		inLoop = true;
		while(inLoop){
			print("Greetings, " + users +".  What kind of problem do you  have? Is it medical,"
					+ " psychological,school or inter-relationships?");
			response = getInput();
			if(school.isTriggered(response)){
				inLoop = false;
				school.talk();
			}
			else if(medical.isTriggered(response)){
				inLoop = false;
				medical.talk();
			}
			else if(relations.isTriggered(response)){
				inLoop = false;
				relations.talk();
			}
			else if(psychological.isTriggered(response)){
				inLoop = false;
				psychological.talk();
			}
			else{
				print("I'm sorry. I don't understand you.");
			}
		}
	}
	
	public static int findKeyword(String searchString, String key, int startIndex){
		String phrase = searchString.trim();
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		int psn = phrase.indexOf(key);
		while(psn >= 0){
			String after = "";
			String before = "";
			if(psn + key.length() < phrase.length()){
				after = phrase.substring(psn + key.length(), psn + key.length()+1).toLowerCase();
			}
			if (psn> 0){
				before = phrase.substring(psn -1, psn).toLowerCase();
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
				if(noNegations(phrase, psn)){
					return psn;
				}
			}
			psn = phrase.indexOf(key,psn + 1);
		}
		return -1;
	}
	
	private static boolean noNegations(String phrase, int index){
		if(index - 3 >= 0 && phrase.substring(index-3,index).equals("no ")){
			return false;
		}
		if(index - 4 >= 0 && phrase.substring(index-4,index).equals("not ")){
			return false;
		}
		if(index - 6 >= 0 && phrase.substring(index-6,index).equals("never ")){
			return false;
		}
		if(index - 4 >= 0 && phrase.substring(index-4,index).equals("n't ")){
			return false;
		}
		return true;
	}
	
	public static void promptInput() {
		print(users+", try inputting a string!");
		String userInput = input.nextLine();
		print("You typed "+userInput);
		
	}
	
	public static void print(String s){
		String printString = "";
		int cutoff = 35;
		while(s.length() >0){
			String currentLine = "";
			String nextWord = "";
			while(currentLine.length() + nextWord.length() <= cutoff && s.length() > 0){
				currentLine += nextWord; 
				s = s.substring(nextWord.length());
				int endOfWord = s.indexOf(" ");
				if(endOfWord == -1){
					endOfWord = s.length() - 1;
				}
				nextWord = s.substring(0, endOfWord + 1);
			}
			printString += currentLine + "\n";
			
		}
			
		System.out.println(printString);
		
	}
	
	public static void createTopic() {
		input = new Scanner(System.in);
		school = new EdwinSchool();
		relations = new AlexInterRel();
		psychological = new JonathanPsychological();
		medical = new HunterMed();
		
	}
	
	public static String getInput(){
		return input.nextLine();
	}
}

