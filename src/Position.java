public class Position {

	private int xCord;
	private int yCord;
	
	public Position(int xCord, int yCord){
		this.xCord = xCord;
		this.yCord = yCord;
		
	}
	
	public void setxCord(int xCord){
		this.xCord = xCord;
	}
	
	public void setyCord(int yCord){
		this.yCord = yCord;
	}
	
	public int getyCord(){
		return yCord;
	}
	
	public int getxCord(){
		return xCord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCord;
		result = prime * result + yCord;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (xCord != other.xCord)
			return false;
		if (yCord != other.yCord)
			return false;
		return true;
	}
	
	
}
