package beans;

import java.io.Serializable;

/**
 * Created by tompu on 29/04/2017.
 */
public class ErrorMessage implements Serializable {

    private String errorMessage;
    private int errorCode;

    public ErrorMessage(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
