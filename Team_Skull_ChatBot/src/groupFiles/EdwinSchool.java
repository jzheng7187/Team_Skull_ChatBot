package groupFiles;

public class EdwinSchool implements Topic {
	
	public void talk() {

		
	}

	public boolean isTriggered(String userInput) {
		String []triggers = {"","","",""};
		for (int i = 0;i > triggers.length;i++ ){
			if (JonathanMain.findKeyword(userInput,triggers[i],0) >= 0){
				return true;
			}
		}
		return false;
	}

}
