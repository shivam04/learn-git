class SuperSuperClass {
	public SuperSuperClass(int q) {
		System.out.println("Super Super " + q);
	}
}
class SuperClass extends SuperSuperClass {
	public SuperClass(int q) {
		super(q);
		System.out.println("Super "+ q);
	}
}
class SubClass extends SuperClass {
	public SubClass(int p) {
		super(p); //1st sentence in method/constructor
		System.out.println("Sub " + p);
	}
	public static void main(String[] args) {
		SubClass s = new SubClass(2); //1st supersuperclass constructor then superclass then subclass constructor
	}
}