package com.palindrome.dto.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patent {

    @JsonProperty("innovator")
    private List<Innovator> innovators;
    
    @JsonProperty("client_record_id")
    private String clientRecordId;

    public List<Innovator> getInnovators() {
        return innovators;
    }

    public void setInnovators(List<Innovator> innovators) {
        this.innovators = innovators;
    }

    public String getClientRecordId() {
        return clientRecordId;
    }

    public void setClientRecordId(String clientRecordId) {
        this.clientRecordId = clientRecordId;
    }
    

}
