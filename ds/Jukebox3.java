import java.util.*;
import java.io.*;
public class Jukebox3 {
	ArrayList<Song> songList = new ArrayList<Song>();
	public static void main(String[] args) {
		new Jukebox3().go();
	}
	public void go() {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
	}
	void getSongs() {
		try {
			File file = new File("SongListMore.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line= reader.readLine()) != null) {
				addSong(line);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
}


//It won’t compile!

/*
With generics, you can
create type-safe collections
where more problems are
caught at compile-time
instead of runtime.

Without generics, the
compiler would happily let
you put a Pumpkin into an
ArrayList that was supposed
to hold only Cat objects.
*/