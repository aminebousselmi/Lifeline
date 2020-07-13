package com.lifeline.api.homeconfig.utility.exceptions;

import java.util.Date;
import java.util.List;

public class ValidationListError {
    private Date timestamp;
    private List<String> message;

    public ValidationListError(){}
    public ValidationListError(Date timestamp, List<String> message){
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
