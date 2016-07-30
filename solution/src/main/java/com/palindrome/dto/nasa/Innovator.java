
package com.palindrome.dto.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Innovator {
    
    @JsonProperty("lname")
    private String lName;
    
    @JsonProperty("fname")
    private String fName;

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    
        

}
