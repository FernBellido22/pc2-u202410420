package com.acme.center.platform.pc2.logistics.domain.model.aggregates;
import com.acme.center.platform.pc2.logistics.domain.model.valueobjects.DeliveryCode;
import com.acme.center.platform.pc2.logistics.domain.model.valueobjects.DeliveryStatus;
import com.acme.center.platform.pc2.logistics.domain.model.valueobjects.DeliveryWindow;
import com.acme.center.platform.pc2.logistics.domain.model.valueobjects.PackageLoad;
import com.acme.center.platform.pc2.logistics.domain.model.valueobjects.WarehouseId;

import java.time.Instant;

public class DeliveryOrder {
    private Long id;
    private final DeliveryCode deliveryCode;
    private final WarehouseId warehouseId;
    private final DeliveryWindow deliveryWindow;
    private final PackageLoad packageLoad;
    private final Integer priorityLevel;
    private final DeliveryStatus status;
    private final String deliveryNotes;
    private final Instant createdAt;
    private final Instant updatedAt;

    public DeliveryOrder(
            DeliveryCode deliveryCode,
            WarehouseId warehouseId,
            DeliveryWindow deliveryWindow,
            PackageLoad packageLoad,
            Integer priorityLevel,
            DeliveryStatus status,
            String deliveryNotes
    ){
        if(deliveryCode == null){
            throw new IllegalArgumentException("Delivery Code is required");
        }
        if(warehouseId == null){
            throw new IllegalArgumentException("Warehouse ID is required");
        }
        if(deliveryWindow == null){
            throw new IllegalArgumentException("Delivery window is required");
        }
        if(packageLoad == null){
            throw new IllegalArgumentException("Package load is required");
        }
        if (priorityLevel == null ||priorityLevel<1 || priorityLevel>5){
            throw new IllegalArgumentException("Priority level must be between 1 and 5");
        }
        this.deliveryCode=deliveryCode;
        this.warehouseId=warehouseId;
        this.deliveryWindow=deliveryWindow;
        this.packageLoad=packageLoad;
        this.priorityLevel=priorityLevel;
        this.status=status ==null ? DeliveryStatus.PENDING :status;
        this.deliveryNotes=deliveryNotes;

        Instant now = Instant.now();
        this.createdAt=now;
        this.updatedAt=now;
    }
    public Long getId(){
        return id;
    }
    public DeliveryCode getDeliveryCode(){
        return deliveryCode;
    }
    public WarehouseId getWarehouseId(){
        return warehouseId;
    }
    public DeliveryWindow getDeliveryWindow(){
        return deliveryWindow;
    }
    public PackageLoad getPackageLoad(){
        return packageLoad;
    }
    public Integer getPriorityLevel(){
        return priorityLevel;
    }
    public DeliveryStatus getStatus(){
        return status;
    }
    public String getDeliveryNotes(){
        return deliveryNotes;
    }
    public Instant getCreatedAt(){
        return createdAt;
    }
    public  Instant getUpdatedAt(){
        return updatedAt;
    }
}
