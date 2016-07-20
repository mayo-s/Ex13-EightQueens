
public class EightQueens {

	public static void main(String[] args) {

		System.out.println("8 Queens on an 8 x 8 chessboard:");
		System.out.println();
		Chessboard myBoard = new Chessboard(8);
		myBoard.setQueens(8,0,0);
		myBoard.printBoard();
		System.out.println();
		System.out.println("10 Queens on an 10 x 10 chessboard:");
		System.out.println();
		Chessboard myOtherBoard = new Chessboard(10);
		myOtherBoard.setQueens(10,0,0);
		myOtherBoard.printBoard();
		System.out.println();
		System.out.println("13 Queens on an 13 x 13 chessboard:");
		System.out.println();
		Chessboard myBigBoard = new Chessboard(13);
		myBigBoard.setQueens(13,0,0);
		myBigBoard.printBoard();
		System.out.println();

	}

}
