import java.util.ArrayList;

public class EightQueens {

	static Chessboard chessboard;
	static Queen queen;
	static int MAX_QUEENS = 8;
	static int BOARD_DIMENSION = 8;
	static EightQueens eq;
	static ArrayList<Queen> queens;

	public static void main(String[] args) {
		eq = new EightQueens();
		queens = new ArrayList<Queen>();
		chessboard = new Chessboard(BOARD_DIMENSION);
		while (queens.size() < MAX_QUEENS) {
			queens.add(eq.placeQueen(0, 0));
		}
		eq.printBoard();
	}

	private Queen placeQueen(int x, int y) {
		for (; x < BOARD_DIMENSION; x++) {
			for (; y < BOARD_DIMENSION; y++) {
				if (!chessboard.isThreatened(x, y)) {
					setThreat(x, y);
					System.out.println("Queen was palced." + x + " " + y);
					return new Queen(x, y);	
				}
			}
		}
		return null;
	}

	private void setThreat(int x, int y) {
		setHorizontalThreat(y);
		setVerticalThreat(x);
		setDiaThreat(x, y);
	}

	private void setHorizontalThreat(int y) {
		for (int x = 0; x < BOARD_DIMENSION; x++) {
			chessboard.setIsThreat(x, y);
			System.out.println("Horizontal Threat was palced." + x + " " + y);
		}
	}

	private void setVerticalThreat(int x) {
		for (int y = 0; y < BOARD_DIMENSION; y++) {
			chessboard.setIsThreat(x, y);
			System.out.println("Vertical Threat was palced." + x + " " + y);
		}

	}

	private void setDiaThreat(int x, int y) {
		if (x <= y) {
			int tempY = y - x;
			for (int tempX = 0; tempY < BOARD_DIMENSION; tempX++) {
				chessboard.setIsThreat(tempX, tempY);
				System.out.println("Diagonal Threat was palced." + tempX + " " + tempY);
				tempY++;
			}
		}
		if (y < x) {
			int tempX = x - y;
			for (int tempY = 0; tempX < BOARD_DIMENSION; tempY++) {
				chessboard.setIsThreat(tempX, tempY);
				System.out.println("Diagonal Threat was palced." + tempX + " " + tempY);
				tempX++;
			}
		}
	}

	private void printBoard() {
		for (int x = 0; x < BOARD_DIMENSION; x++) {
			for (int y = 0; y < BOARD_DIMENSION; y++) {
				System.out.print("[");
				if (chessboard.isThreatened(x, y)) {
					System.out.print("X");
				} else {

					System.out.print(" ");
				}
				System.out.print("] ");
			}
			System.out.println("\n");
		}
	}
}
