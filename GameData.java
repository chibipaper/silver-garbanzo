import java.awt.Color;
import java.util.ArrayList;

/* GameData keeps track of game's state. 
 * memory stores references to objects, which can then be retrieved to perform further manipulations. 
 * memory is a stack data structure that is implemented using ArrayList.
 *
 */

public class GameData {

	public static final int maxSize = 10;
	public static final Circle EMPTY_MEMORY = null;
	private Circle[] memory; // TODO: Modify to obj[] for more shapes .. make a
								// obj hierarchy: Obj : Circle, Obj : Rect, Obj is the root
	
	//private ArrayList memory;
	

	// Orange, Red, crimson, , salmon, light salmon, light coral
	private Color[] colors = { Color.ORANGE, new Color(220, 20, 60), new Color(250, 128, 114), new Color(255, 160, 122),
			new Color(240, 128, 128) };
	private int lastElement;
	private boolean memoryIsEmpty = true;

	public GameData() {
		initialiseStack(); // stack implemented using array Circle[]


	}

	public void initialiseStack() {
		//memory = new ArrayList<Circle>(maxSize); //TODO: modify maxSize name to initialSize
		
		
		
		memory = new Circle[maxSize];

		// initialise memory
		for (int i = 0; i < maxSize; i++) {
			memory[i] = EMPTY_MEMORY;
		}

		lastElement = -1; // memory is 0
	}

	public boolean memoryCellIsEmpty(Circle circle) {
		if (circle == null)
			return true;
		else
			return false;
	}

	public boolean memoryIsEmpty() {
		/*
		 * for (int i = 0; i < maxSize; i++) { if (memory[i] != EMPTY_MEMORY) return
		 * false; } return true;
		 */
		// optimised code:
		return memoryIsEmpty;
	}

	// for loop control
	public void setMemoryIsEmpty(boolean memoryIsEmpty) {
		this.memoryIsEmpty = memoryIsEmpty;
	}

	// lastElement keeps track of last element in stack
	// To be used when scanning through array
	// if loop counter i points outside of stack,
	// stop loop
	public boolean reachedLast(int index) {
		if (lastElement + 1 == index)
			return true;
		else
			return false;
	}

	public void clearData() {
		// Stack manipulation. re-initialise memory
		this.initialiseStack();

		// for loop control
		this.setMemoryIsEmpty(true);

	}

	public void addObject(int xPos, int yPos) {
		try {
			// stack manipulation
			lastElement++;
			// create new circle
			memory[lastElement] = new Circle(xPos, yPos); // store ref to Circle into memory
			memory[lastElement].setColor(genRanColour()); //
			//memory[lastElement].setRadius(genRanCircleSize());
			
		}
		
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Memory is full!");
		}
		
	

	}

	// generate a random colour from given set of colours
	public Color genRanColour() {
		int pos = (int) ((Math.random() * 100) % colors.length);
		return colors[pos];
	}

	public int genRanCircleSize() {
		int size = (int) ((Math.random() * 100));
		return size;

	}

	public int getLastElement() {
		return this.lastElement;
	}

	public int getMaxsize() {
		return maxSize;
	}

	public Circle[] getMemory() {
		return memory;
	}

}
