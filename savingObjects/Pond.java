import java.io.*;
public class Pond implements Serializable {
	private Duck duck = new Duck();
	public static void main (String[] args) {
		Pond myPond = new Pond();
		try {
			FileOutputStream fs = new FileOutputStream("Pond.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(myPond);
			os.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

class Duck {

}

/*
Duck is not serializable!
It doesn’t implement Serializable,
so when you try to serialize a
Pond object, it fails because the
Pond’s Duck instance variable
can’t be saved.
*/