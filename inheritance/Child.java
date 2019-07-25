class Parent{
	public void fn() {
		System.out.println("Parent");
	}
}

public class Child extends Parent {
	public void fn() {
		System.out.println("Child");
	}
	public static void main(String[] args) {
		Child c = new Child();
		c.fn(); //child call
		Parent p = new Child();
		p.fn();  //child call
		Object o = new Child();
		//o.fn(); compilation error
		Object q = new Parent();
		//q.fn(); compilation error
	}
}