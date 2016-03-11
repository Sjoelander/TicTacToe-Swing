import java.util.ArrayList;

public class BoardRules {

	private static BoardRules theInstance = null;
	private int currPlayer = 0;
	private BoardRules() {
	}

	public static BoardRules getInstance() {
		if(theInstance == null) {
			theInstance = new BoardRules();
		}
		return theInstance;
	}

	public boolean Check(ArrayList<BoardField> board, Player currPlayer) {
		if ((checkWin(board, currPlayer)) || checkDraw(board)) {
			this.currPlayer = 0;
			return true;
		} else {
			return false;
		}
	}
	private boolean checkWin(ArrayList<BoardField> board, Player currPlayer) {

		int i = 0;
		int k = 0;
		
		for (int j = 0; j<3; j++) {
			
			/*
            0 1 2
            3 4 5
            6 7 8
			 */
			
			if ((board.get(i).getValue() == board.get(i+1).getValue()) && (board.get(i+1).getValue() == board.get(i+2).getValue())) {
				if (!(board.get(i).getValue() == Marker.EMPTY.getInput())) {
					resetGame(board);
					currPlayer.increment();
					return true;
				}
			}
			
			if ((board.get(k).getValue() == board.get(k+3).getValue()) && (board.get(k).getValue() == board.get(k+6).getValue())) {
				if (!(board.get(k).getValue() == Marker.EMPTY.getInput())) {
					resetGame(board);
					currPlayer.increment();
					return true;
				}
			}

			i = i + 3;
			k++;

		}

		// Kolla diagonalen
		if (board.get(0).getValue() == board.get(4).getValue() && (board.get(4).getValue() == board.get(8).getValue())) {
			if (!(board.get(0).getValue() == Marker.EMPTY.getInput())) {
				resetGame(board);
				currPlayer.increment();
				return true;
			}
		}

		if ((board.get(2).getValue() == board.get(4).getValue()) && (board.get(4).getValue() == board.get(6).getValue())) {
			if (!(board.get(2).getValue() == Marker.EMPTY.getInput())) {
				resetGame(board);
				currPlayer.increment();
				return true;
			}
		}

		BoardRules.getInstance().switchPlayer();
		return false;

	}

	private boolean checkDraw(ArrayList<BoardField> board) {

		for (int i = 0; i < 9; i++) {
			if (board.get(i).equals(' ')) {
				return false;
			}
		}
		resetGame(board);
		return true;
	}

	public void checkMove(int btnPress, ArrayList<BoardField> board) throws InvalidMoveException {
		if (!(board.get(btnPress).getValue() == Marker.EMPTY.getInput())) {
			throw new InvalidMoveException();
		}
	}

	public int getcurrPlayer() {
		return currPlayer;
	}

	public void switchPlayer () {
		currPlayer ^= 1;
	}

	private void resetGame(ArrayList<BoardField> board) {
		for (int i = 0; i < 9; i++) {
			board.get(i).setMove(Marker.EMPTY.getInput());
		}
	}


}

