package sk.stuba.fei.uim.oop.assignment3.book.bookService;

import javassist.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book create(BookRequest request);

    Book getById(long id) throws NotFoundException;

    //Book update(long id, ProductUpdateRequest request) throws NotFoundException;

    void delete(long id) throws NotFoundException;

    long getAmount(long id) throws NotFoundException;

    long addAmount(long id, long increment) throws NotFoundException;

   // void removeAmount(long id, long decrement) throws NotFoundException, IllegalOperationException;
}
