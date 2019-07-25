import java.io.*;
class GameHelper {
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0 ) 
				return null;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine;
	}
}

class SimpleDotCom {
	int[] locationCells;
	int numOfHits = 0;
	public String checkYourself(String guess) {
		int gs = Integer.parseInt(guess);
		String result = "miss";
		for(int i=0;i<locationCells.length;i++) {
			if(locationCells[i]==gs) {
				result = "hit";
				numOfHits++;
				break;
			}
		}
		if(numOfHits==locationCells.length) {
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
	public void setLocationCells(int[] loc) {
		this.locationCells = loc;
	}
}

public class SimpleDotComTestDrive {
	public static void main (String[] args) {
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		SimpleDotCom theDotCom = new SimpleDotCom();
		int randomNum = (int) (Math.random() * 5);
		int[] locations = {randomNum, randomNum+1, randomNum+2};
		theDotCom.setLocationCells(locations);
		boolean isAlive = true;
		while(isAlive == true) {
			String guess = helper.getUserInput("enter a number");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if(result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
		}
	}
}