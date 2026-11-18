package com.acme.center.platform.pc2.logistics.domain.model.valueobjects;
import java.time.LocalDate;
public class DeliveryWindow {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public DeliveryWindow(LocalDate startDate, LocalDate endDate){
        if (startDate == null || endDate == null){
            throw new IllegalArgumentException("Deivery dates cannot be null");
        }
        if (!endDate.isAfter(startDate)){
            throw new IllegalArgumentException("End date must be after start date");
        }
        this.startDate=startDate;
        this.endDate=endDate;
    }
    public LocalDate getStartDate(){
        return startDate;
    }
    public LocalDate getEndDate(){
        return endDate;
    }

    public boolean includes(LocalDate checkDate){
        if (checkDate == null){
            throw new IllegalArgumentException("Check cannot be null");
        }
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}
