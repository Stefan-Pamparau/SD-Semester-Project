package dao.exception;

/**
 * Wraps hibernate exceptions.
 *
 * @author Stefan Pamparau
 */
public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}

