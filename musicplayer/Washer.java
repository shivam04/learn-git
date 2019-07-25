class ClothingException extends Exception {

}
class Laundary {
	public void doLaundary() throws ClothingException {
		throw new ClothingException();
	}
}
public class Washer {
	Laundary l = new Laundary();
	public void foo() throws ClothingException {
		l.doLaundary();
	}
	public static void main(String[] args) throws ClothingException {
		Washer w = new Washer();
		w.foo(); //jvm stops
		System.out.println("yo");
	}
}

// if throws ClothingException remove from main then it throws exception in main while compiling