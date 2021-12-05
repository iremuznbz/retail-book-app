package com.getir.retailbook.request;

import java.io.Serializable;

public class CustomerOrderListRequest implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toCustomerId(){
        return id;
    }
}

