package com.getir.retailbook.book.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BookCreateRequest implements Serializable {
    private String name;
    private String author;

}
