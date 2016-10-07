package groupFiles;

public class AlexInterRel implements Topic {
	
	private boolean inQuestionLoop ;
	
	static boolean whereLoop; 
	static String response1;
	static String response2;
	static String response3;
	private String problemResponse;
	static boolean whoLoop;
	static boolean appLoop;
	static String who;
	static String whoResponse;
	

	private int problemCount;
	
	
	private static String[] questions = {"What brings you here?", 
			"What's the problem?","What's the matter?"};
	private static String[] responses = {"Please tell me more.",
			"I'm sorry to hear that. ","Don't worry everything will be ok."};
	public AlexInterRel(){
		problemCount = 0;
	}
	//a
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
			
			printResponse();
			
			
		}
	}
	
	        public static void talkProblem(){
   			
	        
	        	System.out.println("Who is causing this distress? Give me their first name.");
	        	who = JonathanMain.input.nextLine();
	        	
	        	
	        	whoLoop = true;
	        	while(whoLoop){
	        		System.out.println("Has "+who+" hurt you physically?" );
	        		response2 = JonathanMain.getInput();
	        		
	        		if(JonathanMain.findKeyword(response2, "yes", 0)>=0){
	        			JonathanMain.print("Don't worry, I will call the police for you.");
	        			whoLoop = false;
	        			JonathanMain.talkForever();
	        		}
	        		if(JonathanMain.findKeyword(response2, "no", 0)>=0){
	        			JonathanMain.print("I will talk to you both to solve your problem.");
	        			whoLoop = false;
	        			emotionalProblem();
	        			
	        		}
	        		else{
	        			JonathanMain.print("It's a yes or a no question.");
	        	//		response3 = JonathanMain.getInput();
	        			
	        			
	        			
	        			}
	        		
	        	}
	       }
	        public static void emotionalProblem(){
	        	
    				JonathanMain.print("What time do you want your appointment to be 12 or 3 in the afternoon?");
    				response3 = JonathanMain.getInput();
    			
    				appLoop = true;
    	        	while(appLoop){
    				if(JonathanMain.findKeyword(response3,"3",0)>=0){
    					JonathanMain.print("See you and at 3 pm.");
    					appLoop =false;
    					JonathanMain.talkForever();
    				}
    				if(JonathanMain.findKeyword(response3,"12",0)>=0){
    					JonathanMain.print("See you and at 12 pm.");
    					appLoop = false;
    					JonathanMain.talkForever();
    				}
    				else
    				{
    					JonathanMain.print("Pick a given time.");
    					
    				}
    				
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
		talkProblem();
	}

public boolean isTriggered(String userInput) {
	

	if(JonathanMain.findKeyword(userInput, "inter-relationships", 0) >=0 ){
		return true;
	}
	
	
	return false;
}

}
