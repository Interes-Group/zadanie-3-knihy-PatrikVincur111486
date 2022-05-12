package sk.stuba.fei.uim.oop.assignment3.book.bookController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateRequest {
    private String name;
    private String description;
    private Integer author;
    private Integer pages;
}
