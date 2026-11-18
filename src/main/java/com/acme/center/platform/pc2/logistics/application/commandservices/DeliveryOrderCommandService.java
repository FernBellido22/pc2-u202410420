package com.acme.center.platform.pc2.logistics.application.commandservices;
import com.acme.center.platform.pc2.logistics.application.commands.CreateDeliveryOrderCommand;
import com.acme.center.platform.pc2.logistics.domain.model.aggregates.DeliveryOrder;
public interface DeliveryOrderCommandService {
    DeliveryOrder createDeliveryOrder(
            CreateDeliveryOrderCommand command
    );
}
