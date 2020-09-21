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
		System.out.println("START");
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
							System.out.println(hh + ":" + mm + ":" + ss);
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
		if (isRunning())
			running = false;
		System.out.println("PAUSED");
	}

	/**
	 * Resets the clock.
	 */
	public void reset() {
		if (isRunning())
			pause();
		ticks = 0;
		System.out.println("RESET");
	}

	/**
	 * Tells if clock is running.
	 * 
	 * @return {@code true} if running {@code false} otherwise
	 */
	public boolean isRunning() {
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
