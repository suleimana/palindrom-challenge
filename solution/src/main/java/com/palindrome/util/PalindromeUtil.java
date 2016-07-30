package com.palindrome.util;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
@Component
public class PalindromeUtil {

    
    /**
     * 
     * Calculates the number of palindromic strings that can be created using the provided string.
     * The palindrome count of particular string depends in the string's length without any spaces and
     * number of unique chars. For example: 
     * 
     * - Input:- Nicola Tesla
     * - Input without spaces:- NicolaTesla => n = 11
     * 
     * - Unique chars:- nicolates => k = 9
     *  Then 
     *  Palindrome count = n^(k/2 +k%2)
     * 
     * @param str
     * @return 
     */
    public Long palindromeCount(String str) {
        Assert.isTrue(str != null, " Value should not be null");

        String nospaceStr = str.replace(" ", "").toLowerCase();
        String normailzed = getUniqueChars(nospaceStr);

        int n = normailzed.length();
        int k = nospaceStr.length();

        return n != 0 ? (long) Math.pow(n, (k / 2 + k % 2)) : 0;
    }

    private String getUniqueChars(String value) {

        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for (char c : value.toCharArray()) {
            set.add(c);
        }

        for (char c : set) {
            sb.append(c);
        }
        return sb.toString();
    }

}
