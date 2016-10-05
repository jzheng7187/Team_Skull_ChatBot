package groupFiles;

public class HunterMed implements Topic {
	
	private boolean inMedLoop;
	private String medResponse;
	private int age;
	private double height;
	private double weight;
	
	public void talk(){
		inMedLoop = true;
		while(inMedLoop){
			JonathanMain.print("Greetings " +JonathanMain.users+", what is your age?");
			medResponse = JonathanMain.getInput();
			if(medResponse.indexOf("stop") >= 0){
				inMedLoop = false;
				JonathanMain.talkForever();
			}
			JonathanMain.print("What is your height?");
			medResponse = JonathanMain.getInput();
			if(medResponse.indexOf("stop") >= 0){
				inMedLoop = false;
				JonathanMain.talkForever();
			}
			JonathanMain.print("What is your weight?");
			medResponse = JonathanMain.getInput();
			if(medResponse.indexOf("stop") >= 0){
				inMedLoop = false;
				JonathanMain.talkForever();
			}
		}
	}
	
	public boolean isTriggered(String userInput){
		String []triggers = {"medical"};
		for (int i = 0; i < triggers.length; i++)
			if(JonathanMain.findKeyword(userInput, triggers[i], 0) >= 0){
				return true;
		}
		return false;
	}
}
