package groupFiles;

public class JonathanPsychological implements Topic {

	private boolean inQuestionLoop;
	private String qestionRespone;
	//food
		
	public void talk() {
		JonathanMain.print("What is your problem?");
		inQuestionLoop = true;
		while(inQuestionLoop){
			questionResponse = JonathanMain.getInput();
			int psychPsn = JonathanMain.findKeyword(questionResponse, "pyschological", 0);
			if(psychPsn >= 0){
				String psychProblem = questionResponse.substring(psychPsn + 14);
				JonathanMain.print("I see that you have a " + psychProblem + "problem.")'
				if(JonathanMain.findKeyword(questionResponse, "medical", 0)){
					inQuestionLoop = false;
					JonathanMain.HunterMed.talk();
				}else if(JonathanMain.findKeyword(questionResponse, "inter-Relationship", 0){
					 inQuestionLoop = false;
					 JonathanMain.AlexInterRel.talk();
				}else if(JonathanMain.findKeyword(questionResponse, "school", 0){
					 inQuestionLoop = false;
					 JonathanMain.EdwinSchool.talk();
				else{
					inQuestionLoop = false;
					JonathanMain.talkForever();
			else{
				JonathanMain.print("I don't understand what your problem is");
		}
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
