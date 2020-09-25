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
	 * Starts the clock if both states of the clock are inactive. Throws a
	 * {@link ChessClockException} otherwise
	 */
	public void startClock() {
		if (reset & !(whiteRunning || blackRunning)) {
			reset = false;
			white.start();
		} else
			throw new ChessClockException("Can't start a running clock!");
	}

	/**
	 * Resets both clocks. Throws a {@link ChessClockException} if any player's
	 * clock is running.
	 */
	public void ResetClocks() {
		if (!(whiteRunning || blackRunning))
			throw new ChessClockException("Stop clock before resetting it");
		else {
			white.reset();
			black.reset();
			reset = true;
		}
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
}