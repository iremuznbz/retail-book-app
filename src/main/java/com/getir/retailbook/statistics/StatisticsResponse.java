package com.getir.retailbook.statistics;

import java.io.Serializable;
import java.util.List;

public class StatisticsResponse implements Serializable {
    List<OrderStatisticDto> statistics;

    public List<OrderStatisticDto> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<OrderStatisticDto> statistics) {
        this.statistics = statistics;
    }
}
