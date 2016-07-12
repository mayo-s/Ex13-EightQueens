
public class EightQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Chessboard myBoard = new Chessboard(8);
//		myBoard.rowThreats(new Position(3,0));
//		myBoard.colThreats(new Position(0,3));
	//	myBoard.diaLeftThreats(new Position(3,6));
//		myBoard.diaRightThreats(new Position(0,0));
	myBoard.setThreats(new Position(3,3));
		myBoard.printBoard();
		
		
	}

}
