public class check {
	public static void main(String[] args) {
		new check().go();
	}
	public void go() {
		Dog[] dogs = {new Dog(), new Dog(), new Dog()};
		takeAnimals(dogs);
	}
	public void takeAnimals(Animal[] animals) {
		animals[0] = new Cat();
	}
}