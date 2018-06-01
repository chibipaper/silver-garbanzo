import java.awt.*;

public class Circle {
	// circle attributes
	private Color color;
	private int radius;

	// for motion
	private Point2D center; //(x,y)
	//private int xPos;
	//private int yPos;
	private int xVelocity;
	private int yVelocity;
	private int xAcceleration;
	private int yAcceleration;

	private int force;
	private int mass;

	public Circle() {
		color = new Color(220, 20, 60);
		center = new Point2D(0,0);
	}
	
	public Circle(int xPos, int yPos) {
		center = new Point2D(xPos, yPos);
		radius = 60;
		color = new Color(220, 20, 60); //TODO: modify to more variations later
		
		xVelocity = 5; //TODO: modify for physics engine
		yVelocity = 5;
	}

	
	public static void createNew(int xPos, int yPos, GameData gameData) {
		// input: obtain mouse pos
		// store in memory[]
		gameData.addObject(xPos, yPos);

		// draw this circle at this position with default states for now
		// TODO: spawn circles w randomised radius, color
		System.out.println("ttest");

	}
	
	public static void main(String[] args) {
		Circle c1 = new Circle(3, 3);
		Circle c2 = new Circle(2, 2);
		
		System.out.println(c1.distance(c2));
	}
	
	public double distance(Circle another) {
		double xDist = this.getX() - another.getX();
		double yDist = this.getY() - another.getY();
		return Math.sqrt(xDist*xDist + yDist*yDist);
	}
	
	public Point2D getCenter() {
		return this.center;
	}
	
	public int getX () {
		return this.center.getX();
	}
	
	public int getY() {
		return this.center.getY();
	}
	
	public void setX(int x) {
		this.center.setX(x);
	}
	
	public void setY(int y) {
		this.center.setY(y);
	}

	public void increaseHorSpeed() {

	}

	public void decreaseHorSpeed() {

	}

	public void increaseVertSpeed() {

	}

	public void decreaseVertSpeed() {

	}
	
	
	//getters , setters
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}


	public int getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	public int getxAcceleration() {
		return xAcceleration;
	}

	public void setxAcceleration(int xAcceleration) {
		this.xAcceleration = xAcceleration;
	}

	public int getyAcceleration() {
		return yAcceleration;
	}

	public void setyAcceleration(int yAcceleration) {
		this.yAcceleration = yAcceleration;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}
	
	
	
	
	
}
