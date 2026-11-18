package com.acme.center.platform.pc2.logistics.domain.model.valueobjects;

public class DeliveryCode {
    private final String code;
    public DeliveryCode(String code){
        if(code == null || code.isBlank()){
            throw new IllegalArgumentException("Delivery code cannot be null or blank");
        }
        this.code=code;
    }
    public String getCode(){
        return code;
    }
}
