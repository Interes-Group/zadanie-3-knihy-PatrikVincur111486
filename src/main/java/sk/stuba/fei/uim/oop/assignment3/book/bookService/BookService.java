package sk.stuba.fei.uim.oop.assignment3.book.bookService;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.IBookRepository;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository repository;

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookRequest request) {
        return this.repository.save(new Book(request));
    }

    @Override
    public Book getById(long id) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(long id) throws NotFoundException {

    }

    @Override
    public long getAmount(long id) throws NotFoundException {
        return 0;
    }

    @Override
    public long addAmount(long id, long increment) throws NotFoundException {
        return 0;
    }
}
