
package com.palindrome.dto.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatentReport {
    
    private int count;
    private List<Patent> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Patent> getResults() {
        return results;
    }

    public void setResults(List<Patent> results) {
        this.results = results;
    }
    
    

}
