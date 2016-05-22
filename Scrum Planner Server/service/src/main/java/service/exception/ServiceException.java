package service.exception;

/**
 * Wraps dao exceptions.
 *
 * @author Stefan Pamparau
 */
public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
