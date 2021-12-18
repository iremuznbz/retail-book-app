package com.getir.retailbook;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

public class BaseEntity {

    @CreatedDate
    @Indexed
    private LocalDateTime createdAt;

    @LastModifiedBy
    private LocalDateTime lastModifiedBy;

    @CreatedBy
    private String createdBy;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(LocalDateTime lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
