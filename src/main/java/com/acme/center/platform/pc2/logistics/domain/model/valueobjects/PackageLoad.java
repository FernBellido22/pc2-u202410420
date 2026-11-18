package com.acme.center.platform.pc2.logistics.domain.model.valueobjects;

public class PackageLoad {
    private final Integer quantity;
    private final String unit;

    public PackageLoad(Integer quantity, String unit){
        if (quantity == null || quantity <=0){
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if(unit == null ||unit.isBlank()){
            throw  new IllegalArgumentException("Unit cannot be null or blank");
        }
        this.quantity=quantity;
        this.unit=unit;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public String getUnit(){
        return unit;
    }

    public PackageLoad increaseBy(Integer additionalQuantity){
        if(additionalQuantity == null || additionalQuantity <=0){
            throw new IllegalArgumentException("Additional Quantity must be positive");
        }
        if(additionalQuantity > Integer.MAX_VALUE-quantity){
            throw new IllegalArgumentException("Package quantity exceed maximum integer value");
        }
        return new PackageLoad(quantity + additionalQuantity, unit);
    }
}
