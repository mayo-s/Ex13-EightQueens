import java.util.ArrayList;

public class EightQueens {
	
	static Chessboard chessboard;
	static Queen queen;	
	static int BOARD_DIMENSION = 8;
	static EightQueens eq;
	static ArrayList<Queen> queens;

	public static void main(String[] args) {
		eq = new EightQueens();
		queens = new ArrayList<Queen>();
		chessboard = new Chessboard(BOARD_DIMENSION);
		eq.placeQueen(0, 0);
	}
	
	private void placeQueen(int x, int y){
		for(;x < BOARD_DIMENSION; x++){
			for(; y < BOARD_DIMENSION; y++){
				if(!chessboard.isThreatened(x, y)){
					queens.add(new Queen(x, y));
					setThreat(x, y);
					
				}					
			}
		}
	}
	
	private void setThreat(int x, int y){
		
	}

}
