package exceptions;

public class DatabaseFailException extends RuntimeException{
    

    public DatabaseFailException(String message) {
        super(message);
    }
}
