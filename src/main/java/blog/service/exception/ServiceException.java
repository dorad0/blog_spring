package blog.service.exception;

/**
 * Created by alex on 4/29/2015.
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs an ServiceException using the given exception message.
     *
     * @param message The message explaining the reason for the exception
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Constructs an ServiceException using the given underlying cause.
     *
     * @param cause The underlying cause
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an ServiceException using the given message and underlying cause.
     *
     * @param message The message explaining the reason for the exception
     * @param cause   The underlying cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}