package com.getir.retailbook.order;

import com.getir.retailbook.BaseEntity;
import com.getir.retailbook.customer.CustomerEntity;
import com.getir.retailbook.order.dto.Item;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document("order")
public class OrderEntity extends BaseEntity {
    @Id
    private String id;

    @NotNull
    @DBRef
    private CustomerEntity customer;

    @NotEmpty
    private List<Item> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
