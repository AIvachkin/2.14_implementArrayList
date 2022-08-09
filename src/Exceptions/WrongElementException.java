package Exceptions;

public class WrongElementException extends RuntimeException {
    public WrongElementException() {
    }

    public WrongElementException(String message) {
        super(message);
    }

    public WrongElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongElementException(Throwable cause) {
        super(cause);
    }

    public WrongElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
