package anna.shipman.main.tetris;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.awt.Point;

import org.testng.annotations.Test;

public class BoardTest {

	@Test
	public void boardKeepsARecordOfWhichSquaresAreOccupied() {
		final Board board = new Board(true);
		final OPiece o = new OPiece(board);
		o.moveDown();
		o.moveDown();

		final Point testSquareOne = new Point(o.squareOne.x, o.squareOne.y);
		final Point testSquareTwo = new Point(o.squareTwo.x, o.squareTwo.y);
		final Point testSquareThree = new Point(o.squareThree.x,
				o.squareThree.y);
		final Point testSquareFour = new Point(o.squareFour.x, o.squareFour.y);

		final Point testEmptySquareOne = new Point(Board.MIDPOINT, Board.TOP);
		final Point testEmptySquareTwo = new Point(Board.MIDPOINT
				+ Board.SQUARE, Board.TOP);
		final Point testEmptySquareThree = new Point(Board.MIDPOINT
				- Board.SQUARE, Board.TOP);

		board.addRestingPiece(o);

		assertTrue(board.squareIsAvailable(testEmptySquareOne));
		assertTrue(board.squareIsAvailable(testEmptySquareTwo));
		assertTrue(board.squareIsAvailable(testEmptySquareThree));

		assertFalse(board.squareIsAvailable(testSquareOne));
		assertFalse(board.squareIsAvailable(testSquareTwo));
		assertFalse(board.squareIsAvailable(testSquareThree));
		assertFalse(board.squareIsAvailable(testSquareFour));
	}

	// have board keep a record of the colour of the pieces!

	@Test
	public void whenARowIsFilledBoardRemovesIt() {
		final Board board = new Board(true);
		// note, this test will fail when board width changes...

		// fill board
		final OPiece o1 = new OPiece(board);
		final OPiece o2 = new OPiece(board);
		final OPiece o3 = new OPiece(board);
		final OPiece o4 = new OPiece(board);
		final OPiece o5 = new OPiece(board);

		movePieceLeftAndAddToRestingPieces(o1, board);
		movePieceLeftAndAddToRestingPieces(o2, board);
		movePieceRightAndAddToRestingPieces(o3, board);
		movePieceRightAndAddToRestingPieces(o4, board);

		//TODO 
		
//		ahah! I't's not really testing that row is full
		//reuse "middle row nearly full" method
		final Point samplePoint1 = new Point(o1.squareOne.x, o1.squareOne.y);
		final Point samplePoint2 = new Point(o2.squareOne.x, o2.squareOne.y);
		final Point samplePoint3 = new Point(o3.squareOne.x, o3.squareOne.y);
		final Point samplePoint4 = new Point(o4.squareOne.x, o4.squareOne.y);

		final Point samplePoint5 = new Point(Board.MIDPOINT, Board.TOP);

		assertFalse(board.squareIsAvailable(samplePoint1));
		assertFalse(board.squareIsAvailable(samplePoint2));
		assertFalse(board.squareIsAvailable(samplePoint3));
		assertFalse(board.squareIsAvailable(samplePoint4));

		assertTrue(board.squareIsAvailable(samplePoint5));

		// this is the final piece slotting in and should trigger the deleting
		// of the two rows
		board.addRestingPiece(o5);

		assertTrue(board.squareIsAvailable(samplePoint1));
		assertTrue(board.squareIsAvailable(samplePoint2));
		assertTrue(board.squareIsAvailable(samplePoint3));
		assertTrue(board.squareIsAvailable(samplePoint4));
		assertTrue(board.squareIsAvailable(samplePoint5));
	}

	@Test
	public void removingARowMovesRowAboveDown() {
		final Board board = new Board(true);

		// in future these should not be allowed to manifest on top of each
		// other!!
		final SPiece s1 = new SPiece(board);
		final SPiece s2 = new SPiece(board);
		final SPiece s3 = new SPiece(board);
		final SPiece s4 = new SPiece(board);
		final SPiece s5 = new SPiece(board);

		rotatePieceAndMoveDownAndLeft(s1, board);
		rotatePieceAndMoveDownAndLeft(s2, board);
		rotatePieceAndMoveDownAndRight(s3, board);
		rotatePieceAndMoveDownAndRight(s4, board);

		// before last piece drops in, is it in state we expect?
		checkTopRowIsAlternatingAvailabilityExceptMiddleStartingWithFullLeft(board);
		checkMiddleRowIsCompletelyFullExceptMiddle(board);
		checkBottomRowIsAlternatingAvailabilityExceptMiddleStartingWithEmptyLeft(board);

		// drop it in
		s5.rotate();
		board.addRestingPiece(s5);

		checkTopRowIsAllAvailable(board);
		checkMiddleRowIsAlternatingAvailabilityStartingWithFullLeft(board);
		checkBottomRowIsAlternatingAvailabilityStartingWithEmptyLeft(board);
	}

	private void checkBottomRowIsAlternatingAvailabilityStartingWithEmptyLeft(
			Board board) {
		assertTrue(board.squareIsAvailable(new Point(0, 20)));
		assertFalse(board.squareIsAvailable(new Point(10, 20)));
		assertTrue(board.squareIsAvailable(new Point(20, 20)));
		assertFalse(board.squareIsAvailable(new Point(30, 20)));
		assertTrue(board.squareIsAvailable(new Point(40, 20)));
		assertFalse(board.squareIsAvailable(new Point(50, 20)));
		assertTrue(board.squareIsAvailable(new Point(60, 20)));
		assertFalse(board.squareIsAvailable(new Point(70, 20)));
		assertTrue(board.squareIsAvailable(new Point(80, 20)));
		assertFalse(board.squareIsAvailable(new Point(90, 20)));
		assertTrue(board.squareIsAvailable(new Point(100, 20)));
		assertFalse(board.squareIsAvailable(new Point(110, 20)));
		assertTrue(board.squareIsAvailable(new Point(120, 20)));
		assertFalse(board.squareIsAvailable(new Point(130, 20)));
		assertTrue(board.squareIsAvailable(new Point(140, 20)));
		assertFalse(board.squareIsAvailable(new Point(150, 20)));
		assertTrue(board.squareIsAvailable(new Point(160, 20)));
		assertFalse(board.squareIsAvailable(new Point(170, 20)));
		assertTrue(board.squareIsAvailable(new Point(180, 20)));
		assertFalse(board.squareIsAvailable(new Point(190, 20)));
	}

	private void checkMiddleRowIsAlternatingAvailabilityStartingWithFullLeft(
			Board board) {
		assertFalse(board.squareIsAvailable(new Point(0, 10)));
		assertTrue(board.squareIsAvailable(new Point(10, 10)));
		assertFalse(board.squareIsAvailable(new Point(20, 10)));
		assertTrue(board.squareIsAvailable(new Point(30, 10)));
		assertFalse(board.squareIsAvailable(new Point(40, 10)));
		assertTrue(board.squareIsAvailable(new Point(50, 10)));
		assertFalse(board.squareIsAvailable(new Point(60, 10)));
		assertTrue(board.squareIsAvailable(new Point(70, 10)));
		assertFalse(board.squareIsAvailable(new Point(80, 10)));
		assertTrue(board.squareIsAvailable(new Point(90, 10)));
		assertFalse(board.squareIsAvailable(new Point(100, 10)));
		assertTrue(board.squareIsAvailable(new Point(110, 10)));
		assertFalse(board.squareIsAvailable(new Point(120, 10)));
		assertTrue(board.squareIsAvailable(new Point(130, 10)));
		assertFalse(board.squareIsAvailable(new Point(140, 10)));
		assertTrue(board.squareIsAvailable(new Point(150, 10)));
		assertFalse(board.squareIsAvailable(new Point(160, 10)));
		assertTrue(board.squareIsAvailable(new Point(170, 10)));
		assertFalse(board.squareIsAvailable(new Point(180, 10)));
		assertTrue(board.squareIsAvailable(new Point(190, 10)));
	}

	private void checkTopRowIsAllAvailable(Board board) {
		assertTrue(board.squareIsAvailable(new Point(0, 0)));
		assertTrue(board.squareIsAvailable(new Point(10, 0)));
		assertTrue(board.squareIsAvailable(new Point(20, 0)));
		assertTrue(board.squareIsAvailable(new Point(30, 0)));
		assertTrue(board.squareIsAvailable(new Point(40, 0)));
		assertTrue(board.squareIsAvailable(new Point(50, 0)));
		assertTrue(board.squareIsAvailable(new Point(60, 0)));
		assertTrue(board.squareIsAvailable(new Point(70, 0)));
		assertTrue(board.squareIsAvailable(new Point(80, 0)));
		assertTrue(board.squareIsAvailable(new Point(90, 0)));
		assertTrue(board.squareIsAvailable(new Point(100, 0)));
		assertTrue(board.squareIsAvailable(new Point(110, 0)));
		assertTrue(board.squareIsAvailable(new Point(120, 0)));
		assertTrue(board.squareIsAvailable(new Point(130, 0)));
		assertTrue(board.squareIsAvailable(new Point(140, 0)));
		assertTrue(board.squareIsAvailable(new Point(150, 0)));
		assertTrue(board.squareIsAvailable(new Point(160, 0)));
		assertTrue(board.squareIsAvailable(new Point(170, 0)));
		assertTrue(board.squareIsAvailable(new Point(180, 0)));
		assertTrue(board.squareIsAvailable(new Point(190, 0)));
	}

	private void checkBottomRowIsAlternatingAvailabilityExceptMiddleStartingWithEmptyLeft(
			Board board) {
		assertTrue(board.squareIsAvailable(new Point(0, 20)));
		assertFalse(board.squareIsAvailable(new Point(10, 20)));
		assertTrue(board.squareIsAvailable(new Point(20, 20)));
		assertFalse(board.squareIsAvailable(new Point(30, 20)));
		assertTrue(board.squareIsAvailable(new Point(40, 20)));
		assertFalse(board.squareIsAvailable(new Point(50, 20)));
		assertTrue(board.squareIsAvailable(new Point(60, 20)));
		assertFalse(board.squareIsAvailable(new Point(70, 20)));
		assertTrue(board.squareIsAvailable(new Point(80, 20)));
		assertFalse(board.squareIsAvailable(new Point(90, 20)));

		// midpoint is empty
		assertTrue(board.squareIsAvailable(new Point(100, 20)));
		assertTrue(board.squareIsAvailable(new Point(110, 20)));

		assertTrue(board.squareIsAvailable(new Point(120, 20)));
		assertFalse(board.squareIsAvailable(new Point(130, 20)));
		assertTrue(board.squareIsAvailable(new Point(140, 20)));
		assertFalse(board.squareIsAvailable(new Point(150, 20)));
		assertTrue(board.squareIsAvailable(new Point(160, 20)));
		assertFalse(board.squareIsAvailable(new Point(170, 20)));
		assertTrue(board.squareIsAvailable(new Point(180, 20)));
		assertFalse(board.squareIsAvailable(new Point(190, 20)));
	}

	private void checkMiddleRowIsCompletelyFullExceptMiddle(Board board) {
		assertFalse(board.squareIsAvailable(new Point(0, 10)));
		assertFalse(board.squareIsAvailable(new Point(10, 10)));
		assertFalse(board.squareIsAvailable(new Point(20, 10)));
		assertFalse(board.squareIsAvailable(new Point(30, 10)));
		assertFalse(board.squareIsAvailable(new Point(40, 10)));
		assertFalse(board.squareIsAvailable(new Point(50, 10)));
		assertFalse(board.squareIsAvailable(new Point(60, 10)));
		assertFalse(board.squareIsAvailable(new Point(70, 10)));
		assertFalse(board.squareIsAvailable(new Point(80, 10)));
		assertFalse(board.squareIsAvailable(new Point(90, 10)));

		// midpoint is empty
		assertTrue(board.squareIsAvailable(new Point(100, 10)));
		assertTrue(board.squareIsAvailable(new Point(110, 10)));

		assertFalse(board.squareIsAvailable(new Point(120, 10)));
		assertFalse(board.squareIsAvailable(new Point(130, 10)));
		assertFalse(board.squareIsAvailable(new Point(140, 10)));
		assertFalse(board.squareIsAvailable(new Point(150, 10)));
		assertFalse(board.squareIsAvailable(new Point(160, 10)));
		assertFalse(board.squareIsAvailable(new Point(170, 10)));
		assertFalse(board.squareIsAvailable(new Point(180, 10)));
		assertFalse(board.squareIsAvailable(new Point(190, 10)));
	}

	private void checkTopRowIsAlternatingAvailabilityExceptMiddleStartingWithFullLeft(
			Board board) {
		assertFalse(board.squareIsAvailable(new Point(0, 0)));
		assertTrue(board.squareIsAvailable(new Point(10, 0)));
		assertFalse(board.squareIsAvailable(new Point(20, 0)));
		assertTrue(board.squareIsAvailable(new Point(30, 0)));
		assertFalse(board.squareIsAvailable(new Point(40, 0)));
		assertTrue(board.squareIsAvailable(new Point(50, 0)));
		assertFalse(board.squareIsAvailable(new Point(60, 0)));
		assertTrue(board.squareIsAvailable(new Point(70, 0)));
		assertFalse(board.squareIsAvailable(new Point(80, 0)));
		assertTrue(board.squareIsAvailable(new Point(90, 0)));

		// midpoint is empty
		assertTrue(board.squareIsAvailable(new Point(100, 0)));
		assertTrue(board.squareIsAvailable(new Point(110, 0)));

		assertFalse(board.squareIsAvailable(new Point(120, 0)));
		assertTrue(board.squareIsAvailable(new Point(130, 0)));
		assertFalse(board.squareIsAvailable(new Point(140, 0)));
		assertTrue(board.squareIsAvailable(new Point(150, 0)));
		assertFalse(board.squareIsAvailable(new Point(160, 0)));
		assertTrue(board.squareIsAvailable(new Point(170, 0)));
		assertFalse(board.squareIsAvailable(new Point(180, 0)));
		assertTrue(board.squareIsAvailable(new Point(190, 0)));
	}

	private void rotatePieceAndMoveDownAndRight(TetrisPiece piece, Board board) {
		piece.rotate();
		piece.moveDown();
		movePieceRightAndAddToRestingPieces(piece, board);
	}

	private void rotatePieceAndMoveDownAndLeft(TetrisPiece piece, Board board) {
		piece.rotate();
		piece.moveDown();
		movePieceLeftAndAddToRestingPieces(piece, board);
	}

	@Test
	public void removingARowMovesAllRowsAboveDown() {
		fail("not yet implemented");
	}

	@Test
	public void whenPieceCompletesMoreThanOneRowAllAffectedRowsAreRemoved() {
		fail("not yet implemented");
	}

	private void movePieceRightAndAddToRestingPieces(final TetrisPiece piece,
			Board board) {
		piece.moveRight();
		piece.moveRight();
		piece.moveRight();
		piece.moveRight();
		board.addRestingPiece(piece);
	}

	private void movePieceLeftAndAddToRestingPieces(final TetrisPiece piece,
			Board board) {
		piece.moveLeft();
		piece.moveLeft();
		piece.moveLeft();
		piece.moveLeft(); 
		piece.moveLeft(); //theoretically it should stop here
		//but is it ok to depend on that?
		board.addRestingPiece(piece);
	}
}