
public class Chessboard {
	
	Boolean[][] chessboard;
	boolean isThreatened;
	
	public Chessboard(int size){
		chessboard = new Boolean[size][size];
		setInitialFieldValue(size);
	}
	
	private void setInitialFieldValue(int maxSize){
		for(int x = 0; x < maxSize; x++){
			for(int y = 0; y < maxSize; y++){
				chessboard[x][y] = false;				
			}
		}
	}
	
	public void setIsThreat(int x, int y){
		chessboard[x][y] = true;
	}
	
	public boolean isThreatened(int x, int y){
		return isThreatened; 
	}
}
