import java.util.ArrayList;
class Animal {
	private String picture;
	private String food;
	private int hunger;
	private int boundaries;  // bounaris HAS-A Pair
	private int location;
	public void makeNoise() {
		//code
	}
	public void eat() {
		System.out.println("Animal");
	}
	public void sleep() {
		//code
	}
	public void roam() {
		//code
	}
}

class Feline extends Animal {
	public void roam() {
		//code
	}
}

class Canine extends Animal {
	public void roam() {
		//code
	}
}

class Lion extends Feline {
	public void makeNoise() {
		//code
	}
	public void eat() {
		//code
	}
}

class Tiger extends Feline {
	public void makeNoise() {
		//code
	}
	public void eat() {
		//code
	}
}

class Cat extends Feline {    //Cat IS-A Feline
	public void makeNoise() {
		System.out.println("Cat");
	}
	public void eat() {
		System.out.println("Cat");
	}
}

class Hippo extends Feline {
	public void makeNoise() {
		//code
	}
	public void eat() {
		//code
	}
}


class Wolf extends Canine {
	public void makeNoise() {
		//code
	}
	public void eat() {
		//code
	}
}

class Dog extends Canine {
	public void makeNoise() {
		System.out.println("Dog");
	}
	public void eat() {
		System.out.println("Dog");
	}
}

public class AnimalTest {
	public static void main(String[] args) {
		Dog myDog = new Dog();  //myDog and DogObj These two are the same type. The reference variable type is declared as Dog, and the object is created as new Dog().
		// Dog myDog -> refernce
		// new Dog() -> object
		Animal myDogs = new Dog(); //But with polymorphism, the reference and the object can be different.

		Dog d = new Dog();
		Cat c = new Cat();
		if (d.equals(c)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		System.out.println(c.hashCode());
		System.out.println(d.getClass());
		System.out.println(c.toString());
		ArrayList<Object> animals = new ArrayList<Object>();
		animals.add(d);
		animals.add(c);
		//Dog a = animals.get(0); this will not work
		Object a = animals.get(0);
		//a.makeNoise();		
		Object b = animals.get(1);
		//b.makeNoise();
	}
}