package com.acme.center.platform.pc2.logistics.domain.exceptions;

public class DuplicateDeliveryCodeException extends RuntimeException{
    public DuplicateDeliveryCodeException(String message){
        super(message);
    }
}
