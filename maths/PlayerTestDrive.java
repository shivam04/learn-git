class Player {
	public static final double PI = 3.141592653589793; //static final vars are constant
	static int playerCount = 0;
	private String name;
	public Player(String n) {
		name = n;
		playerCount++;
	}
}
public class PlayerTestDrive {
	public static void main(String[] args) {
		System.out.println(Player.playerCount);
		Player one = new Player("Tiger Woods");
		System.out.println(Player.playerCount);
	}
}
//static variables are initialized before any object of the class can be created
//static variables are initialized when the class is loaded