package com.acme.center.platform.pc2.logistics.domain.repositories;
import com.acme.center.platform.pc2.logistics.domain.model.aggregates.DeliveryOrder;
import com.acme.center.platform.pc2.logistics.domain.model.valueobjects.DeliveryCode;
public interface DeliveryOrderRepository {
    DeliveryOrder save(DeliveryOrder deliveryOrder);
    boolean existsByDeliveryCode(DeliveryCode deliveryCode);
}
