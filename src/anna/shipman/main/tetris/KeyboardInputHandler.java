package anna.shipman.main.tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInputHandler extends KeyAdapter {

	@Override
	public void keyPressed(final KeyEvent keyEvent) {
		final int key = keyEvent.getKeyCode();
		getMove(key);
	}

	public String getMove(int key) {
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT
				|| key == KeyEvent.VK_DOWN) {
			final String keyString = KeyEvent.getKeyText(key);
			return keyString;
		} else
			return "";
	}
}
