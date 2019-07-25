import javafx.util.Pair;
class Animal {
	private String picture;
	private String food;
	private int hunger;
	private Pair boundaries;  // bounaris HAS-A Pair
	private Pair location;
	public void makeNoise() {
		//code
	}
	public void eat() {
		//code
	}
	public void sleep() {
		//code
	}
	public void roam() {
		//code
	}
}

abstract class Canine extends Animal
{
	public void roam() { 
		System.out.println("hello");
	}
}
public class MakeCanine {
	public void go() {
		Canine c;
		c = new Dog();
		c.roam();
		c = new Canine();
		c.roam();
	}
}