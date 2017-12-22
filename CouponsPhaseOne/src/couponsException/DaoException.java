package couponsException;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
		super("Dao Exception");
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}
}