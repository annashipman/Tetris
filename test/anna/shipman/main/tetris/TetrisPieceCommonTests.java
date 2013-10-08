package anna.shipman.main.tetris;

public interface TetrisPieceCommonTests {

	public void whenAt0RotationSquaresAreArrangedAsExpected();
	public void whenAt0RotationMoveLeftMovesLeftSideAndRightSideButNotDown();
	public void whenAt0RotationMoveRightMovesLeftSideAndRightSideButNotDown();
	public void whenAt0RotationMoveDownMovesDownButNotLeftAndRight();
	public void whenAt0RotationPieceCannotMoveFurtherLeftThanBoardLeftWall();
	public void whenAt0RotationPieceCannotMoveFurtherRightThanBoardRightWall();
	public void whenAt0RotationPieceCannotMoveBelowBoardBottomWall();
	public void whenAt0RotationAndThereAreNoPiecesToLeftPieceCanMoveLeft();
	public void whenAt0RotationAndThereArePiecesToLeftPieceCannotMoveLeft();
	public void whenAt0RotationAndThereAreNoPiecesToRightPieceCanMoveRight();
	public void whenAt0RotationAndThereArePiecesToRightPieceCannotMoveRight();
	public void whenAt0RotationPieceCannotMoveBelowTopRestingPiece();
	
}
