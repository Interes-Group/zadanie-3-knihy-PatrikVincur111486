package sk.stuba.fei.uim.oop.assignment3.book.bookData;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.authorData.Author;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookRequest;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


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

    private Long author;
    private Integer pages;
    private Integer amount;
    private Integer lendCount;

    public Book(BookRequest request){
        this.name = request.getName();
        this.description = request.getDescription();
        this.author = request.getAuthor();
        this.pages = request.getPages();
        this.amount = request.getAmount();
        this.lendCount = request.getLendCount();
    }
}
