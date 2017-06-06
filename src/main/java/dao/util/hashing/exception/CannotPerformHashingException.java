package dao.util.hashing.exception;

/**
 * Created by Zulu Warrior on 5/21/2017.
 */
public class CannotPerformHashingException extends Exception {
    public CannotPerformHashingException(String message) {
        super(message);
    }
    public CannotPerformHashingException(String message, Throwable source) {
        super(message, source);
    }
}
