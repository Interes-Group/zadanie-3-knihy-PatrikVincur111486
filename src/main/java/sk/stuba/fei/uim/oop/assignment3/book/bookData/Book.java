package sk.stuba.fei.uim.oop.assignment3.book.bookData;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Integer authorID;
    private Integer pages;
    private Integer amount;
    private Integer lendCount;

    public Book(BookRequest request){
        this.name = request.getName();
        this.description = request.getDescription();
        this.authorID = request.getAuthorID();
        this.pages = request.getPages();
        this.amount = request.getAmount();
        this.lendCount = request.getLendCount();
    }
}
