/* Screen class is in charge of display & rendering. 
 * Is also a interactive interface: gathers mouse inputs to create new objects
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;

class Screen extends JPanel implements ActionListener, MouseListener {
	public static final Color CANVAS_BG_COLOR = new Color(255, 255, 255);

	private GameData gameData;
	private Motion motion;
	
	

	public Screen(GameData gameData, Motion motion) { // Need to pass gameData, cos screen needs information abt obj to print
		setBackground(CANVAS_BG_COLOR);
		this.addMouseListener(this);
		this.gameData = gameData;
		this.motion = motion;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Update state
		//System.out.println("actionerPerformed is called");
		motion.displace();
		motion.circleIntersects();
		//check collision
		motion.intersectBound();
		repaint(); // repaints this component
	}

	// for rendering
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// TODO: loop to paint all components stored in memory
		
		//Access game memory, paint all circles
		if (!gameData.memoryIsEmpty()) {
			for (int i = 0; i < gameData.getMemory().length; i++) {

				if (gameData.reachedLast(i)) //if reached end of array.. check memory's implementation (array)
					break;
				g.setColor(gameData.getMemory()[i].getColor());
				
				int radius = gameData.getMemory()[i].getRadius();
				
				//Calibration
				int xPos = gameData.getMemory()[i].getX() - radius; //note: gameData stores circle center pos
				int yPos = gameData.getMemory()[i].getY() - radius; //but drawCircle doesn't draw from center
				

				g.drawOval(xPos, yPos, radius*2, radius*2);
				g.fillOval(xPos, yPos, radius*2, radius*2);
			}
		}

	}

	// Process input
	@Override
	public void mouseClicked(MouseEvent e) {
		//used to check if memory[] is empty. For loop control
		gameData.setMemoryIsEmpty(false);
		
		Circle.createNew(e.getX(), e.getY(), gameData);
		System.out.println(e.getX() + ", " + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}