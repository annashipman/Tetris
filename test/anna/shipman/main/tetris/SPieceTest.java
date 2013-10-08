package anna.shipman.main.tetris;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.awt.Point;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SPieceTest implements TetrisPieceCommonTests {

	private Board board;
	private TetrisPiece s;

	@BeforeMethod
	public void setUp() {
		board = new Board(true);
		s = new SPiece(board);
	}

	@Test
	public void whenAt0RotationSquaresAreArrangedAsExpected() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				+ Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				- Board.SQUARE, Board.TOP + Board.SQUARE);

		assertEquals(s.squareOne, expectedSquareOne);
		assertEquals(s.squareTwo, expectedSquareTwo);
		assertEquals(s.squareThree, expectedSquareThree);
		assertEquals(s.squareFour, expectedSquareFour);
	}

	@Test
	public void rotate180IsSameAsRotate0() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				+ Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				- Board.SQUARE, Board.TOP + Board.SQUARE);

		s.rotate();
		s.rotate();

		assertEquals(s.squareOne, expectedSquareOne);
		assertEquals(s.squareTwo, expectedSquareTwo);
		assertEquals(s.squareThree, expectedSquareThree);
		assertEquals(s.squareFour, expectedSquareFour);
	}

	@Test
	public void rotate360IsSameAsRotate0() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				+ Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				- Board.SQUARE, Board.TOP + Board.SQUARE);

		s.rotate();
		s.rotate();
		s.rotate();
		s.rotate();

		assertEquals(s.squareOne, expectedSquareOne);
		assertEquals(s.squareTwo, expectedSquareTwo);
		assertEquals(s.squareThree, expectedSquareThree);
		assertEquals(s.squareFour, expectedSquareFour);
	}

	@Test
	public void whenAt90RotationSquaresAreArrangedAsExpected() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				- Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				+ Board.SQUARE, Board.TOP + Board.SQUARE);

		s.rotate();

		assertEquals(s.squareOne, expectedSquareOne);
		assertEquals(s.squareTwo, expectedSquareTwo);
		assertEquals(s.squareThree, expectedSquareThree);
		assertEquals(s.squareFour, expectedSquareFour);
	}

	@Test
	public void rotate270IsSameAsRotate90() {
		final Point expectedSquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point expectedSquareTwo = new Point(
				Board.MIDPOINT + Board.SQUARE, Board.TOP);
		final Point expectedSquareThree = new Point(Board.MIDPOINT, Board.TOP
				- Board.SQUARE);
		final Point expectedSquareFour = new Point(Board.MIDPOINT
				+ Board.SQUARE, Board.TOP + Board.SQUARE);

		s.rotate();
		s.rotate();
		s.rotate();

		assertEquals(s.squareOne, expectedSquareOne);
		assertEquals(s.squareTwo, expectedSquareTwo);
		assertEquals(s.squareThree, expectedSquareThree);
		assertEquals(s.squareFour, expectedSquareFour);
	}

	@Test
	public void whenAt0RotationBottomBoundaryIsTwoSquaresBelowSquareOne() {
		final int expectedBottomY = s.squareOne.y + Board.SQUARE + Board.SQUARE;
		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationBottomBoundaryIsTwoSquaresBelowSquareOne() {
		s.rotate();
		final int expectedBottomY = s.squareOne.y + Board.SQUARE + Board.SQUARE;
		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationLeftBoundaryIsOneSquareLeftOfSquareOne() {
		final int expectedLeftX = s.squareOne.x - Board.SQUARE;
		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);
	}

	@Test
	public void whenAt90RotationLeftBoundaryIsSameAsSquareOne() {
		s.rotate();
		final int expectedLeftX = s.squareOne.x;
		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);
	}

	@Test
	public void whenAt0RotationRightBoundaryIsTwoSquaresRightOfSquareOne() {
		final int expectedRightX = s.squareOne.x + Board.SQUARE + Board.SQUARE;
		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);
	}

	@Test
	public void whenAt90RotationRightBoundaryIsTwoSquaresRightOfSquareOne() {
		s.rotate();
		final int expectedRightX = s.squareOne.x + Board.SQUARE + Board.SQUARE;
		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);
	}

	@Test
	public void whenAt0RotationMoveLeftMovesLeftSideAndRightSideButNotDown() {
		final int expectedLeftX = s.getLeftX() - Board.SQUARE;
		final int expectedRightX = s.getRightX() - Board.SQUARE;
		final int expectedBottomY = s.getBottomY();

		s.moveLeft();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationMoveLeftMovesLeftSideAndRightSideButNotDown() {
		s.rotate();

		final int expectedLeftX = s.getLeftX() - Board.SQUARE;
		final int expectedRightX = s.getRightX() - Board.SQUARE;
		final int expectedBottomY = s.getBottomY();

		s.moveLeft();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationMoveRightMovesLeftSideAndRightSideButNotDown() {
		final int expectedLeftX = s.getLeftX() + Board.SQUARE;
		final int expectedRightX = s.getRightX() + Board.SQUARE;
		final int expectedBottomY = s.getBottomY();

		s.moveRight();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationMoveRightMovesLeftSideAndRightSideButNotDown() {
		s.rotate();

		final int expectedLeftX = s.getLeftX() + Board.SQUARE;
		final int expectedRightX = s.getRightX() + Board.SQUARE;
		final int expectedBottomY = s.getBottomY();

		s.moveRight();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationMoveDownMovesDownButNotLeftAndRight() {
		final int expectedLeftX = s.getLeftX();
		final int expectedRightX = s.getRightX();
		final int expectedBottomY = s.getBottomY() + Board.SQUARE;

		s.moveDown();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationMoveDownMovesDownButNotLeftAndRight() {
		s.rotate();

		final int expectedLeftX = s.getLeftX();
		final int expectedRightX = s.getRightX();
		final int expectedBottomY = s.getBottomY() + Board.SQUARE;

		s.moveDown();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationPieceCannotMoveFurtherLeftThanBoardLeftWall() {
		final int leftWall = 0;
		final int topLeftCorner = s.squareOne.x;
		final int numberOfMovesBeforePieceReachesLeftWall = (topLeftCorner - leftWall)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesLeftWall; counter++) {
			final int expectedLeftXAfterMove = s.getLeftX() - Board.SQUARE;
			s.moveLeft();
			assertEquals(s.getLeftX(), expectedLeftXAfterMove);
		}

		int expectedLeftX = s.getLeftX();

		s.moveLeft();
		assertEquals(s.getLeftX(), expectedLeftX);

		s.moveLeft();
		assertEquals(s.getLeftX(), expectedLeftX);
	}

	@Test
	public void whenAt90RotationPieceCannotMoveFurtherLeftThanBoardLeftWall() {
		s.rotate();

		final int leftWall = 0;
		final int topLeftCorner = s.squareOne.x;
		final int numberOfMovesBeforePieceReachesLeftWall = (topLeftCorner - leftWall)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesLeftWall; counter++) {
			final int expectedLeftXAfterMove = s.getLeftX() - Board.SQUARE;
			s.moveLeft();
			assertEquals(s.getLeftX(), expectedLeftXAfterMove);
		}

		int expectedLeftX = s.getLeftX();

		s.moveLeft();
		assertEquals(s.getLeftX(), expectedLeftX);

		s.moveLeft();
		assertEquals(s.getLeftX(), expectedLeftX);
	}

	@Test
	public void whenAt0RotationPieceCannotMoveFurtherRightThanBoardRightWall() {
		final int rightWall = Board.WIDTH;
		final int rightBoundary = s.getRightX();
		final int numberOfMovesBeforePieceReachesRightWall = (rightWall - rightBoundary)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesRightWall; counter++) {
			final int expectedRightXAfterMove = s.getRightX() + Board.SQUARE;
			s.moveRight();
			assertEquals(s.getRightX(), expectedRightXAfterMove);
		}

		int expectedRightX = s.getRightX();

		s.moveRight();
		assertEquals(s.getRightX(), expectedRightX);

		s.moveRight();
		assertEquals(s.getRightX(), expectedRightX);
	}

	@Test
	public void whenAt90RotationPieceCannotMoveFurtherRightThanBoardRightWall() {
		s.rotate();

		final int rightWall = Board.WIDTH;
		final int rightBoundary = s.getRightX();
		final int numberOfMovesBeforePieceReachesRightWall = (rightWall - rightBoundary)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesRightWall; counter++) {
			final int expectedRightXAfterMove = s.getRightX() + Board.SQUARE;
			s.moveRight();
			assertEquals(s.getRightX(), expectedRightXAfterMove);
		}

		int expectedRightX = s.getRightX();

		s.moveRight();
		assertEquals(s.getRightX(), expectedRightX);

		s.moveRight();
		assertEquals(s.getRightX(), expectedRightX);
	}

	@Test
	public void whenAt0RotationPieceCannotMoveBelowBoardBottomWall() {
		final int bottomWall = Board.HEIGHT;
		final int bottomOfPiece = s.getBottomY();
		final int numberOfMovesBeforePieceReachesBottom = (bottomWall - bottomOfPiece)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesBottom; counter++) {
			final int expectedBottomAfterMove = s.getBottomY() + Board.SQUARE;
			s.moveDown();
			assertEquals(s.getBottomY(), expectedBottomAfterMove);
		}

		int expectedBottom = s.getBottomY();

		s.moveDown();
		assertEquals(s.getBottomY(), expectedBottom);

		s.moveDown();
		assertEquals(s.getBottomY(), expectedBottom);
	}

	@Test
	public void whenAt90RotationPieceCannotMoveBelowBoardBottomWall() {
		s.rotate();

		final int bottomWall = Board.HEIGHT;
		final int bottomOfPiece = s.getBottomY();
		final int numberOfMovesBeforePieceReachesBottom = (bottomWall - bottomOfPiece)
				/ Board.SQUARE;

		for (int counter = 0; counter < numberOfMovesBeforePieceReachesBottom; counter++) {
			final int expectedBottomAfterMove = s.getBottomY() + Board.SQUARE;
			s.moveDown();
			assertEquals(s.getBottomY(), expectedBottomAfterMove);
		}

		int expectedBottom = s.getBottomY();

		s.moveDown();
		assertEquals(s.getBottomY(), expectedBottom);

		s.moveDown();
		assertEquals(s.getBottomY(), expectedBottom);
	}

	@Test
	public void whenAt0RotationAndThereAreNoPiecesToLeftPieceCanMoveLeft() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		board.addRestingPiece(restingPiece);
		
		final int expectedLeftX = s.getLeftX() - Board.SQUARE;
		final int expectedRightX = s.getRightX() - Board.SQUARE;
		final int expectedBottomY = s.getBottomY();

		s.moveLeft();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationAndThereAreNoPiecesToLeftPieceCanMoveLeft() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.rotate();
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		board.addRestingPiece(restingPiece);

		s.rotate();
		
		final int expectedLeftX = s.getLeftX() - Board.SQUARE;
		final int expectedRightX = s.getRightX() - Board.SQUARE;
		final int expectedBottomY = s.getBottomY();

		s.moveLeft();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationAndThereArePiecesToLeftPieceCannotMoveLeft() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		board.addRestingPiece(restingPiece);

		final int expectedLeftX = s.getLeftX();
		final int expectedRightX = s.getRightX();
		final int expectedBottomY = s.getBottomY();

		s.moveLeft();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationAndThereArePiecesToLeftPieceCannotMoveLeft() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.rotate();
		restingPiece.moveLeft();
		restingPiece.moveLeft();
		board.addRestingPiece(restingPiece);

		s.rotate();

		final int expectedLeftX = s.getLeftX();
		final int expectedRightX = s.getRightX();
		final int expectedBottomY = s.getBottomY();

		s.moveLeft();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationAndThereAreNoPiecesToRightPieceCanMoveRight() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.moveRight();
		restingPiece.moveRight();
		restingPiece.moveRight();
		board.addRestingPiece(restingPiece);
		
		final int expectedLeftX = s.getLeftX() + Board.SQUARE;
		final int expectedRightX = s.getRightX() + Board.SQUARE;
		final int expectedBottomY = s.getBottomY();

		s.moveRight();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationAndThereAreNoPiecesToRightPieceCanMoveRight() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.rotate();
		restingPiece.moveRight();
		restingPiece.moveRight();
		restingPiece.moveRight();
		board.addRestingPiece(restingPiece);

		s.rotate();

		final int expectedLeftX = s.getLeftX() + Board.SQUARE;
		final int expectedRightX = s.getRightX() + Board.SQUARE;
		final int expectedBottomY = s.getBottomY();

		s.moveRight();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationAndThereArePiecesToRightPieceCannotMoveRight() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.moveRight();
		restingPiece.moveRight();
		board.addRestingPiece(restingPiece);

		final int expectedLeftX = s.getLeftX();
		final int expectedRightX = s.getRightX();
		final int expectedBottomY = s.getBottomY();

		s.moveRight();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationAndThereArePiecesToRightPieceCannotMoveRight() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.moveRight();
		restingPiece.moveRight();
		board.addRestingPiece(restingPiece);

		s.rotate();

		final int expectedLeftX = s.getLeftX();
		final int expectedRightX = s.getRightX();
		final int expectedBottomY = s.getBottomY();

		s.moveRight();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt0RotationPieceCannotMoveBelowTopRestingPiece() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.moveDown();
		restingPiece.moveDown();
		board.addRestingPiece(restingPiece);

		final int expectedLeftX = s.getLeftX();
		final int expectedRightX = s.getRightX();
		final int expectedBottomY = s.getBottomY();

		s.moveDown();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}

	@Test
	public void whenAt90RotationPieceCannotMoveBelowTopRestingPiece() {
		final SPiece restingPiece = new SPiece(board);
		restingPiece.moveDown();
		restingPiece.moveDown();
		board.addRestingPiece(restingPiece);

		s.rotate();

		final int expectedLeftX = s.getLeftX();
		final int expectedRightX = s.getRightX();
		final int expectedBottomY = s.getBottomY();

		s.moveDown();

		final int actualLeftX = s.getLeftX();
		assertEquals(actualLeftX, expectedLeftX);

		final int actualRightX = s.getRightX();
		assertEquals(actualRightX, expectedRightX);

		final int actualBottomY = s.getBottomY();
		assertEquals(actualBottomY, expectedBottomY);
	}
	
	@Test
	public void pieceCannotBeManifestedOnTopOfAnotherPiece(){
		fail("this is actually game end, so how will this work?");
		//move to interface as well
	} 

	/*
	 * @Test public void whenAt0RotationWhenPieceHasHitBottomItCannotBeMoved() {
	 * fail("Actually I'm not sure what the implementation should be here"); }
	 * 
	 * @Test public void whenAt90RotationWhenPieceHasHitBottomItCannotBeMoved()
	 * { fail("Actually I'm not sure what the implementation should be here"); }
	 * 
	 * @Test public void
	 * whenPieceHasHitTopRestingPieceItCannotBeMoved0Rotation() {
	 * fail("Actually I'm not sure what the implementation should be here"); }
	 * 
	 * @Test public void
	 * whenPieceHasHitTopRestingPieceItCannotBeMoved90Rotation() {
	 * fail("Actually I'm not sure what the implementation should be here"); }
	 * 
	 * @Test public void andOfCourseTheresTheWholeSlottingInToConsider() {
	 * fail("No idea how that's going to work yet"); }
	 * 
	 * @Test public void whenAPieceCanNoLongerBeMovedItIsRetired(){
	 * fail("Not yet implemented"); //although maybe this is in board's
	 * respsonsiblity }
	 */

}
