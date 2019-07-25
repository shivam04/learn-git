import javax.swing.*;
import java.awt.*;
public class FlowLayoutTest {
	public static void main (String[] args) {
		FlowLayoutTest gui = new FlowLayoutTest();
		gui.go();
	}
	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("shock me");
		JButton buttonTwo = new JButton("bliss");
		JButton buttonThree = new JButton("huh?");
		JButton buttonFour = new JButton("oh!");
		panel.add(button);
		panel.add(buttonTwo);
		panel.add(buttonThree);
		panel.add(buttonFour);
		panel.setBackground(Color.darkGray);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(250,200);
		frame.setVisible(true);
	}
}