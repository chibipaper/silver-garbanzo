
public class Point2D {
	private int x;
	private int y;
	
	public Point2D (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public double distance(Point2D another) {
		double xDist = this.x - another.x;
		double yDist = this.y - another.y;
		return Math.sqrt(xDist*xDist + yDist*yDist);
	}
	
	public double distance (int x, int y) {
		double xDistance = this.x - x;
		double yDistance = this.y - y;
		return Math.sqrt(xDistance*xDistance + yDistance*yDistance);
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
	
}
