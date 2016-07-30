
package com.palindrome.util;

import com.palindrome.exception.PalindromeException;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
public class PalindromeValidationHelper {
    public static int MAX_LIMIT= 5;
    public static int MIN_LIMIT= 1;
    
    public static void validateLimit(int limit) throws PalindromeException{
        if(limit < MIN_LIMIT || limit > MAX_LIMIT){
            throw new PalindromeException(String.format("Limit should be between %s and %s", MIN_LIMIT, MAX_LIMIT));
        }        
    }    
}
