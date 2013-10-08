package anna.shipman.main.tetris;

import java.awt.Color;

/*
 * O Piece
 * 
 *  All Rotations
 * 
 *  ***** *****
 *  * 1 * * 2 *
 *  ***** *****
 *  ***** *****
 *  * 3 * * 4 *
 *  ***** *****
 * 
 */
public class OPiece extends TetrisPiece {

	public OPiece(final Board board) {
		super(board);
		colour = Color.WHITE;
	}
	
	@Override
	public int getBottomY() {
		int bottomY = squareOne.y + (Board.SQUARE * 2);
		return bottomY;
	}

	@Override
	public int getLeftX() {
		int leftX = squareOne.x;
		return leftX;
	}

	@Override
	public int getRightX() {
		int rightX = squareOne.x + (Board.SQUARE * 2);
		return rightX;
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
		return squareOne.y + Board.SQUARE;
	}

	@Override
	protected int getSquareFourX() {
		return squareOne.x + Board.SQUARE;
	}

	@Override
	protected int getSquareFourY() {
		return squareOne.y + Board.SQUARE;
	}

}
