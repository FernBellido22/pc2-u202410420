package com.acme.center.platform.pc2.logistics.application.commands;
import java.util.UUID;
import java.time.LocalDate;
public record CreateDeliveryOrderCommand(
        String deliveryCode,
        UUID warehouseId,
        LocalDate deliveryWindowStartDate,
        LocalDate deliveryWindowEndDate,
        Integer packageLoadQuantity,
        String packageLoadUnit,
        Integer priorityLevel,
        String status,
        String deliveryNotes
){}

