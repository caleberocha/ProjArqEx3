package singleton.exceptions;

public class TooMuchCashException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TooMuchCashException() {
        super();
    }

    public TooMuchCashException(String arg0) {
        super("Dinheiro demais! Tá rico, é?");
    }
}