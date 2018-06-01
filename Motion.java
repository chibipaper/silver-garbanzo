
public class Motion {
	private GameData gameData;
	private int canvasWidth;
	private int canvasHeight;

	public Motion(int canvasWidth, int canvasHeight, GameData gameData) {
		this.gameData = gameData;
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
	}

	public void displace() {
		if (!gameData.memoryIsEmpty()) {
			for (int i = 0; i < gameData.getMemory().length; i++) {
				if (gameData.reachedLast(i))
					break;

				int xPos = gameData.getMemory()[i].getX();
				xPos += gameData.getMemory()[i].getxVelocity();
				gameData.getMemory()[i].setX(xPos);

				int yPos = gameData.getMemory()[i].getY();
				yPos += gameData.getMemory()[i].getyVelocity();
				gameData.getMemory()[i].setY(yPos);

			}
		}
	}

	// to optimise
	public void circleIntersects() {
		
		//System.out.println("circleIntersects() was called");
		if (!gameData.memoryIsEmpty()) {
			// for this circle,
			for (int i = 0; i < gameData.getMemory().length; i++) {
				// compare length with all other circles stored in memory
				if (gameData.reachedLast(i)) // to optimise
					break;

				Circle thisCircle = gameData.getMemory()[i];

				for (int j = gameData.getLastElement(); j > i; j--) {

					Circle another = gameData.getMemory()[j];
					// check everything but itself, and if next obj in memory doesn't exist

					
					double distance = thisCircle.distance(another);

					double totalRadius = thisCircle.getRadius() + another.getRadius();
					if (distance <= totalRadius) { // ie intersects
						
						
						
						int thisXVelocity = -thisCircle.getxVelocity();
						int thisYVelocity = -thisCircle.getyVelocity();
						int anotherXVel = -another.getxVelocity();
						int anotherYVel = -another.getyVelocity();
						
						
						
						thisCircle.setxVelocity(thisXVelocity);
						thisCircle.setyVelocity(thisYVelocity);
						another.setxVelocity(anotherXVel);
						another.setyVelocity(anotherYVel);
					}

				}

			}

		}
		// return false;

	}

	// TODO: optimise code...
	public void intersectBound() {
		if (!gameData.memoryIsEmpty()) {
			for (int i = 0; i < gameData.getMemory().length; i++) {
				if (gameData.reachedLast(i))
					break;

				// For circle
				int xPos = gameData.getMemory()[i].getX();
				int yPos = gameData.getMemory()[i].getY();
				int radius = gameData.getMemory()[i].getRadius();

				// check horizontal bound
				if ((xPos - radius) < 0 || (xPos + radius) > canvasWidth) {
					int xVelocity = -gameData.getMemory()[i].getxVelocity();
					gameData.getMemory()[i].setxVelocity(xVelocity);
				}
				// check vertical bound
				if ((yPos - radius) < 0 || (yPos + radius) > canvasWidth) {
					int yVelocity = -gameData.getMemory()[i].getyVelocity();
					gameData.getMemory()[i].setyVelocity(yVelocity);
				}

			}
		}
	}
}
