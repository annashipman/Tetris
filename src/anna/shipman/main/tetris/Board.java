package anna.shipman.main.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Board extends JFrame {

	public static final int SQUARE = 10;

	public static final int WIDTH = 100;
	public static final int HEIGHT = 200;

	public static final int MIDPOINT = WIDTH / 2;
	public static final int TOP = 0;

/*For KeyListener
 * 	public static final String LEFT = "Left";
	public static final String RIGHT = "Right";
	public static final String DOWN = "Down";
*/
	private ArrayList<Point> filledSquares = new ArrayList<Point>();
	
	private static JPanel panel = new JPanel();

	public Board() {
		// addKeyListener(directionListener);
		// why doesn't the background work?
		setBackground(Color.BLACK);
		final OverlayLayout overlay = new OverlayLayout(panel);
		// does it need to be overlay?

		panel.setLayout(overlay);
		// panel.add(food);
		// panel.add(snake);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		setContentPane(panel);
		setTitle("Tetris");

		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public Board(boolean test){
		
	}

	//should i return something? for test? what happens if add
	//is wrong? should i include a check to see if the piece is already
	//in here or assume it isn't?
	public void addRestingPiece(final TetrisPiece piece){
		filledSquares.add(piece.squareOne);
		filledSquares.add(piece.squareTwo);
		filledSquares.add(piece.squareThree);
		filledSquares.add(piece.squareFour);
	}
	
	public boolean squareIsAvailable(final Point nextSquare){
		boolean available = true;
		if (filledSquares.contains(nextSquare)){
			available = false;
		}
		return available;
	}
}
