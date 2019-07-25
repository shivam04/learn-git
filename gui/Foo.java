class MyOuter {
	private int x;
	MyInner inner = new MyInner();
	public void doStuff() {
		inner.go(89);
	}
	class MyInner {
		void go(int y) {
			x = y;
			System.out.println(x);
		}
	}
} 

public class Foo {
	public static void main (String[] args) {
		MyOuter outerObj = new MyOuter();
		MyOuter.MyInner innerObj = outerObj.new MyInner();
		outerObj.doStuff();
		outerObj.inner.go(45);
		innerObj.go(63);
	}
}