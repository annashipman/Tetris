package anna.shipman.main.tetris;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.awt.Point;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OPieceTest implements TetrisPieceCommonTests {

	private Board board;
	private TetrisPiece o;

	@BeforeMethod
	public void setUp() {
		board = new Board(true);
		o = new OPiece(board);
	}

	@Test
	public void whenAt0RotationSquaresAreArrangedAsExpected() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				+ Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				+ Board.SQUARE, Board.TOP + Board.SQUARE);

		assertEquals(o.squareOne, expectedSquareOne);
		assertEquals(o.squareTwo, expectedSquareTwo);
		assertEquals(o.squareThree, expectedSquareThree);
		assertEquals(o.squareFour, expectedSquareFour);
	}

	@Test
	public void rotate90IsSameAsRotate0() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				+ Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				+ Board.SQUARE, Board.TOP + Board.SQUARE);

		o.rotate();

		assertEquals(o.squareOne, expectedSquareOne);
		assertEquals(o.squareTwo, expectedSquareTwo);
		assertEquals(o.squareThree, expectedSquareThree);
		assertEquals(o.squareFour, expectedSquareFour);
	}

	@Test
	public void rotate180IsSameAsRotate0() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				+ Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				+ Board.SQUARE, Board.TOP + Board.SQUARE);

		o.rotate();
		o.rotate();

		assertEquals(o.squareOne, expectedSquareOne);
		assertEquals(o.squareTwo, expectedSquareTwo);
		assertEquals(o.squareThree, expectedSquareThree);
		assertEquals(o.squareFour, expectedSquareFour);
	}

	@Test
	public void rotate270IsSameAsRotate0() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				+ Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				+ Board.SQUARE, Board.TOP + Board.SQUARE);

		o.rotate();
		o.rotate();
		o.rotate();

		assertEquals(o.squareOne, expectedSquareOne);
		assertEquals(o.squareTwo, expectedSquareTwo);
		assertEquals(o.squareThree, expectedSquareThree);
		assertEquals(o.squareFour, expectedSquareFour);
	}

	@Test
	public void rotate360IsSameAsRotate0() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				+ Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				+ Board.SQUARE, Board.TOP + Board.SQUARE);

		o.rotate();
		o.rotate();
		o.rotate();
		o.rotate();

		assertEquals(o.squareOne, expectedSquareOne);
		assertEquals(o.squareTwo, expectedSquareTwo);
		assertEquals(o.squareThree, expectedSquareThree);
		assertEquals(o.squareFour, expectedSquareFour);
	}

	@Test
	public void bottomBoundaryIsTwoSquaresBelowTopLeftCorner() {
		final Point squareOne = o.squareOne;
		final int expectedBottomY = squareOne.y + Board.SQUARE + Board.SQUARE;
		final int actualBottomY = o.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void leftBoundaryIsSameAsTopLeftCorner() {
		final Point squareOne = o.squareOne;
		final int expectedLeftX = squareOne.x;
		final int actualLeftX = o.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);
	}

	@Test
	public void rightBoundaryIsTwoSquaresToRightOfTopLeftCorner() {
		final Point squareOne = o.squareOne;
		final int expectedRightX = squareOne.x + Board.SQUARE + Board.SQUARE;
		final int actualRightX = o.getRightX();
		assertEquals(actualRightX, expectedRightX);
	}

	@Test
	public void whenAt0RotationMoveLeftMovesLeftSideAndRightSideButNotDown() {
		final int initialLeftX = o.getLeftX();
		final int initialRightX = o.getRightX();
		final int initialBottomY = o.getBottomY();

		o.moveLeft();

		final int expectedLeftX = initialLeftX - Board.SQUARE;
		final int actualLeftX = o.getLeftX();

		assertEquals(actualLeftX, expectedLeftX);

		final int expectedRightX = initialRightX - Board.SQUARE;
		final int actualRightX = o.getRightX();

		assertEquals(actualRightX, expectedRightX);

		final int expectedBottomY = initialBottomY;
		final int actualBottomY = o.getBottomY();

		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationMoveRightMovesLeftSideAndRightSideButNotDown() {
		final int initialLeftX = o.getLeftX();
		final int initialRightX = o.getRightX();
		final int initialBottomY = o.getBottomY();

		o.moveRight();

		final int expectedLeftX = initialLeftX + Board.SQUARE;
		final int actualLeftX = o.getLeftX();

		assertEquals(actualLeftX, expectedLeftX);

		final int expectedRightX = initialRightX + Board.SQUARE;
		final int actualRightX = o.getRightX();

		assertEquals(actualRightX, expectedRightX);

		final int expectedBottomY = initialBottomY;
		final int actualBottomY = o.getBottomY();

		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationMoveDownMovesDownButNotLeftAndRight() {
		final int initialLeftX = o.getLeftX();
		final int initialRightX = o.getRightX();
		final int initialBottomY = o.getBottomY();

		o.moveDown();

		final int expectedLeftX = initialLeftX;
		final int actualLeftX = o.getLeftX();

		assertEquals(actualLeftX, expectedLeftX);

		final int expectedRightX = initialRightX;
		final int actualRightX = o.getRightX();

		assertEquals(actualRightX, expectedRightX);

		final int expectedBottomY = initialBottomY + Board.SQUARE;
		final int actualBottomY = o.getBottomY();

		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationPieceCannotMoveFurtherLeftThanBoardLeftWall() {
		final int leftWall = 0;
		final int topLeftCorner = o.squareOne.x;
		final int numberOfMovesBeforePieceReachesLeftWall = (topLeftCorner - leftWall)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesLeftWall; counter++) {
			final int expectedLeftXAfterMove = o.getLeftX() - Board.SQUARE;
			o.moveLeft();
			assertEquals(o.getLeftX(), expectedLeftXAfterMove);
		}

		int expectedLeftX = o.getLeftX();

		o.moveLeft();
		assertEquals(o.getLeftX(), expectedLeftX);

		o.moveLeft();
		assertEquals(o.getLeftX(), expectedLeftX);
	}

	@Test
	public void whenAt0RotationPieceCannotMoveFurtherRightThanBoardRightWall() {
		final int rightWall = Board.WIDTH;
		final int rightBoundary = o.getRightX();
		final int numberOfMovesBeforePieceReachesRightWall = (rightWall - rightBoundary)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesRightWall; counter++) {
			final int expectedRightXAfterMove = o.getRightX() + Board.SQUARE;
			o.moveRight();
			assertEquals(o.getRightX(), expectedRightXAfterMove);
		}

		int expectedRightX = o.getRightX();

		o.moveRight();
		assertEquals(o.getRightX(), expectedRightX);

		o.moveRight();
		assertEquals(o.getRightX(), expectedRightX);
	}

	@Test
	public void whenAt0RotationPieceCannotMoveBelowBoardBottomWall() {
		final int bottomWall = Board.HEIGHT;
		final int bottomOfPiece = o.getBottomY();
		final int numberOfMovesBeforePieceReachesBottom = (bottomWall - bottomOfPiece)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesBottom; counter++) {
			final int expectedBottomAfterMove = o.getBottomY() + Board.SQUARE;
			o.moveDown();
			assertEquals(o.getBottomY(), expectedBottomAfterMove);
		}

		int expectedBottom = o.getBottomY();

		o.moveDown();
		assertEquals(o.getBottomY(), expectedBottom);

		o.moveDown();
		assertEquals(o.getBottomY(), expectedBottom);
	}

	@Test
	public void whenAt0RotationAndThereAreNoPiecesToLeftPieceCanMoveLeft() {
		final OPiece restingPiece = new OPiece(board);
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		board.addRestingPiece(restingPiece);

		final int expectedLeftX = o.getLeftX() - Board.SQUARE;
		final int expectedRightX = o.getRightX() - Board.SQUARE;
		final int expectedBottomY = o.getBottomY();

		o.moveLeft();

		final int actualLeftX = o.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = o.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = o.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationAndThereArePiecesToLeftPieceCannotMoveLeft() {
		final OPiece restingPiece = new OPiece(board);
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		board.addRestingPiece(restingPiece);

		final int expectedLeftX = o.getLeftX();
		final int expectedRightX = o.getRightX();
		final int expectedBottomY = o.getBottomY();

		o.moveLeft();

		final int actualLeftX = o.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = o.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = o.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationAndThereAreNoPiecesToRightPieceCanMoveRight() {
		final OPiece restingPiece = new OPiece(board);
		restingPiece.moveRight();
		restingPiece.moveRight();
		restingPiece.moveRight();
		board.addRestingPiece(restingPiece);

		final int expectedLeftX = o.getLeftX() + Board.SQUARE;
		final int expectedRightX = o.getRightX() + Board.SQUARE;
		final int expectedBottomY = o.getBottomY();

		o.moveRight();

		final int actualLeftX = o.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = o.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = o.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationAndThereArePiecesToRightPieceCannotMoveRight() {
		final OPiece restingPiece = new OPiece(board);
		restingPiece.moveRight();
		restingPiece.moveRight();
		board.addRestingPiece(restingPiece);

		final int expectedLeftX = o.getLeftX();
		final int expectedRightX = o.getRightX();
		final int expectedBottomY = o.getBottomY();

		o.moveRight();

		final int actualLeftX = o.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = o.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = o.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationPieceCannotMoveBelowTopRestingPiece() {
		final OPiece restingPiece = new OPiece(board);
		restingPiece.moveDown();
		restingPiece.moveDown();
		board.addRestingPiece(restingPiece);
		
		final int expectedLeftX = o.getLeftX();
		final int expectedRightX = o.getRightX();
		final int expectedBottomY = o.getBottomY();

		o.moveDown();

		final int actualLeftX = o.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = o.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = o.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void pieceShouldNotBeAbleToBeCreatedWhenTheresOneInTheWay(){
		fail("they currently can");
	}
}
