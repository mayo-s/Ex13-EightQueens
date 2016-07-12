import java.util.ArrayList;

public class Chessboard {

	Boolean[][] board;
	ArrayList<Position> queens;
	
	public Chessboard(int dimension){
		board = new Boolean[dimension][dimension];
		queens = new ArrayList<Position>();
	}
	
	public void setQueen(int xCord, int yCord){
		Position queen = new Position(xCord, yCord);
		queens.add(queen);
	}
	
	public void setThreats(Position queen){
		int positionX = queen.getxCord();
		int positionY = queen.getyCord();
			
		
	}
	
	public void rowThreats(Position curr){
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();
		
		board[positionX][positionY] = true;
		
		if (positionY + 1 < board.length){
			curr.setyCord(positionY + 1);
			rowThreats(curr);
		}
	}
	
	public void colThreats(Position curr){
		int positionY = curr.getyCord();
		int positionX = curr.getxCord();
		
		board[positionX][positionY] = true;
		
		if (positionX + 1 < board.length){
			curr.setyCord(positionX + 1);
			rowThreats(curr);
		}
	}
}
