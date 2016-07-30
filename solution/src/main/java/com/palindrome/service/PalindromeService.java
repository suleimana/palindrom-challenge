package com.palindrome.service;

import com.palindrome.common.PalindromeDescComparator;
import com.palindrome.view.PalindromeResponse;
import com.palindrome.dto.nasa.Innovator;
import com.palindrome.dto.nasa.Patent;
import com.palindrome.dto.nasa.PatentReport;
import com.palindrome.exception.PalindromeException;
import com.palindrome.util.PalindromeUtil;
import com.palindrome.util.PalindromeValidationHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
@Service
public class PalindromeService {

    @Autowired
    private PalindromeUtil palindromeUtil;

    public static final String NASA_PATTENT_URL_FORMAT = "https://api.nasa.gov/patents/content?query=%s&limit=%s&api_key=DEMO_KEY";

    Logger LOG = Logger.getLogger(PalindromeService.class);

    /**
     * get back part of NASA patent report for particular search string
     *
     * @param search
     * @param limit
     * @return
     * @throws com.palindrome.exception.PalindromeException
     */
    public PatentReport getPatentReport(String search, int limit) throws PalindromeException {
        PalindromeValidationHelper.validateLimit(limit);
        
        RestTemplate restTemplate = new RestTemplate();
        PatentReport patentReport = restTemplate.getForObject(String.format(NASA_PATTENT_URL_FORMAT, search, limit), PatentReport.class);
        //LOG.info(patentReport.toString());        
        return patentReport;
    }

    /**
     * Calculates the number of palindromic strings that can be created using
     * the provided string.
     *
     * @param search
     * @param limit
     * @return
     * @throws com.palindrome.exception.PalindromeException
     */
    public List<PalindromeResponse> calculatePalindrome(String search, int limit) throws PalindromeException {        
        PatentReport patentReport = getPatentReport(search, limit);
        List<PalindromeResponse> result = new ArrayList<>();

        for (Patent p : patentReport.getResults()) {
            for (Innovator i : p.getInnovators()) {
                String fullName = i.getfName() + " " + i.getlName();
                result.add(new PalindromeResponse(fullName, palindromeUtil.palindromeCount(fullName)));
            }
        }

        Collections.sort(result, new PalindromeDescComparator());

        return result;
    }

}
