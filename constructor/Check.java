public class Check {
	public Check() {
		System.out.println("Yo");
	}
	public Check(int p) {
		this();
		System.out.println("Yo "+p);
	}
	public static void main(String[] args) {
		Check c = new Check(3);
	}
}