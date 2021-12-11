package com.getir.retailbook.statistics;

import java.io.Serializable;
import java.util.List;

public class OrderStatisticDto implements Serializable {

    long month;
    List<String> totalAmount;
    long totalOrderCount;
    long totalBookCount;

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public List<String> getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(List<String> totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(long totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public long getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(long totalBookCount) {
        this.totalBookCount = totalBookCount;
    }
}
