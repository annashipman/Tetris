package anna.shipman.main.tetris;

import java.awt.Color;

/*
 *S Piece
 *
 *0 Rotation and 180 Rotation      90 Rotation and 270 Rotation
 * 
 *                                 ***** 
 *                                 * 3 *
 *                                 *****
 *        ***** *****              ***** *****	
 *        * 1 * * 2 *              * 1 * * 2 *
 *        ***** *****              ***** *****      
 *  ***** *****                          *****
 *  * 4 * * 3 *                          * 4 *
 * 	***** *****                          *****
 *        
 */
public class SPiece extends TetrisPiece {

	public SPiece(final Board board) {
		super(board);
		colour = Color.WHITE;
	}

	@Override
	protected int getSquareTwoX() {
		return squareOne.x + Board.SQUARE;
	}

	@Override
	protected int getSquareTwoY() {
		return squareOne.y;
	}

	@Override
	protected int getSquareThreeX() {
		return squareOne.x;
	}

	@Override
	protected int getSquareThreeY() {
		if (degrees == 0 || degrees == 180) {
			return squareOne.y + Board.SQUARE;
		} else if (degrees == 90 || degrees == 270) {
			return squareOne.y - Board.SQUARE;
		} else
			return 0; // again with the else if
	}

	@Override
	protected int getSquareFourX() {
		if (degrees == 0 || degrees == 180) {
			return squareOne.x - Board.SQUARE;
		} else if (degrees == 90 || degrees == 270) {
			return squareOne.x + Board.SQUARE;
		} else
			return 0; // again with the else if
	}

	@Override
	protected int getSquareFourY() {
		return squareOne.y + Board.SQUARE;
	}

	@Override
	public int getBottomY() {
		final int bottomY = squareOne.y + (Board.SQUARE * 2);
		return bottomY;
	}

	@Override
	public int getLeftX() {
		final int leftX;
		if (degrees == 0 || degrees == 180) {
			leftX = squareOne.x - Board.SQUARE;
		} else if (degrees == 90 || degrees == 270) {
			leftX = squareOne.x;
		} else
			leftX = 0;// can I use enums in some way to show
		// that these are comprehensive?
		return leftX;
	}

	@Override
	public int getRightX() {
		final int rightX = squareOne.x + (Board.SQUARE * 2);
		return rightX;
	}
}
