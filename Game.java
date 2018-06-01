import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {
	// Game size
	public static final int SCREEN_HEIGHT = 500;
	public static final int SCREEN_WIDTH = 500;
	
	//GUI
	private JPanel btnMenu;
	private JButton btnClear;

	private GameData gameData; // TODO: check if any implications
	private Motion motion;

	// Construct game
	public Game() {

		// initialise gameData, screen
		gameData = new GameData();		
		motion = new Motion(SCREEN_WIDTH, SCREEN_HEIGHT,gameData); //TODO: resizeable playable game
		Screen canvas = new Screen(gameData, motion);
		
		//construct game
		setTitle("World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Container cp = getContentPane();

		cp.add(canvas, BorderLayout.CENTER);
		canvas.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); // TODO: set collision bounds to current window
																		 // size
		
		btnMenu = new JPanel();
		btnMenu.setBackground(Color.DARK_GRAY);
		cp.add(btnMenu, BorderLayout.SOUTH);
		
		btnClear = new JButton("Clear all Objects");
		btnMenu.add(btnClear);
		
		//TODO: modify when including multithreading env
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameData.clearData();
				repaint();
			}
		});
	
		new Timer(16, canvas).start(); // in charge of rendering currently. TODO: implement proper game loop timing

		pack();

	}

	// code for render
	public void render() {
		repaint(); // To use when proper game loop is implemented. For now using timer class
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Game();
			}
		});
	}
}

