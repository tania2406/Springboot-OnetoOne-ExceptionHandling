package com.springbootproject.Springboot_OnetoOne_sample;

public class ConsumerAlreadyExistsException extends RuntimeException
{
    String message;

    public ConsumerAlreadyExistsException() {}
    public ConsumerAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
