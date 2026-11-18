package com.acme.center.platform.pc2.logistics.domain.model.valueobjects;
import java.util.UUID;
public class WarehouseId {
    private final UUID value;

    public WarehouseId(UUID value){
        if (value == null){
           throw new IllegalArgumentException("Warehouse ID cannot be null");
        }
        this.value=value;
    }
    public  UUID getvalue(){
        return value;
    }
}
