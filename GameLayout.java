import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameLayout extends JFrame {

	private JPanel mainPanel;
	private BoardButton boardButton[] = new BoardButton[9];
	private BoardField boardField[] = new BoardField[9];
	private JPanel southPanel;
	private JTextArea textArea;
	private ArrayList<BoardButton> buttons;
	private ArrayList<BoardField> field;

	GameLayout() {
		CreateLayout();
	}

	private void CreateLayout() {

		Player[] player = new Player[2];
		char[] marker = {Marker.X.getInput(), Marker.O.getInput()};
		
		for (int i = 0; i < 2; i++) {
			while (true) {
				String name = JOptionPane.showInputDialog(null, "Vad heter Spelare " +(i+1) + "?", "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
				if ((name == null)) {
					System.exit(1); 
				} else if ((name.length() > 0)) {
					player[i] = new Player(marker[i], name);
					break;
				} else {
					//Continue
				}
			}
		}

		buttons = new ArrayList<BoardButton>();
		field = new ArrayList<BoardField>();

		mainPanel = new JPanel();
		southPanel = new JPanel();

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setEnabled(true);


		for (int i = 0 ; i < 9; i++) {
			
			boardButton[i] = new BoardButton();
			buttons.add(boardButton[i]);
			boardButton[i].setPreferredSize(new Dimension(150, 100));
			boardField[i] = new BoardField(Marker.EMPTY.getInput());
			field.add(boardField[i]);
			boardField[i].addObserver(boardButton[i]);
			boardButton[i].addActionListener(new ActionListener()  {

				@Override
				public void actionPerformed(ActionEvent e) {
					BoardButton tempBtn = (BoardButton) e.getSource();
					int tempIndx = buttons.indexOf(tempBtn);
					try {
						BoardRules.getInstance().checkMove(tempIndx, field);
						boardField[tempIndx].setMove(player[BoardRules.getInstance().getcurrPlayer()].getCharacter());
						BoardRules.getInstance().Check(field, player[BoardRules.getInstance().getcurrPlayer()]);
						updateText(textArea, player[0], player[1], player[BoardRules.getInstance().getcurrPlayer()]);
						
					} catch (Exception m) {
						JOptionPane.showMessageDialog(null, m.getMessage());
					}
				}
			});
		}

		mainPanel.setLayout(new GridLayout (3,3));
		add(mainPanel, BorderLayout.CENTER);

		for (int i = 0; i < boardButton.length; i++) {
			mainPanel.add(boardButton[i]);
		}
		
		textArea.append("Nuvarande spelare: " + player[BoardRules.getInstance().getcurrPlayer()].getName() 
				+ " - " + player[BoardRules.getInstance().getcurrPlayer()].getCharacter() + "\n");
		textArea.append(player[0].getName() + " poäng: " + player[0].getNumWins() + "\n");
		textArea.append(player[1].getName() + " poäng: " + player[1].getNumWins());
		southPanel.add(textArea);
		add(southPanel, BorderLayout.SOUTH);


		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		add(mainPanel);
		setVisible(true);
		pack();

	}

	public static void updateText(JTextArea textArea, Player player1, Player player2, Player currPlayer) {
		textArea.setText(null);
		textArea.append("Nuvarande spelare: " + currPlayer.getName() + " - " + currPlayer.getCharacter() + "\n");
		textArea.append(player1.getName() + " poäng: " + player1.getNumWins() + "\n");
		textArea.append(player2.getName() + " poäng: " + player2.getNumWins());
	}
}