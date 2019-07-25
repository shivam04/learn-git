//check if two refrences are same or not
class Foo {
	public static void main(String[] args) {
		Foo a = new Foo();
		Foo b = new Foo();
		Foo c = a;
		System.out.println((a==b));
		System.out.println((a==c));
		System.out.println((b==c));
	}
}