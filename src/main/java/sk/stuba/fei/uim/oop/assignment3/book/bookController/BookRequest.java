package sk.stuba.fei.uim.oop.assignment3.book.bookController;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.authorData.Author;

@Getter
@Setter
public class BookRequest {
    private String name;
    private String description;
    private Long author;
    private Integer pages;
    private Integer amount;
    private Integer lendCount;

}
