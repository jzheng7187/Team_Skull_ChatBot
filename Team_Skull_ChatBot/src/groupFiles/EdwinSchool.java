package groupFiles;

public class EdwinSchool implements Topic {
	private boolean inSchoolLoop;
	private String schoolResponse;
	private String name = JonathanMain.users;
	
	private int chatCount;
	private double GPA;
	
	//private static String []topics = {"grades","college","homework","GPA"};
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			chatCount++;
			if (chatCount == 1){
				JonathanMain.print("School-related problems are quite broad,"+name+" . Can you specify what your problem is?");
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
		// TODO Auto-generated method stub
		
	}

	private void gradesProblem() {
		JonathanMain.print("What is your current GPA?");
		
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
		double GPA = Double.parseDouble(userInput); 
		if(GPA >= 5.0 || GPA<= 0.0){
			return false;
		}
		return true;
	}
}
