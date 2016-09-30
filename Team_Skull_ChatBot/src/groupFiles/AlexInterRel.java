package groupFiles;



public class AlexInterRel implements Topic {
	private boolean inQuestionLoop ;
	private String questionResponse;
	private static String[] questions = {"What brings you here?", 
			"How are you doing?"};

public boolean isTriggered(String userInput) {
	String[] triggers = {"","",""};
	if(JonathanMain.findKeyword(userInput, "", 0) >=0 ){
		return true;
	}
	if(JonathanMain.findKeyword(userInput, "", 0) >=0 ){
		return true;
	}
	return false;
}

public void talk() {
	
}
}

//ge