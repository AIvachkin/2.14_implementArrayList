package Exceptions;

public class IndexOutOfBoundExceptions extends Exception{
    public IndexOutOfBoundExceptions() {
    }

    public IndexOutOfBoundExceptions(String message) {
        super(message);
    }

    public IndexOutOfBoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutOfBoundExceptions(Throwable cause) {
        super(cause);
    }

    public IndexOutOfBoundExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
