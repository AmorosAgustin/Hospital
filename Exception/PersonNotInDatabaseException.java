package Exception;

public class PersonNotInDatabaseException extends Exception {
    public PersonNotInDatabaseException(String errorMessage) {
        super(errorMessage);
    }
}
