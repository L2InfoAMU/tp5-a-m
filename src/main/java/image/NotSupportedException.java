package image;

/**
 * Exception class
 */
public class NotSupportedException extends RuntimeException {
    /**
     * Error for unexpected errors
     * @param message : message to display
     */
    public NotSupportedException(String message) {
        super(message);
    }
}
