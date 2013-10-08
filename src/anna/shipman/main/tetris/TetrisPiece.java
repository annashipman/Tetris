package anna.shipman.main.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public abstract class TetrisPiece extends JPanel {
	
	protected Board board;
	
	protected Point squareOne;
	protected Point squareTwo;
	protected Point squareThree;
	protected Point squareFour;
	
	protected Point testSquareTwo = new Point(0, 0);
	protected Point testSquareThree = new Point(0, 0);
	protected Point testSquareFour = new Point(0, 0);

	protected Color colour;
	protected int degrees;
	
	public TetrisPiece(final Board board) {
		this.board = board;
		
		squareOne = new Point(Board.MIDPOINT, Board.TOP);
		
		squareTwo = new Point(0, 0);
		squareThree = new Point(0, 0);
		squareFour = new Point(0, 0);
		
		drawPiece();
	}		
	
	@Override
	public void paint(final Graphics graphicsContext) {
		graphicsContext.setColor(colour);
		graphicsContext.drawRect(squareOne.x,
					squareOne.y, Board.SQUARE, Board.SQUARE);
		graphicsContext.drawRect(squareTwo.x,
				squareTwo.y, Board.SQUARE, Board.SQUARE);
		graphicsContext.drawRect(squareThree.x,
				squareThree.y, Board.SQUARE, Board.SQUARE);
		graphicsContext.drawRect(squareFour.x,
				squareFour.y, Board.SQUARE, Board.SQUARE);
	}

	protected void drawPiece() {
		squareTwo.x = getSquareTwoX();
		squareTwo.y = getSquareTwoY();

		squareThree.x = getSquareThreeX();
		squareThree.y = getSquareThreeY();

		squareFour.x = getSquareFourX();
		squareFour.y = getSquareFourY();
	}
	
	protected void setPotentialNextPositionOfPiece() {
		testSquareTwo.x = getSquareTwoX();
		testSquareTwo.y = getSquareTwoY();

		testSquareThree.x = getSquareThreeX();
		testSquareThree.y = getSquareThreeY();

		testSquareFour.x = getSquareFourX();
		testSquareFour.y = getSquareFourY();
	}


	protected abstract int getSquareTwoX();
	protected abstract int getSquareTwoY();
	protected abstract int getSquareThreeX();
	protected abstract int getSquareThreeY();
	protected abstract int getSquareFourX();
	protected abstract int getSquareFourY();

	public void rotate(){
		degrees = degrees + 90;
		if (degrees == 360){
			degrees = 0;
		}
		drawPiece();
	}
	
	public void moveLeft() {
		if (squareOne.x > 0) {
			squareOne.x -= Board.SQUARE;
			final boolean canMoveLeft = testSquaresAreAvailable();
			if (canMoveLeft){
				drawPiece();
			}
			else squareOne.x += Board.SQUARE;
		}
	}

	public void moveRight() {
		if (getRightX() < Board.WIDTH) {
			squareOne.x += Board.SQUARE;
			final boolean canMoveRight = testSquaresAreAvailable();
			if (canMoveRight){
				drawPiece();
			} else {
				squareOne.x -= Board.SQUARE;
			}
		}
	}



	public void moveDown() {
		if (getBottomY() < Board.HEIGHT) {
			squareOne.y += Board.SQUARE;
			final boolean canMoveDown = testSquaresAreAvailable();
			if (canMoveDown){
				drawPiece();
			}
			else {
				squareOne.y -= Board.SQUARE;
				retirePiece();
			}
		}
	}	
	
	protected boolean testSquaresAreAvailable() {
		setPotentialNextPositionOfPiece();
		boolean available = board.squareIsAvailable(squareOne);
		if (available) {
			available = board.squareIsAvailable(testSquareTwo);
		}
		if (available){
			available = board.squareIsAvailable(testSquareThree);
		}
		if (available){
			available = board.squareIsAvailable(testSquareFour);
		}
		return available;
	}

	


	private void retirePiece() {
		// TODO Auto-generated method stub
		
	}

	public abstract int getBottomY();
	public abstract int getLeftX();
	public abstract int getRightX();
	 
}
