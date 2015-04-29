package blog.dao.exception;

public class DaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an DaoException using the given exception message.
     *
     * @param message The message explaining the reason for the exception
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Constructs an DaoException using the given underlying cause.
     *
     * @param cause The underlying cause
     */
    public DaoException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an DaoException using the given message and underlying cause.
     *
     * @param message The message explaining the reason for the exception
     * @param cause   The underlying cause
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}