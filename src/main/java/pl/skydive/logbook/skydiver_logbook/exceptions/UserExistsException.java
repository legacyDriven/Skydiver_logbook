package pl.skydive.logbook.skydiver_logbook.exceptions;

public class UserExistsException extends Exception {
    public UserExistsException(String message) {
        super(message);
    }
}
