package ru.lazarev.lesson11.exceprion_handling;

import lombok.Data;

import java.util.Date;

@Data
public class MarketError {

    private int status;
    private String message;
    private Date timestamp;

    public MarketError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
