package model;

/**
 * This class combines two {@link Clock} objects and adjusts them accordingly
 * how two clocks work with each other on a chess clock.
 * 
 * @author larkala
 * @version 2020-09-25
 */
public class ChessClock {
	boolean whiteRunning, blackRunning = false;
	boolean reset = true;
	Clock white, black;
	int[] timeWhite, timeBlack;

	/**
	 * Constructs a ChessClock.
	 */
	public ChessClock() {
		white = new Clock();
		black = new Clock();
	}

	/**
	 * Switches the turn of the players by pausing the active clock and starting the
	 * inactive clock.
	 */
	public void switchTurns() {
		
		if (!reset) {
			if (whiteIsRunning()) {
				white.pause();
				whiteRunning = false;
				black.start();
				blackRunning = true;
			}
			else if (blackIsRunning()) {
				black.pause();
				blackRunning = false;
				white.start();
				whiteRunning = true;
			} 
			
		}
		else if (reset){
			reset = false;
			white.start();
			whiteRunning = true;
		}
	}

	/**
	 * Resets both clocks.
	 */
	public void resetClocks() {
		white.reset();    
		black.reset();    
		whiteRunning = false;
		blackRunning = false;
		reset = true;
	}

	/**
	 * Returns the time of the white clock.
	 * 
	 * @return integer list of hours, minutes & seconds of the white clock
	 */
	public int[] getWhiteTime() {
		return white.getTime();
	}

	/**
	 * Returns the time of the black clock.
	 * 
	 * @return integer list of hours, minutes & seconds of the black clock
	 */
	public int[] getBlackTime() {
		return black.getTime();
	}

	/**
	 * Returns if white clock is running.
	 * 
	 * @return {@code true} if clock is running, {@code false}
	 */
	public boolean whiteIsRunning() {
		return whiteRunning;
	}

	/**
	 * Returns if black clock is running.
	 * 
	 * @return {@code true} if clock is running, {@code false}
	 */
	public boolean blackIsRunning() {
		return blackRunning;
	}
}
