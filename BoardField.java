import java.util.Observable;

public class BoardField extends Observable {

	//char values = X, O ' '
	char value;

	public BoardField(char c) {
		value = c;
	}

	public void setMove(char c) {
		value = c;
		this.setChanged();
		this.notifyObservers();
	}

	public boolean equals(char otherChar) {
		if ( value == otherChar) {
			return true;
		}
		return false;
	}

	public char getValue(){


		return value;

	}



}
