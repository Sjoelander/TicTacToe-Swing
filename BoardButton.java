import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class BoardButton extends JButton implements Observer {

	static ImageIcon xIcon = new ImageIcon(BoardButton.class.getResource("X.png"));
	static ImageIcon oIcon = new ImageIcon(BoardButton.class.getResource("O.png"));


	public BoardButton() {
	}


	@Override
	public void update(Observable o, Object arg) {
		char xo = ((BoardField)o).getValue();

		if (xo == (Marker.X.getInput())) {
			setIcon(xIcon);
			setDisabledIcon(xIcon);
		}

		else if(xo == (Marker.O.getInput())) {
			setIcon(oIcon);
			setDisabledIcon(oIcon);
		}

		else {
			setIcon(null);
			setDisabledIcon(null);
		}

	}
}


