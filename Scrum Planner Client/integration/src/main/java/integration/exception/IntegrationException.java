package integration.exception;

/**
 * Wraps any integration exception that might occur
 *
 * @author Stefan Pamparau
 */
public class IntegrationException extends Exception {
    public IntegrationException(String message) {
        super(message);
    }

    public IntegrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
