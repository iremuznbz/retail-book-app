package com.getir.retailbook.util;

public interface EntityMapper <T> {
    public T mapToEntity(T dto);
    public T mapToDto(T request);

}
