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
				JonathanMain.print("Many people have depression in the modern world. Ever "
						+ "since people have started getting out of depression, there "
						+ "are many ways to deal with depression.");
				depressionProblems();
			}
			else if(JonathanMain.findKeyword(questionResponse, "anxiety", 0) >= 0){

			}
			else if(JonathanMain.findKeyword(questionResponse, "schizophrenia", 0) >= 0){
				JonathanMain.print("I see.");
			}
			else{
				JonathanMain.print("I don't understand what kind of psychological problem you have.");
			}
		}
	}

	private void depressionProblems() {
		JonathanMain.print("The main way to solve depression is to talk about it with other people.");
		String[] tries = {"tried","will try"};
		for(int i = 0; i < tries.length; i++){
			if(JonathanMain.findKeyword(questionResponse, tries[i], 0) >= 0){
				if(JonathanMain.findKeyword(questionResponse, tries[2], 0) >= 0){
					JonathanMain.print("Okay. Hopefully that will help you get out of your depression.");
				}
				JonathanMain.print("There are many other solutions that can help solve depression. Some "
						+ "other solutions could be to do some exercise, challenge negative thinking and "
						+ "eating a healthy diet.");
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
