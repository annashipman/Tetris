package anna.shipman.main.tetris;

//Hmm, I'm not quite getting this
public enum Rotation {
	DEGREES_0(0),
	DEGREES_90(90),
	DEGREES_180(180),
	DEGREES_270(270);

	private int degrees;

	Rotation (final int degrees){
		this.degrees = degrees;
	}
	
	public int degrees(){
		return degrees;
	}
}
