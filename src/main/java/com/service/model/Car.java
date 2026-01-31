package com.service.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class Car {

    private Long id;
    
    @NotBlank(message = "Car make is required")
    private String make;
    
    @NotBlank(message = "Car model is required")
    private String model;
    
    @NotNull(message = "Year is required")
    @Min(value = 2010, message = "Year must be after 2010")
    @Max(value = 2030, message = "Year must be before 2030")
    private Integer year;
    
    @NotBlank(message = "License plate is required")
    private String licensePlate;
    
    @NotBlank(message = "Service type is required")
    private String serviceType;
    
    @NotNull(message = "Service cost is required")
    @Positive(message = "Service cost must be positive")
    private Double serviceCost;
    
    private String customerName;
    
    private String serviceStatus; // PENDING, IN_PROGRESS, COMPLETED
    
    public Car() {}
    
    public Car(Long id, String make, String model, Integer year, String licensePlate, 
               String serviceType, Double serviceCost, String customerName, String serviceStatus) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.serviceType = serviceType;
        this.serviceCost = serviceCost;
        this.customerName = customerName;
        this.serviceStatus = serviceStatus;
    }
    
    public Car(String make, String model, Integer year, String licensePlate, 
               String serviceType, Double serviceCost, String customerName, String serviceStatus) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.serviceType = serviceType;
        this.serviceCost = serviceCost;
        this.customerName = customerName;
        this.serviceStatus = serviceStatus;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public Integer getYear() {
        return year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getServiceType() {
        return serviceType;
    }
    
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    public Double getServiceCost() {
        return serviceCost;
    }
    
    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getServiceStatus() {
        return serviceStatus;
    }
    
    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
    
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", licensePlate='" + licensePlate + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceCost=" + serviceCost +
                ", customerName='" + customerName + '\'' +
                ", serviceStatus='" + serviceStatus + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return id != null && id.equals(car.id);
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}