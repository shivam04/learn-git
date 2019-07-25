class Animal {
	public String name;
}


class Dog {
	public Animal animal = new Animal();
	public Dog(String name) {
		//this.animal = new Animal();
		this.animal.name = name;
	}
}

public class AnimalTest {
	public static void main(String[] args) {
		Dog d = new Dog("Kenny");
		System.out.println(d.animal.name);
		Dog dd = new Dog("Penny");
		System.out.println(dd.animal.name);
	}
}