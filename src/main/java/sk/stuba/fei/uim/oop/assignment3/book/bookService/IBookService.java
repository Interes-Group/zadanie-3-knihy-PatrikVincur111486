package sk.stuba.fei.uim.oop.assignment3.book.bookService;

import javassist.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book create(BookRequest request);

}
