package com.palindrome.common;

import com.palindrome.view.PalindromeResponse;
import java.util.Comparator;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
public class PalindromeDescComparator implements Comparator<PalindromeResponse> {

    @Override
    public int compare(PalindromeResponse o1, PalindromeResponse o2) {
        if (o1.getCount().equals(o2.getCount())) {
            return 0;
        } else {
            return o1.getCount() > o2.getCount() ? -1 : 1;
        }
    }

}
