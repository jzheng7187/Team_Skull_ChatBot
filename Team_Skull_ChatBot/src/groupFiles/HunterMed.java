package groupFiles;

public class HunterMed implements Topic {

	private boolean inMedLoop;
	private boolean ageLoop;
	private boolean heightLoop;
	private boolean weightLoop;
	private String medResponse;
	private int age;
	private double height;
	private double weight;
	private static double amount;
	private static String medicine;
	private int count;

	public void talk(){
		inMedLoop = true;
		ageLoop = true;
		heightLoop = true;
		weightLoop = true;
		while(inMedLoop){
			JonathanMain.print("Greetings " +JonathanMain.users+", what is your medical problem?");
			medResponse = JonathanMain.getInput();
			int medPsn = JonathanMain.findKeyword(medResponse, "problem", 0);
			if(JonathanMain.findKeyword(medResponse, "stop", 0) >= 0){
				inMedLoop = false;
				JonathanMain.talkForever();
			}
			if(medPsn >= 0){
				String medicalProblem = medResponse.substring(medPsn+11);
				JonathanMain.print("I will help you with your "+medicalProblem);
			}
			else{
				JonathanMain.print("I will help you with your "+medResponse);
			}
			while(ageLoop){
				JonathanMain.print("What is your age in years?");
				medResponse = JonathanMain.getInput();
				if(JonathanMain.findKeyword(medResponse, "stop", 0) >= 0){
					inMedLoop = false;
					JonathanMain.talkForever();
				}
				count = 0;
				String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
				for (int i = 0; i < medResponse.length(); i++)
					for(int n = 0; n < 10; n++)
						if(JonathanMain.findKeyword(medResponse, numbers[n], 0) >= 0){
							ageLoop = false;
							count++;
						}
				if(ageLoop == false){
					age = Integer.parseInt(medResponse.substring(0,count));
				}
				if(ageLoop == true){
					JonathanMain.print("I don't understand you.");
				}
			}
			JonathanMain.print("What is your height in meters?");
			medResponse = JonathanMain.getInput();
			if(medResponse.indexOf("stop") >= 0){
				inMedLoop = false;
				JonathanMain.talkForever();
			}
			height = Double.parseDouble(medResponse);
			JonathanMain.print("What is your weight in kilograms?");
			medResponse = JonathanMain.getInput();
			if(medResponse.indexOf("stop") >= 0){
				inMedLoop = false;
				JonathanMain.talkForever();
			}
			weight = Double.parseDouble(medResponse);
			JonathanMain.print(JonathanMain.users+", I think you need "+amount+"mg of "+medicine+" for your problem.");
		}
	}

	private static double getAmount(){
		return amount;
	}

	private static String getMedicine(){
		return medicine;
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
