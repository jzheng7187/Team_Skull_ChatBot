package groupFiles;

public class HunterMed implements Topic {

	private boolean inMedLoop;
	private boolean ageLoop;
	private boolean heightLoop;
	private boolean weightLoop;
	private String medResponse;
	private static int age;
	private static double height;
	private static double weight;

	public void talk(){
		inMedLoop = true;
		ageLoop = true;
		heightLoop = true;
		weightLoop = true;
		while(inMedLoop){
			JonathanMain.print("Greetings " +JonathanMain.users+", what is your medical problem?");
			medResponse = JonathanMain.getInput();
			int medPsn = JonathanMain.findKeyword(medResponse, "problem", 0);
			String [] stop = {"stop","no","not","never","nobody","none","nothing","nowhere"};
			for (int i = 0; i < stop.length; i++)
				if(JonathanMain.findKeyword(medResponse,stop[i], 0) >= 0){
					inMedLoop = false;
					JonathanMain.talkForever();
				}
			if(medPsn >= 0){
				String medicalProblem = medResponse.substring(medPsn+11);
				JonathanMain.print("I will help you with your "+medicalProblem);
				askAge();
			}
			else{
				JonathanMain.print("I don't understand you");
			}
		}
	}

	private void askAge() {
		while(ageLoop){
			JonathanMain.print("What is your age in years?");
			medResponse = JonathanMain.getInput();
			if(JonathanMain.findKeyword(medResponse, "stop", 0) >= 0){
				ageLoop = false;
				JonathanMain.talkForever();
			}
			int agePsn = JonathanMain.findKeyword(medResponse, "am", 0);
			int yearsPsn = JonathanMain.findKeyword(medResponse, "years", 0);
			if(agePsn >= 0 && yearsPsn >=0){
				age = Integer.parseInt(medResponse.substring(agePsn+3,yearsPsn-1));
				JonathanMain.print(ageComment());
				askHeight();
			}
			else JonathanMain.print("I don't understand you.");
		}
	}

	private void askHeight() {
		while(heightLoop){
			JonathanMain.print("What is your height in meters?");
			medResponse = JonathanMain.getInput();
			if(JonathanMain.findKeyword(medResponse, "stop", 0) >= 0){
				heightLoop = false;
				JonathanMain.talkForever();
			}
			int heightPsn = JonathanMain.findKeyword(medResponse, "am", 0);
			int metersPsn = JonathanMain.findKeyword(medResponse, "meters", 0);
			if(heightPsn >= 0 && metersPsn >=0){
				height = Double.parseDouble(medResponse.substring(heightPsn+3,metersPsn-1));
				JonathanMain.print(heightComment());
				askWeight();
			}
			else JonathanMain.print("I don't understand you.");
		}
	}

	private void askWeight() {
		while(weightLoop){
			JonathanMain.print("What is your weight in kilograms?");
			medResponse = JonathanMain.getInput();
			if(JonathanMain.findKeyword(medResponse, "stop", 0) >= 0){
				weightLoop = false;
				JonathanMain.talkForever();
			}
			int weighPsn = JonathanMain.findKeyword(medResponse, "weigh", 0);
			int kilosPsn = JonathanMain.findKeyword(medResponse, "kilograms", 0);
			if(weighPsn >= 0 && kilosPsn >=0){
				weight = Double.parseDouble(medResponse.substring(weighPsn+6,kilosPsn-1));
				JonathanMain.print(weightComment());
				advice();
			}
			else JonathanMain.print("I don't understand you.");
		}
	}

	private String ageComment(){
		if (age < 30){
			return ("Wow, you are young.");
		}
		else return ("Wow, you are old.");
	}

	private String heightComment() {
		if (height < 1.8){
			return ("Wow, you are short.");
		}
		else return ("Wow, you are tall.");
	}

	private String weightComment() {
		if (weight < 64){
			return ("Wow, you are light.");
		}
		else return ("Wow, you are heavy.");
	}

	private void advice() {
		JonathanMain.print(JonathanMain.users+", I think you need "+getAmount()+"mg of "+getMedicine()+" for your problem.");
		JonathanMain.talkForever();
	}

	private String getMedicine() {
		String [] medicine = {"fat","carbohydrate","protien","cholesterol","sodium"};
		return medicine[(int)(Math.random() * medicine.length)];
	}

	private static double getAmount(){
		return (age+(height*2)+(weight/2));
	}

	public boolean isTriggered(String userInput){
		String []triggers = {"medical","medicine","treatment"};
		for (int i = 0; i < triggers.length; i++)
			if(JonathanMain.findKeyword(userInput, triggers[i], 0) >= 0){
				return true;
			}
		return false;
	}
}
