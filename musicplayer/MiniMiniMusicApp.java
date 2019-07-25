import javax.sound.midi.*;
public class MiniMiniMusicApp {
	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer(); //cd player
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4); //cd
			Track track = seq.createTrack(); //Ask the Sequence for a Track. 
			// Remember, the Track lives in the Sequence, and the MIDI data lives in the Track
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, 102, 0);
			MidiEvent firstM = new MidiEvent(first,0);
			track.add(firstM);
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 56, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 3);
			track.add(noteOff);
			player.setSequence(seq); //Give the Sequence to the Sequencer (like putting the CD in the CD player)
			player.start();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}