
package com.palindrome.view;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
public class BaseResponse{

    public BaseResponse(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }
        
    private boolean successful;
    private String message;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
