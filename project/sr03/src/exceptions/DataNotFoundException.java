package exceptions;

/**
 * Created by tompu on 29/04/2017.
 */
public class DataNotFoundException extends RuntimeException {

    private static final String serialVersionUID = "65307267-e16e-4de1-9ebc-bda6cd83bacf";

    public DataNotFoundException(String message) {
        super(message);
    }
}
