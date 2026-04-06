package com.scm.helper;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String Message)
    {
        super(Message);
    }
    public ResourceNotFoundException()
    {
        super("Reason not found");
    }


}
