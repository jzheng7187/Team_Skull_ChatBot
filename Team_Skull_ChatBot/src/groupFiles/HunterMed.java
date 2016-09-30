package groupFiles;

public class HunterMed implements Topic {
	
	private boolean inMedLoop;
	private String medResponse;
	
	public void talk(){
		JonathanMain.print("What is your medical problem?");
		inMedLoop = true;
		while(inMedLoop){
			medResponse = JonathanMain.getInput();
		}
	}
	
	public boolean isTriggered(String userInput){
		if(JonathanMain.findKeyword(userInput, "medical", 0) >= 0){
			return true;
		}
		return false
	}
}
