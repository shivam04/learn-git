import javax.sound.midi.*;
public class MusicTest1 {
	public void play() {
		try{
			Sequencer sequencer = MidiSystem.getSequencer(); //MusicTest1.java:13: unreported exception javax.sound.midi. 
														//MidiUnavailableException; must be caught or declared to be thrown
			System.out.println("We got a sequencer");
		}catch(MidiUnavailableException ex) {
			System.out.println("Bummer");
		}	
	} 
	public static void main(String[] args) {
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}
}