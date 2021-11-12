package Exception;

public class PersonAlreadyInDatabaseException extends Exception {
    public PersonAlreadyInDatabaseException(String errorMessage) {
        super(errorMessage);
    }
}
