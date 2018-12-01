package com.example.admin.du_an_1.Repository;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String id;
    private String date;
    private Boolean type;
    private String productId;
    private int quantity;

    public Ticket() {
    }

    public Ticket(String id, String date, Boolean type, String productId, int quantity) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.productId=productId;
        this.quantity = quantity;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
