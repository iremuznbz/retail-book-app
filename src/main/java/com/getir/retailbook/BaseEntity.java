package com.getir.retailbook;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
