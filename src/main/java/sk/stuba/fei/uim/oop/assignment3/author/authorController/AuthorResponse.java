package sk.stuba.fei.uim.oop.assignment3.author.authorController;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.authorData.Author;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AuthorResponse {
    private Long id;
    private String name;
    private String surname;

    private List<Long> books;


    public AuthorResponse(Author a) {
        this.id = a.getId();
        this.name = a.getName();
        this.surname = a.getSurname();
        this.books=a.getBooks().stream().map(Book::getId).collect(Collectors.toList());
    }
}
