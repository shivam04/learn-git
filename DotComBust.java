import java.io.*;
import java.util.ArrayList;
class GameHelper2 {
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int [] grid = new int[gridSize];
	private int comCount = 0;
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0 ) return null;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine.toLowerCase();
	}
	public ArrayList<String> placeDotCom(int comSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		String [] alphacoords = new String [comSize];
		String temp = null;
		int [] coords = new int[comSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;
		comCount++;
		int incr = 1;
		if ((comCount % 2) == 1) { // if odd dot com (place vertically)
			incr = gridLength; // set vertical increment
		}
		while ( !success & attempts++ < 200 ) {
			location = (int) (Math.random() * gridSize);
			int x = 0;
			success = true;
			while (success && x < comSize) {
				if (grid[location] == 0) {
					coords[x++] = location;
					location += incr;
					if (location >= gridSize){ // out of bounds - ‘bottom’
						success = false; // failure
					}
					if (x>0 && (location % gridLength == 0)) {
						success = false;
					}
				} else {
					success = false;
				}
			}
		}
		int x = 0; // turn location into alpha coords
		int row = 0;
		int column = 0;
		while (x < comSize) {
			grid[coords[x]] = 1; // mark master grid pts. as ‘used’
			row = (int) (coords[x] / gridLength); // get row value
			column = coords[x] % gridLength; // get numeric column value
			temp = String.valueOf(alphabet.charAt(column)); // convert to alpha
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			// System.out.print(“ coord “+x+” = “ + alphaCells.get(x-1));
		}
		// System.out.println(“\n”);
		return alphaCells;
	}
}

class DotCom {
	private String name;
	ArrayList<String> locationCells = new ArrayList<String>();
	public void setName(String name) {
		this.name = name;
	}
	public void setLocationCells(ArrayList<String> loc) {
		this.locationCells = loc;
	}
	public String checkYourself(String userGuess){
		String result = "miss";
		int index = locationCells.indexOf(userGuess);
		if(index>=0){
			locationCells.remove(index);
			if(locationCells.isEmpty()){
				result = "kill";
			}else{
				result = "hit";
			}
		}
		return result;
	}
}

public class DotComBust {
	private GameHelper2 helper = new GameHelper2();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	public void setUpGame() {
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		for(DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			for(String nL: newLocation){
				System.out.print(nL + " ");
			}	
			System.out.println("");
			dotComToSet.setLocationCells(newLocation);
		}
	}
	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		for (DotCom dotComToTest : dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if (result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println(" You got out before your options sank.");
		} else {
			System.out.println("Took you long enough. "+ numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}
	public static void main (String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}