package groupFiles;

public class EdwinSchool implements Topic {
	private boolean inSchoolLoop;
	private String schoolResponse;
	
	private int chatCount;
	private double GPA;
	
	private String []answers = {"I understand that your problems are school related. But I first need some information "
			+ "regarding your academics "+ JonathanMain.users +". What is your current GPA? "};
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			schoolResponse = JonathanMain.getInput();
			if(JonathanMain.findKeyword(schoolResponse,"GPA",0) >= 0){
				
			}
			else if(!isTriggered(schoolResponse)){
				inSchoolLoop = false;
				JonathanMain.talkForever();
			}
		}
	}

	public boolean isTriggered(String userInput) {
		String []triggers = {"school","academic","college","major","GPA"};
		for (int i = 0;i > triggers.length;i++ ){
			if (JonathanMain.findKeyword(userInput,triggers[i],0) >= 0){
				return true;
			}
		}
		return false;
	}
	private boolean isaGPAResponse(String userInput){
		double GPA = Double.parseDouble(userInput); 
		if(GPA >= 5.0 || GPA<= 0.0){
			return false;
		}
		return true;
	}
}
