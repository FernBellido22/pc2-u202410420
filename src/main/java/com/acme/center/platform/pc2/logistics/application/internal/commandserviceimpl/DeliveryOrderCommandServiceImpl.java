package com.acme.center.platform.pc2.logistics.application.internal.commandserviceimpl;
import com.acme.center.platform.pc2.logistics.application.commands.CreateDeliveryOrderCommand;
import com.acme.center.platform.pc2.logistics.application.commandservices.DeliveryOrderCommandService;
import com.acme.center.platform.pc2.logistics.domain.exceptions.DuplicateDeliveryCodeException;
import com.acme.center.platform.pc2.logistics.domain.model.aggregates.DeliveryOrder;
import com.acme.center.platform.pc2.logistics.domain.model.valueobjects.*;
import com.acme.center.platform.pc2.logistics.domain.repositories.DeliveryOrderRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class DeliveryOrderCommandServiceImpl implements DeliveryOrderCommandService{
    private final DeliveryOrderRepository repository;
    public DeliveryOrderCommandServiceImpl(DeliveryOrderRepository repository){
        this.repository = repository;
    }
    @Override
    public DeliveryOrder createDeliveryOrder(
            CreateDeliveryOrderCommand command
    ){
        DeliveryCode deliveryCode = new DeliveryCode(command.deliveryCode());
        if(repository.existsByDeliveryCode(deliveryCode)){
            throw  new DuplicateDeliveryCodeException("Delivery code already exists");
        }
        WarehouseId warehouseId =
                new WarehouseId(command.warehouseId());
        DeliveryWindow deliveryWindow =
                new DeliveryWindow(command.deliveryWindowStartDate(), command.deliveryWindowEndDate());
        PackageLoad packageLoad =
                new PackageLoad(command.packageLoadQuantity(), command.packageLoadUnit());
        DeliveryStatus status = command.status() == null ? DeliveryStatus.PENDING : DeliveryStatus.valueOf(command.status());
        DeliveryOrder deliveryOrder = new DeliveryOrder(

                deliveryCode,
                warehouseId,
                deliveryWindow,
                packageLoad,
                command.priorityLevel(),
                status,
                command.deliveryNotes()
        );
        return repository.save(deliveryOrder);
    }
}
