import java.util.ArrayList;

public class Chessboard {

	Boolean[][] board;
	ArrayList<Position> queens;

	public Chessboard(int dimension) {
		board = new Boolean[dimension][dimension];
		queens = new ArrayList<Position>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = false;
			}
		}

	}

	public void setQueen(int xCord, int yCord) {
		Position queen = new Position(xCord, yCord);
		queens.add(queen);
		setThreats(queen);
	}

	public void setQueens(int amount) {

		for (int i = 0; i < amount; i++) {
			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k < board.length; k++) {
					Position curr = new Position(j, k);
					if (!isThreatened(curr)) {
						setQueen(j, k);
						printBoard();
						System.out.println();
					}
				}
			}

		}
	}

	public void setThreats(Position queen) {
		int positionX = queen.getxCord();
		int positionY = queen.getyCord();

		rowThreats(new Position(positionX, 0));
		colThreats(new Position(0, positionY));

		int posXRight = queen.getxCord();
		int posYRight = queen.getyCord();

		if (positionX <= positionY) {

			posXRight = positionX - (positionX);
			posYRight = positionY - (positionX);

		} else if (positionX > positionY) {

			posYRight = positionY - (positionY);
			posXRight = positionX - (positionY);

		}

		Position diaRightPosition = new Position(posXRight, posYRight);

		diaRightThreats(diaRightPosition);

		int posXLeft = queen.getxCord();
		int posYLeft = queen.getyCord();

		while ((posXLeft < board.length - 1) && (posYLeft > 0)) {

			posXLeft = posXLeft + 1;
			posYLeft = posYLeft - 1;

		}

		Position diaLeftPosition = new Position(posYLeft, posXLeft);
		diaLeftThreats(diaLeftPosition);

	}

	public void rowThreats(Position curr) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] = true;

		if (positionY + 1 < board[positionY].length) {
			curr.setyCord(positionY + 1);
			rowThreats(curr);
		}
	}

	public void colThreats(Position curr) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] = true;

		if (positionX + 1 < board.length) {
			curr.setxCord(positionX + 1);
			colThreats(curr);
		}
	}

	public void diaRightThreats(Position curr) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] = true;

		if (positionX + 1 < board.length && positionY + 1 < board.length) {
			curr.setxCord(positionX + 1);
			curr.setyCord(positionY + 1);
			diaRightThreats(curr);
		}
	}

	public void diaLeftThreats(Position curr) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] = true;

		if ((positionX + 1) < board.length && (positionY - 1) >= 0) {
			curr.setxCord(positionX + 1);
			curr.setyCord(positionY - 1);
			diaLeftThreats(curr);
		}
	}

	public Boolean isThreatened(Position curr) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();
		if (board[positionX][positionY]) {
			return true;
		} else {
			return false;
		}
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				// // Mark threats visible
				// if (board[i][j] != true) {
				// System.out.print("\u25FD");
				// } else {
				// System.out.print("\u25FE");
				// }
				// }

				// Normal chess board look

				if (hasQueen(i, j)) {
					System.out.print("\u2655");
				} else if (board[i][j] != true) {
					System.out.print("\u25FD");
				} else {
					System.out.print("\u25FE");
				}

			}

			System.out.println();
		}
	}

	public Boolean hasQueen(int x, int y) {

		for (Position curr : queens) {
			int xCurr = curr.getxCord();
			int yCurr = curr.getyCord();

			if ((xCurr == x) && (yCurr == y)) {
				return true;
			}
		}
		return false;
	}
}
