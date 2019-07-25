import java.util.*;
public class TestGenerics3 {
	public static void main(String[] args) {
		new TestGenerics1().go();
	}
	public void go() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Dog());
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		dogs.add(new Dog());
		takeAnimals(animals);
		takeAnimals(dogs);
	}
	public <T extends Animal> void takeAnimals(ArrayList<T> animals) {
		for(Animal a: animals) {
			a.eat();
		}
	}
}