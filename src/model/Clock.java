package model;

import java.util.Timer;

/**
 * This class contains the Clock that will later be used as a part of the chess
 * clock.
 * 
 * @author larkala
 * @version 2020-09-20
 */

public class Clock {

	private int ticks, hh, mm, ss;
	private boolean running;

	public Clock() {
		ticks = hh = mm = ss = 0;
		running = false;
	}

	/**
	 * Makes the clock "tick" once. Adds a second to the total seconds and updates
	 * the hours, minutes and seconds relative to total ticks.
	 * 
	 */
	private void tick() {
		ticks++;
	}

	/**
	 * Starts the clock.
	 * 
	 */
	public void start() {
		running = true;
		Thread t = new Thread() {

			public void run() {
				
				while (true) {
				
					if (isRunning()) {
					
						try {
							tick();
							sleep(1000);
							hh = ticks / 3600;
							mm = (ticks % 3600) / 60;
							ss = ticks % 60;
						} catch (Exception e) {
							
						}
					} else {
						break;
					}
				}
			}
		};
		t.start(); 
	}

	/**
	 * Pauses the clock.
	 */
	public void pause() {
	running = false;
	}

	/**
	 * Resets the clock.
	 */
	public void reset() {
		pause();
		ticks = hh = mm = ss = 0;
	}

	/**
	 * Tells if clock is running.
	 * 
	 * @return {@code true} if running {@code false} otherwise
	 */
	private boolean isRunning() {
		return running;
	}

	/**
	 * Returns the time passed as an integer array.
	 * 
	 * @return list of hours, minutes & seconds of this clock
	 */
	public int[] getTime() {
		int[] time = { hh, mm, ss };
		return time;
	}
}
