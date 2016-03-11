import javax.swing.*;

public class Player {
	private char character;
	private String name;
	private int numWins;
	
	/**
	 * Konstruktor f�r Player
	 * @param c tecknet f�r spelaren
	 * @param n namnet f�r spelaren
	 */
	
	public Player(char c, String n) {
		character = c;
		name = n;
		numWins = 0;
	}

	public String getName() {
		return name;
	}

	public char getCharacter() {
		return character;
	}

	public int getNumWins() {
		return numWins;
	}

	public void increment() {
		numWins++;
		MessageDialog();
	}

	private void MessageDialog () {
		JOptionPane.showMessageDialog(null, "Spelare " + this.name + " har vunnit.");
	}

}
