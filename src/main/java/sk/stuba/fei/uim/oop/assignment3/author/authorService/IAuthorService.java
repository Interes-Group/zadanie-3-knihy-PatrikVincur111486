package sk.stuba.fei.uim.oop.assignment3.author.authorService;

import sk.stuba.fei.uim.oop.assignment3.author.authorController.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.authorData.Author;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author create(AuthorRequest request);
    Author getById(Long id) throws NotFoundException;
    Author update(Long id, AuthorRequest request) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
    void deleteBook(Book b) throws NotFoundException;


}

