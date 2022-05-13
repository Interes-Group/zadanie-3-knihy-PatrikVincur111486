package sk.stuba.fei.uim.oop.assignment3.author.authorData;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.authorController.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @OneToMany (orphanRemoval = true)
    private List<Book> books;

    public Author() {
        this.books = new ArrayList<>();
    }
    public Author(AuthorRequest request){
        this.name = request.getName();
        this.surname = request.getSurname();
        this.books = new ArrayList<>();
    }
}
