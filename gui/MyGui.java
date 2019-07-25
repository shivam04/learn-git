import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyGui implements ActionListener {
	JFrame frame;
	JButton colorButton, labelButton;
	JLabel label;
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorButton = new JButton("Change Color");
		labelButton = new JButton("Change text");
		label = new JLabel();
		label.setText("Cool!");
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(500,500);
		frame.setVisible(true);
		colorButton.addActionListener(this);
		labelButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == colorButton) {
			frame.repaint();
		} else {
			label.setText("That hurt!");
		}
	}
	public static void main(String[] args) {
		MyGui mg = new MyGui();
		mg.go();
	}
}