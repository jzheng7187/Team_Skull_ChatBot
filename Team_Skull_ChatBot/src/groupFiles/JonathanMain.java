package groupFiles;

import java.util.Scanner;

public class JonathanMain {
	static Scanner input;
	static String users;
	static boolean inLoop;
	static String response;
	//declare group's classes
//	static Topic school;
//	static Topic like;
	
	public static void main(String[] args) {
		createTopic();
		promptName();
		talkForever();
		// space, periods and numbers come before the letter "a"
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
			print("Greetings, " + users +". How are you?");
			response = getInput();
			if(findKeyword(response, "good", 0) >= 0){
				print("I'm so happy you're good.");
			}
			else{
				print("I'm sorry. I don't understand you.");
			}
		}
	}
	
	public static int findKeyword(String searchString, String key, int startIndex){
		//delete white space
		String phrase = searchString.trim(); // trim() is in the api
		//set all letters to lowercase
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		
//		System.out.println("The phrase is " + phrase+ ".");
//		System.out.println("The key is "+ key + ".");
		
		//find position of key
		int psn = phrase.indexOf(key);
//		System.out.println("The position found is " + psn + ".");
		//keep looking for word
		//until you find the right context
		while(psn >= 0){
			String after = "";
			String before = "";
			if(psn + key.length() < phrase.length()){
				after = phrase.substring(psn + key.length(), psn + key.length()+1).toLowerCase();
//				System.out.println("The character after " + key + " is " + after);
			}
			//if the phrase does not begin with this word
			if (psn> 0){
				before = phrase.substring(psn -1, psn).toLowerCase();
//				System.out.println("The charcter before " + key + " is" + before);
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
//				System.out.println(key + " was found at " + psn);
				if(noNegations(phrase, psn)){
					return psn;
				}
			}
			//in case the keyword was not found yet
			//check the rest of the string
			psn = phrase.indexOf(key,psn + 1);
//			System.out.println( key + " was not found. " + "Checking " + psn);
		}
		return -1;
	}
	
	//"helper method": a method that contributes functionality to another method.
	//Helper methods are very common when you need to do the same thing repeatedly 
	//They also help make methods more readable. 
	//This method is private because it is only used by the method it is helping
	
	private static boolean noNegations(String phrase, int index){
		//check for word "NO" (3 characters)
		//check to see if there is space for the word
		//"NO" to be in front of the index
		if(index - 3 >= 0 && phrase.substring(index-3,index).equals("no ")){
			return false;
		}
		//check for "not "
		if(index - 4 >= 0 && phrase.substring(index-4,index).equals("not ")){
			return false;
		}
		//check for "never "
		if(index - 6 >= 0 && phrase.substring(index-6,index).equals("never ")){
			return false;
		}
		//check for "n't "
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
		//initialize group classes
		
	}
	
	public static String getInput(){
		return input.nextLine();
	}
}

