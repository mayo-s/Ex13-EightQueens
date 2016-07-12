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
		setDiaThreat(x, y);
		setVerticalThreat(x);
		setHorizontalThreat(y);
	}
	
	private void setDiaThreat(int x, int y){
		if(x <= y){
			for(int tempX = 0; y < BOARD_DIMENSION; tempX++){
				chessboard.setIsThreat(tempX, y);
				y++;
			}
		}
		if(y < x){
			for(int tempY = 0; x < BOARD_DIMENSION; tempY++){
				chessboard.setIsThreat(x, tempY);
				x++;
			}
		}
	}
	
	private void setHorizontalThreat(int y){
		for(int x = 0; x < BOARD_DIMENSION; x++){
			chessboard.setIsThreat(x, y);
		}
	}
	
	private void setVerticalThreat(int x){
		for(int y = 0; y < BOARD_DIMENSION; y++){
			chessboard.setIsThreat(x, y);
		}
		
	}
	

}
