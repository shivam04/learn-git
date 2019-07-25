import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MiniMusicPlayer2 implements ControllerEventListener {
	public static void main(String[] args) {
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
	}

	public void go() {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(this, eventsIWant);
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			for (int i = 5; i < 60; i+= 4) {
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(176,1,127,0,i));
				track.add(makeEvent(128,1,i,100,i + 2));
			}
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void controlChange(ShortMessage event) {
		System.out.println("la");
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		}catch(Exception e) { }
		return event;	
	}

	class MyDrawPanel extends JPanel implements ControllerEventListener {
		boolean msg = false;
		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}
		public void paintComponent(Graphics g) {
			if (msg) {
				Graphics2D g2 = (Graphics2D) g;
				int r = (int) (Math.random() * 250);
				int gr = (int) (Math.random() * 250);
				int b = (int) (Math.random() * 250);
				g.setColor(new Color(r,gr,b));
				int ht = (int) ((Math.random() * 120) + 10);
				int width = (int) ((Math.random() * 120) + 10);
				int x = (int) ((Math.random() * 40) + 10);
				int y = (int) ((Math.random() * 40) + 10);
				g.fillRect(x,y,ht, width);
				msg = false;
			}
		}
	}
}


/*
Register for events with the sequencer.
The event registration method takes the
listener AND an int array representing
the list of ControllerEvents you want.
We want only one event, #127.
*/