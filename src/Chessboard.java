import java.util.ArrayList;

public class Chessboard {

	Boolean[][] board;
	ArrayList<Position> queens;

	public Chessboard(int dimension) {
		board = new Boolean[dimension][dimension];
		queens = new ArrayList<Position>();
		
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++) {
				board[i][j] = false;
			}
		}
		
	}

	public void setQueen(int xCord, int yCord) {
		Position queen = new Position(xCord, yCord);
		queens.add(queen);
	}

	public void setThreats(Position queen) {
		int positionX = queen.getxCord();
		int positionY = queen.getyCord();

		rowThreats(new Position(positionX, 0));
		colThreats(queen);

		int posXRight = queen.getxCord();
		int posYRight = queen.getyCord();
		
		if (positionX < positionY) {

			posXRight = positionX - (positionX - 1);
			posYRight = positionY - (positionX - 1);

		} else {

			posYRight = positionY - (positionY - 1);
			posXRight = positionX - (positionY - 1);

		}

		Position diaRightPosition = new Position(posXRight, posYRight);

		diaRightThreats(queen);
		diaLeftThreats(queen);

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
		

		if (positionX + 1 < board.length || positionY + 1 < board[positionY].length) {
			curr.setyCord(positionX + 1);
			curr.setyCord(positionY + 1);
			diaRightThreats(curr);
		}
	}

	public void diaLeftThreats(Position curr) {
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();

		board[positionX][positionY] = true;
		System.out.println("Yeahi!");

		if ((positionX - 1) >= 0 && (positionY - 1) >= 0) {
			curr.setxCord(positionX - 1);
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
	
	public void printBoard(){
		for ( int i = 0; i < board.length; i++){
			for ( int j = 0; j < board.length; j++){
				if (board[i][j] == true){
					System.out.print("[ ]");
				}
				else{
					System.out.print("[!]");
				}
			}
			System.out.println();
		}
	}
}
