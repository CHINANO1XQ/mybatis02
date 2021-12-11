package com.zking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;

    private String bookName;

    private Float bookPrice;

    private String bookBrief;


}