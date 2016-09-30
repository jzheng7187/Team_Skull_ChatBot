package groupFiles;

public class HunterMed implements Topic {
	
	private boolean inMedLoop;
	private String medResponse;
	
	public void talk(){
		JonathanMain.print("What is your medical problem?");
		inMedLoop = true;
		while(inMedLoop){
			JonathanMain.print("Greetings " +JonathanMain.users+", what is your age?");
		}
	}
	
	public boolean isTriggered(String userInput){
		if(JonathanMain.findKeyword(userInput, "medical", 0) >= 0){
			return true;
		}
		return false;
	}
}
