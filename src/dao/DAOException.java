package dao;

/**
 * Created by Anna on 1/28/2016.
 */
public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
