package singleton.exceptions;

public class NoCardException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NoCardException() {
        super();
    }

    public NoCardException(String arg0) {
        super(arg0);
    }

    public NoCardException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}