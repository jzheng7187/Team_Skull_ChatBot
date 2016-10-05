package groupFiles;

public class JonathanPsychological implements Topic {

	private boolean inQuestionLoop;
	private String questionResponse;
	//food
		
	public void talk() 
	{
		inQuestionLoop = true;
		while(inQuestionLoop){
			JonathanMain.print("I see you have a psychological problem. Can you specify what"
					+ " kind of pychological problem?"
					+ "Depression?Anxiety?Schizophrenia?");
			questionResponse = JonathanMain.getInput();
			if(JonathanMain.findKeyword(questionResponse, "depression", 0) >= 0){

			}
			else if(JonathanMain.findKeyword(questionResponse, "anxiety", 0) >= 0){

			}
			else if(JonathanMain.findKeyword(questionResponse, "schizophrenia", 0) >= 0){
				
			}
			else{
				JonathanMain.print("I don't understand what kind of psychological problem you have.");
			}
		}
	}

	public boolean isTriggered(String userInput) {
		if(JonathanMain.findKeyword(userInput, "psychological" , 0) >= 0){
			return true;
		}
		return false;
	}

}
