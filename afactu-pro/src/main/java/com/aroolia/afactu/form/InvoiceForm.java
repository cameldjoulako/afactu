package com.aroolia.afactu.form;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InvoiceForm {

    private String number;
    @NotBlank(message = "Le nom du client est obligatoire")
    private String customerName;
    @Size(min = 6, max = 10, message = "La longueur du numero es incorect. la plage est 6-10")
    private String orderNumber;

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
}
