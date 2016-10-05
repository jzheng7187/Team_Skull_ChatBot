package groupFiles;

public class EdwinSchool implements Topic {
	private boolean inSchoolLoop;
	private String schoolResponse;
	static String name;
	
	private int chatCount;
	private double GPA;
	
	//private static String []topics = {"grades","college","homework","GPA"};
	
	public void talk() {
		inSchoolLoop = true;
		name = JonathanMain.users;
		while(inSchoolLoop){
			chatCount++;
			if (chatCount == 1){
				JonathanMain.print("School-related problems are quite broad, "+name+". Can you specify what your problem is?");
				schoolResponse = JonathanMain.getInput();
				identifyProblem(schoolResponse);
			}
			else if(!isTriggered(schoolResponse)){
				inSchoolLoop = false;
				JonathanMain.talkForever();
			}
		}
	}

	private void identifyProblem(String userInput) {
			if (JonathanMain.findKeyword(userInput, "grades", 0) >= 0 || 
					JonathanMain.findKeyword(userInput, "gpa", 0) >= 0 ){
				gradesProblem();
				
			}
			else if (JonathanMain.findKeyword(userInput, "homework", 0) >= 0){
				homeworkProblem();
			}
		}
		

	private void homeworkProblem() {
		
		
	}

	private void gradesProblem() {
		JonathanMain.print("What is your current GPA?");
		schoolResponse = JonathanMain.getInput();
		while(!isaGPAResponse(schoolResponse)){
			JonathanMain.print("That is not a GPA response. Please type a proper GPA, using the CollegeBoard guidelines.");
			schoolResponse = JonathanMain.getInput();
		}
		JonathanMain.print(GPA + " is a very high GPA!");
		
		
	}

	public boolean isTriggered(String userInput) {
		String []triggers = {"school","academic","college","major","GPA"};
		for (int i = 0;i < triggers.length;i++ ){
			if (JonathanMain.findKeyword(userInput,triggers[i],0) >= 0){
				return true;
			}
		}
		return false;
	}
	private boolean isaGPAResponse(String userInput){
		if (isDouble(userInput)){
			GPA = Double.parseDouble(userInput); 
			if(GPA >= 5.0 || GPA<= 0.0){
				return false;
			}
			return true;
		}
		return false;
	}

	private boolean isDouble(String userInput) {
		try{
			Double.parseDouble(userInput);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
}
