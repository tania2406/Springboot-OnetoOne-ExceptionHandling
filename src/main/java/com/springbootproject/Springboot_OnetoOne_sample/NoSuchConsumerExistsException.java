package com.springbootproject.Springboot_OnetoOne_sample;

public class NoSuchConsumerExistsException extends RuntimeException
{
    String message;

    public NoSuchConsumerExistsException() {}
    public NoSuchConsumerExistsException(String message) {
        super(message);
        this.message = message;
    }
}
