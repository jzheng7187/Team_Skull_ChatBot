package groupFiles;

public class JonathanPsychological implements Topic {

	private boolean inQuestionLoop;
	private String questionResponse;
		//food
	public void talk(){
		JonathanMain.print("Hello, "+ JonathanMain.users +" I see you have a psychological problem. Can you specify what"
				+ " kind of pychological problem?"
				+ " Depression? Anxiety? Schizophrenia?");
		inQuestionLoop = true;
		while(inQuestionLoop){
			questionResponse = JonathanMain.getInput();
			problemIdentifier();
			String[] nothing = {"no","none","nothing","bye","goodbye"};
			for(int i = 0; i < nothing.length; i++){
				if(JonathanMain.findKeyword(questionResponse, nothing[i], 0) >= 0){
					JonathanMain.print("Hopefully we have given you tips on how to solve your problem.");
					inQuestionLoop = false;
					JonathanMain.talkForever();
				}
			}
		}
	}

	private void problemIdentifier() {
		if(JonathanMain.findKeyword(questionResponse, "depression", 0) >= 0 ){
			depressionProblems();
		}
		if(JonathanMain.findKeyword(questionResponse, "anxiety", 0) >= 0){
			anxietyProblems();
		}
		else if(JonathanMain.findKeyword(questionResponse, "schizophrenia", 0) >= 0){
			schizophreniaProblems();
		}	
	}

	private void schizophreniaProblems() {
			JonathanMain.print("There aren't any self treatments for this disorder, but "
					+ "there are medical ones. These medications are Antipsychotic and Anti-Tremor.");
			if(JonathanMain.findKeyword(questionResponse, "stop", 0) >= 0){
				JonathanMain.talkForever();
			}
	}

	private void anxietyProblems() {
			JonathanMain.print("Everyone in the world has experienced anxiety at least one time in their life."
					+ " With this detail being true, people have found many ways to treat this disorder.");
			JonathanMain.print("Some ways to treat this disorder is a healthy diet, meditation, reducing "
					+ "caffine intake, and stress management.");
			if(JonathanMain.findKeyword(questionResponse, "tried", 0) >= 0){
				JonathanMain.print("There is also the option of taking medication or going to therapy sessions."
						+ " Some types of medications that can be taken are Sedatives, Antidepressents, and Anxiolytic");
			}
			else if(JonathanMain.findKeyword(questionResponse, "try", 0) >= 0){
				JonathanMain.print("Hopefully these solutions can help you overcome your anxiety.");
			}
			if(JonathanMain.findKeyword(questionResponse, "stop", 0) >= 0){
				JonathanMain.talkForever();
			}
	}

	private void depressionProblems() {
			JonathanMain.print("Many people have depression in the modern world. Ever "
					+ "since people have started getting out of depression, there "
					+ "are many ways to deal with depression.");
			JonathanMain.print("The main way to solve depression is to talk about it with other people.");
			String[] tries = {"tried","try"};
			for(int i = 0; i < tries.length; i++){
				if(JonathanMain.findKeyword(questionResponse, tries[i], 0) >= 0){
					if(JonathanMain.findKeyword(questionResponse, tries[1], 0) >= 0){
						JonathanMain.print("Okay. Hopefully that will help you get out of your depression.");
					}
					JonathanMain.print("There are many other solutions that can help solve depression. Some "
							+ "other solutions could be to do some exercise, challenge negative thinking and "
							+ "to eat a healthy diet.");
				}
			}
			if(JonathanMain.findKeyword(questionResponse, "stop", 0) >= 0){
				JonathanMain.talkForever();
			}
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"psychological", "psych"};
		for(int i = 0; i < triggers.length; i++){
			if(JonathanMain.findKeyword(userInput, triggers[i] , 0) >= 0){
				return true;
			}
		}
		return false;
	}

}
