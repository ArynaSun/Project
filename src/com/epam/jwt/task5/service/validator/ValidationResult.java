package com.epam.jwt.task5.service.validator;

public class ValidationResult {
    private boolean isValid = true;
    private String message = "";

    public ValidationResult() {
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void addMessage(String message) {
        if (this.message.isEmpty()) {
            this.message = message;
        } else {
            this.message += "\n" + message;
        }
    }
}
