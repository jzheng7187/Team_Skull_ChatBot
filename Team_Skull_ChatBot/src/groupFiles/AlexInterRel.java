package groupFiles;

import java.util.Scanner;

import chatbot.JonathanMain;
import chatbot.Main;

public class AlexInterRel implements Topic {
	private boolean inQuestionLoop ;
	static Scanner input;
	static boolean whereLoop; 
	static String response1;
	static String response2;
	private String problemResponse;
	static boolean whoLoop;
	static String who;
	

	private int problemCount;
	
	
	private static String[] questions = {"What brings you here?", 
			"What's the problem?","What's the matter?"};
	private static String[] responses = {"Please tell me more.",
			"I'm sorry to hear that. ","Don't worry everything will be ok."};
	public AlexInterRel(){
		problemCount = 0;
	}
	
	public void talk()
	{
		inQuestionLoop = true;
		while(inQuestionLoop){
			JonathanMain.print(JonathanMain.users+ "  "+"who do you not get along with?" );
			response1 = JonathanMain.getInput();
			if(response1.indexOf("stop")>=0){
				inQuestionLoop =false;
				JonathanMain.talkForever();
			}
			
			talkProblem();
			//if(printResponse.indexOf("stop")>=0){
		//		inSchoolLoop =false;
		//	problemResponse = JonathanMain.getInput();
		//	if(!isTriggered(problemResponse)){
			//	inQuestionLoop = false;
				
			
		}
	}
	
	        public static void talkProblem(){
   			
	        
	        	System.out.println("Who is causing this distress?");
	        	who = input.nextLine();
	        	
	        	whoLoop = true;
	        	while(whoLoop){
	        		System.out.println("Has "+who+" hurt you physically?" );
	        		response2 = JonathanMain.getInput();
	        		if(JonathanMain.findKeyword(response2, "yes", 0)>=0){
	        			JonathanMain.print("Don't worry, I will call the police for you.");
	        		}
	        		else{
	        			JonathanMain.print("What has your "+who+" said that hurt you?");
	        		}
	        			
	        		
	        	}
	        	
			
			
			
			String who = input.nextLine();
		    
			System.out.println("Has "+who+" hurt you physically?" );
			response1 = input.nextLine();
			if(JonathanMain.findKeyword(response1,"yes",0) >= 0){
				System.out.println("Where did "+who+" hurt you?");
			}
			else{
				System.out.println("What did "+who+" say that hurt you?");
				
			}
			
			
	}
	
private void printResponse() {
		int responseChoice = 0;
		if(problemCount > 3 ){
			responseChoice = (int)(Math.random()*questions.length);
			JonathanMain.print(questions[responseChoice]);
		}
		else{
			responseChoice = (int)(Math.random()*responses.length);
			JonathanMain.print(responses[responseChoice]);
		}
	}

public boolean isTriggered(String userInput) {
	
	if(JonathanMain.findKeyword(userInput, "family", 0) >=0 ){
		return true;
	}
	if(JonathanMain.findKeyword(userInput, "friends", 0) >=0 ){
		return true;
	}
	if(JonathanMain.findKeyword(userInput, "relationship", 0) >=0 ){
		return true;
	}
	if(JonathanMain.findKeyword(userInput, "inter-relationships", 0) >=0 ){
		return true;
	}
	
	
	return false;
}

}
