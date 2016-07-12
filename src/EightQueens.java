
public class EightQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Chessboard myBoard = new Chessboard(8);
		myBoard.rowThreats(new Position(3,3));
		myBoard.printBoard();
		
		
	}

}
