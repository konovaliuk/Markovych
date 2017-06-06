package dao.util.hashing.exception;

/**
 * Created by Zulu Warrior on 5/21/2017.
 */
public class InvalidHashException extends Exception {
    public InvalidHashException(String message) {
        super(message);
    }
    public InvalidHashException(String message, Throwable source) {
        super(message, source);
    }
}
