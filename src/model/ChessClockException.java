package model;

/**
 * An exception class that extends the {@link RuntimeException} java class and
 * that is created whenever a problem with the {@link ChessClock} occurs.
 * 
 * @author larkala
 * @version 2020-09-25
 */

public class ChessClockException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a domain exception exception with the specified detail message.
	 * 
	 * @param message the detail message
	 */
	public ChessClockException(String message) {
		super(message);
	}

}
