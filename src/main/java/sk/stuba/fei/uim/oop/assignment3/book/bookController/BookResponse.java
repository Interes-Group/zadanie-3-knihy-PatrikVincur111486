package sk.stuba.fei.uim.oop.assignment3.book.bookController;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;

@Getter
public class BookResponse {
    private Long id;
    private String name;
    private String description;
    private Integer authorID;
    private Integer pages;
    private Integer amount;
    private Integer lendCount;

    public BookResponse(Book b){
        this.id = b.getId();
        this.name = b.getName();
        this.description = b.getDescription();
        this.authorID = b.getAuthorID();
        this.pages = b.getPages();
        this.amount = b.getAmount();
        this.lendCount = b.getLendCount();
    }
}
