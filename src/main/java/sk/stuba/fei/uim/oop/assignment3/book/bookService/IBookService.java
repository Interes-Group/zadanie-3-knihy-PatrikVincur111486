package sk.stuba.fei.uim.oop.assignment3.book.bookService;

import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book create(BookRequest request);

    Book getById(Long id) throws NotFoundException;

    Book update(Long id, BookUpdateRequest request) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Integer getAmount(Long id) throws NotFoundException;

    Integer addAmount(Long id, Integer increment) throws NotFoundException;

    Integer getLendCount(Long id) throws NotFoundException;
}

