package com.example.weejing.myapplication;

/**
 * Created by MSI-YJ on 1/23/2016.
 */
public class ItemObject {
    private String customerId;
    private String customerName;
    private String customerArrivalTime;
    private String customerArray;

    public ItemObject(String custId, String custName, String custArrivalTime, String custArray) {
        this.customerId = custId;
        this.customerName = custName;
        this.customerArrivalTime = custArrivalTime;
        this.customerArray = custArray;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerArrivalTime() {
        return customerArrivalTime;
    }

    public void setCustomerArrivalTime(String customerArrivalTime) {
        this.customerArrivalTime = customerArrivalTime;
    }

    public String getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(String customerArray) {
        this.customerArray = customerArray;
    }
}
