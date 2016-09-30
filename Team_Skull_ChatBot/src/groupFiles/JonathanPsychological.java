package groupFiles;

public class JonathanPsychological implements Topic {

	private boolean inQuestionLoop;
	private String qestionRespone;
	//food
		
	public void talk() {
		
	}

	public boolean isTriggered(String userInput) {
		if(JonathanMain.findKeyword(userInput, "depression" , 0) >= 0){
			return true;
		}
		if(JonathanMain.findKeyword(userInput, "anxiety", 0) >= 0){
			return true;
		}
		return false;
	}

}
