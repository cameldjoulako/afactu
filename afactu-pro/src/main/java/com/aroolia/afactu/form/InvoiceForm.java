package com.aroolia.afactu.form;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InvoiceForm {

    private String number;
    @NotBlank(message = "Le nom du client est obligatoire")
    private String customerName;
    @Size(min = 6, max = 10, message = "La longueur du numero es incorect. la plage est 6-10")
    private String orderNumber;

    @NotBlank(message = "La rue est obligatoire")
    private String street;

    private String streetNumber;

    @NotBlank(message = "La ville est obligatoire")
    private String city;

    @NotBlank(message = "Le code postal est obligatoire")
    private String zipCode;

    @NotBlank(message = "Le pays est obligatoire")
    private String country;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}