import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class QuizCardBuilder {
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;
	public static void main(String[] args) {
		QuizCardBuilder builder = new QuizCardBuilder();
		builder.go();
	}

	public void go() {
		frame = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		question = new JTextArea(6, 20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);
		JScrollPane qScroller = new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		answer = new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);
		JScrollPane aScroller = new JScrollPane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JButton nextButton = new JButton("Next Card");
		cardList = new ArrayList<QuizCard>();
		JLabel qLabel = new JLabel("Question:");
		JLabel aLabel = new JLabel("Answer:");
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());
		saveMenuItem.addActionListener(new SaveMenuListener());		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
	}

	public class NextCardListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if (isShowAnswer) {
				// show the answer because they’ve seen the question
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			} else {
				// show the next question
				if (currentCardIndex < cardList.size()) {
					showNextCard();
				} else {
					// there are no more cards!
					display.setText("That was last card");
					nextButton.setEnabled(false);
				}
			}

		}
	}

	public class OpenMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
	}

	private void loadFile(File file) {
		cardList = new ArrayList<QuizCard>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				makeCard(line);
			}
			reader.close();
		} catch(Exception ex) {
			System.out.println("couldn't read the card file");
			ex.printStackTrace();
		}
		// now time to start by showing the first card
		showNextCard();
	}

	private void makeCard(String lineToParse) {
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
		System.out.println("made a card");
	}


	private void showNextCard() {
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer = true;
	}

	public class SaveMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);
			JFileChooser fileSave = new JFileChooser();
			/*
				Brings up a file dialog box and waits on this
				line until the user chooses ‘Save’ from the
				dialog box. All the file dialog navigation and
				selecting a file, etc. is done for you by the
				JFileChooser! It really is this easy.
			*/
				fileSave.showSaveDialog(frame);
				saveFile(fileSave.getSelectedFile());
			}
		}

		public class NewMenuListener implements ActionListener {
			public void actionPerformed(ActionEvent ev) {
				cardList.clear();
				clearCard();
			}
		}

		private void clearCard() {
			question.setText("");
			answer.setText("");
			question.requestFocus();
		}

		private void saveFile(File file) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				for(QuizCard card:cardList) {
					writer.write(card.getQuestion() + "/");
					writer.write(card.getAnswer() + "\n");
				}
				writer.close();
			} catch(IOException ex) {
				System.out.println("couldn't write the cardList out");
				ex.printStackTrace();
			}
		}

	}