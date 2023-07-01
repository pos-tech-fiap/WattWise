package com.pos.wattwise.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class FormValidation extends DefaultError {

    private List<FieldValidation> messages = new ArrayList<>();

    public List<FieldValidation> getMessages() {
        return messages;
    }

    public void addMessages(String field, String message) {
        messages.add(new FieldValidation(field, message));
    }
}
