package com.company.validator.exception;

import java.util.Date;

public class ErrorMessage {

    private int status;
    private String title;
    private String description;
    private Date timeStamp;

    public ErrorMessage(int status, String title, String description, Date date) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.timeStamp = date;
    }

    public static ErrorMessageBuilder builder(){
        return new ErrorMessageBuilder();
    }

    public static class ErrorMessageBuilder {
        private int status;
        private String title;
        private String description;
        private Date date;

        public ErrorMessageBuilder withStatus(int status){
            this.status = status;
            return this;
        }

        public ErrorMessageBuilder withDate(Date date){
            this.date = date;
            return this;
        }

        public ErrorMessageBuilder withTitle(String title){
            this.title = title;
            return this;
        }

        public ErrorMessage.ErrorMessageBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public ErrorMessage build(){
            return new ErrorMessage(status, title, description, date);
        }
    }

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
