package exceptions;

/** Exception thrown when the database cannot be reached. */
public class DatabaseFailException extends RuntimeException{

    /** Creates a new exception for a failed database connection or similar.
     * 
     * @param message describing the database failiure.
     */
    public DatabaseFailException(String message) {
        super(message);
    }

}
