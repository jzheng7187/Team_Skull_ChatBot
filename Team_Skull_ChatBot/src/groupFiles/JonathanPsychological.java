package groupFiles;

public class JonathanPsychological implements Topic {

	private boolean inQuestionLoop;
	private String questionResponse;
	//food
		
	public void talk() 
	{
		JonathanMain.print("I see you have a psychological problem.");
		inQuestionLoop = true;
		while(inQuestionLoop)
		{
			questionResponse = JonathanMain.getInput();
			int psychPsn = JonathanMain.findKeyword(questionResponse, "pyschological", 0);
			if(psychPsn >= 0)
			{
				String psychProblem = questionResponse.substring(psychPsn + 14);
				JonathanMain.print("I see that you have a " + psychProblem + "problem.");
				if(JonathanMain.findKeyword(questionResponse, "medical", 0)>= 0){
					inQuestionLoop = false;
					JonathanMain.talkForever();
				}else if(JonathanMain.findKeyword(questionResponse, "inter-Relationship", 0) >= 0){
					 inQuestionLoop = false;
					 JonathanMain.talkForever();
				}else if(JonathanMain.findKeyword(questionResponse, "school", 0) >= 0){
					 inQuestionLoop = false;
					 JonathanMain.talkForever();
				}else{
					inQuestionLoop = false;
					JonathanMain.talkForever();
				}
			}
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
