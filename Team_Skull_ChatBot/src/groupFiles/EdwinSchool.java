package groupFiles;

public class EdwinSchool implements Topic {
	private boolean inSchoolLoop;
	private String schoolResponse;
	static String name;
	private int chatCount;
	private double GPA;
	private int askedGrades;
	private int askedCollege;


	public void talk() {
		inSchoolLoop = true;
		name = JonathanMain.users;
		while(inSchoolLoop){
			chatCount++;
			if (chatCount == 1){
				JonathanMain.print("School-related problems are quite broad, "+name+". Can you specify what your problem is?");
			}
			else if (chatCount > 1){
				JonathanMain.print("Are there any other school related problems to be adressed " +name+"?");
			}
			String []negative = {"no","not","none","nothing","nah"};//negative responses
			schoolResponse = JonathanMain.getInput();
			for (int i = 0;i < negative.length;i++ ){
				if (JonathanMain.findKeyword(schoolResponse,negative[i],0) >= 0){
					JonathanMain.print("Thanks for talking with the school branch! I will now kick you out of this"
							+ " group chat and send you back to the main office.");
					inSchoolLoop = false;
					JonathanMain.talkForever();	
				}
			}
			identifyProblem(schoolResponse);	
		}
	}

	public boolean isTriggered(String userInput) {
		String []triggers = {"school","academic","GPA","college","colleges"};
		for (int i = 0;i < triggers.length;i++ ){
			if (JonathanMain.findKeyword(userInput,triggers[i],0) >= 0){
				return true;
			}
		}
		return false;
	}

	private void identifyProblem(String userInput) {
		if (JonathanMain.findKeyword(userInput, "grade", 0) >= 0 || 
				JonathanMain.findKeyword(userInput, "gpa", 0) >= 0 ||
				JonathanMain.findKeyword(userInput, "grades", 0) >= 0){
			askedGrades ++;
			if(askedGrades > 1){
				JonathanMain.print("You already asked me about that.");
				return;
			}
			gradesProblem();
		}
		else if (JonathanMain.findKeyword(userInput, "college", 0) >= 0
				|| JonathanMain.findKeyword(userInput, "colleges", 0) >= 0
				|| JonathanMain.findKeyword(userInput, "university", 0) >= 0){
			askedCollege ++;
			if(askedCollege > 1){
				JonathanMain.print("You already asked me about that.");
				return;
			}	
			collegeProblem();
		}
	}

	private void collegeProblem() {
		String []ivyLeague = {"columbia","cornell","stanford","harvard","brown","yale","princeton","upenn"};
		String []otherColleges = {"cuny","suny","mit","uc"};
		String []stressRelief = {" getting a massage", " playing OverWatch "," go play some ball "};
		
		JonathanMain.print("Which college are you aiming for?");
		schoolResponse = JonathanMain.getInput();
		for (int i = 0; i < ivyLeague.length;i++){
			if ((JonathanMain.findKeyword(schoolResponse, ivyLeague[i], 0)>= 0)){
				JonathanMain.print("Wow! Trying to get in an Ivy League must have alot of stress on you. I would suggest"
						+ stressRelief[(int)Math.random()*stressRelief.length] +" to relax.");
				return;
			}
			for (int j = 0; j < otherColleges.length;j++){
				if((JonathanMain.findKeyword(schoolResponse, ivyLeague[j], 0)>= 0)){
					JonathanMain.print(otherColleges[j] +" requires a high GPA. If you are struggling with to keep a high GPA"
							+ " don't hesitate to ask for my advice!");
					return;
				}
			}
			JonathanMain.print("I haven't heard of that college. It must be some amazing super-school!");
		}
	}

	private void gradesProblem() {
		JonathanMain.print("What is your current GPA?");
		schoolResponse = JonathanMain.getInput();
		while(!isaGPAResponse(schoolResponse)){
			JonathanMain.print("That is not a GPA response. Please type a proper GPA, using the CollegeBoard guidelines.");
			schoolResponse = JonathanMain.getInput();
		}
		if (GPA >= 3.4){
			JonathanMain.print("Your GPA is already quite high "+name+". However, you should strive for a higher GPA.");
			//creates a amount of time for studying based on current GPA
			int i = (int)Math.floor(GPA);
			i = (int)(100*(1-(GPA - i)));
			JonathanMain.print("I reccomend you study for at least "+i+" more minutes a day to ensure you understand whats happening in class."); 	
		}
		else{
			findAPForHelp();
		}
	}

	private void findAPForHelp() {
		String []courses = {"algebra","geometry","trigonometry","calculus","ap literature","american literature","english literature",
				"world literature","biology","chemistry","physics","world history","us history","european history","economics"};
		//using the array of courses, code attempts to provide an AP for help
		JonathanMain.print("Hmm. This looks like a serious problem. Which specific class do you need help with?");
		schoolResponse = JonathanMain.getInput();
		for (int i = 0; i < courses.length;i++ ){
			if ((JonathanMain.findKeyword(schoolResponse, courses[i], 0)>= 0)){
				if(i < 4){
					JonathanMain.print("If you are struggling with an Math related course, you can find the Math AP Mr.Smith"
							+ " in room 6W14.");
					return;
				}
				else if (i < 7){
					JonathanMain.print("If you are struggling with an English related course, you can find the English AP Ms.Bonilla"
							+ " in room 5W23.");
					return; 
				}
				else if (i == 8 ){
					JonathanMain.print("If you are struggling with a Biology course, you can always the Biology AP Ms.Lovelett"
							+ " using the phone number (718)804-6400.");
					return;
				}
				else if (i < 11){
					JonathanMain.print("If you are struggling with a Physical Science course, you can contact the Physical Science AP Mr.Evangelist"
							+ " using the phone number (718)804-6561.");
					return;
				}
				else if (i < courses.length){
					JonathanMain.print("If you are struggling with a Social Studies course, you can contact the Social Studies AP Mr.Newman"
							+ "at DNewman@schools.nyc.gov");
					return;
				}
			}
		}
		JonathanMain.print("I am sorry, but it appears this course doesn't exist in my catalog. "
				+ "But whenever you're struggling, you can always go to the NHS tutoring sessions.");
	}
	//is the response a valid GPA
	private boolean isaGPAResponse(String userInput){
		if (isDouble(userInput)){
			GPA = Double.parseDouble(userInput); 
			if(GPA > 4.0 || GPA < 0.0){
				return false;
			}
			return true;
		}
		return false;
	}
	//took this from stack overflow
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
