import java.util.ArrayList;

public class Chessboard {

	int[][] board;
	ArrayList<Position> queens;

	public Chessboard(int dimension) {
		board = new int[dimension][dimension];
		queens = new ArrayList<Position>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
			}
		}

	}

	public void setQueen(int xCord, int yCord) {
		Position queen = new Position(xCord, yCord);
		queens.add(queen);
		setThreats(queen);
	}

	public void unsetQueen(int xCord, int yCord) {
		Position queen = new Position(xCord, yCord);
		queens.remove(queen);
		unsetThreats(queen);

	}

	public Boolean setQueens(int amount, int xCord, int yCord) {

		if (amount == 0) {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (!isThreatened(board[i][j])) {
					setQueen(i, j);

					if (!setQueens(amount - 1, i, j)) {
						unsetQueen(i, j);

					} else {
						return true;
					}
				}
			}
		}

		return false;
	}

	public void setThreats(Position queen) {
		int positionX = queen.getxCord();
		int positionY = queen.getyCord();

		rowThreats(new Position(positionX, 0), 1);
		colThreats(new Position(0, positionY), 1);

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

		diaRightThreats(diaRightPosition, 1);

		int posXLeft = queen.getxCord();
		int posYLeft = queen.getyCord();

		while ((posXLeft < board.length - 1) && (posYLeft > 0)) {

			posXLeft = posXLeft + 1;
			posYLeft = posYLeft - 1;

		}

		Position diaLeftPosition = new Position(posYLeft, posXLeft);
		diaLeftThreats(diaLeftPosition, 1);

	}

	public void unsetThreats(Position queen) {
		int positionX = queen.getxCord();
		int positionY = queen.getyCord();

		rowThreats(new Position(positionX, 0), -1);
		colThreats(new Position(0, positionY), -1);

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

		diaRightThreats(diaRightPosition, -1);

		int posXLeft = queen.getxCord();
		int posYLeft = queen.getyCord();

		while ((posXLeft < board.length - 1) && (posYLeft > 0)) {

			posXLeft = posXLeft + 1;
			posYLeft = posYLeft - 1;

		}

		Position diaLeftPosition = new Position(posYLeft, posXLeft);
		diaLeftThreats(diaLeftPosition, -1);

	}

	public void rowThreats(Position curr, int operator) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] += operator;

		if (positionY + 1 < board[positionY].length) {
			curr.setyCord(positionY + 1);
			rowThreats(curr, operator);
		}
	}

	public void colThreats(Position curr, int operator) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] += operator;

		if (positionX + 1 < board.length) {
			curr.setxCord(positionX + 1);
			colThreats(curr, operator);
		}
	}

	public void diaRightThreats(Position curr, int operator) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] += operator;

		if (positionX + 1 < board.length && positionY + 1 < board.length) {
			curr.setxCord(positionX + 1);
			curr.setyCord(positionY + 1);
			diaRightThreats(curr, operator);
		}
	}

	public void diaLeftThreats(Position curr, int operator) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] += operator;

		if ((positionX + 1) < board.length && (positionY - 1) >= 0) {
			curr.setxCord(positionX + 1);
			curr.setyCord(positionY - 1);
			diaLeftThreats(curr, operator);
		}
	}

	public Boolean isThreatened(int curr) {

		if (curr == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				if (hasQueen(i, j)) {
					System.out.print("\u2655");

				} else if ((i + j) % 2 == 0) {
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

	public void printQueens() {
		System.out.println(queens);
	}
}
