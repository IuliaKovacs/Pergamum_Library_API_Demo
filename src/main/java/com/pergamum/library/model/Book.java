package com.pergamum.library.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    static int index = 1000;

    private int id;
    private String title;
    private String author;

    public static int getIndex(){
        index++;
        return index;
    }

}
