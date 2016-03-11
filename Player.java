import javax.swing.*;

public class Player {
	private char character;
	private String name;
	private int numWins;
	
	/**
	 * Konstruktor för Player
	 * @param c tecknet för spelaren
	 * @param n namnet för spelaren
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
