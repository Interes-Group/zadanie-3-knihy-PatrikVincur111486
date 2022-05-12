package sk.stuba.fei.uim.oop.assignment3.book.bookService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.IBookRepository;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

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
    public Book getById(Long id) throws NotFoundException {
        Book b = this.repository.findBookById(id);
        if (b == null) {
            throw new NotFoundException();
        }
        return b;
    }

    @Override
    public Book update(long id, BookUpdateRequest request) throws NotFoundException {
        Book b = this.getById(id);
        if (request.getName() != null) {
            b.setName(request.getName());
        }
        if (request.getDescription() != null) {
            b.setDescription(request.getDescription());
        }
        if (request.getPages() != null) {
            b.setPages(request.getPages());
        }
        if (request.getAuthor() != null) {
            b.setAuthor(request.getAuthor());
        }
        return this.repository.save(b);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        this.repository.delete(this.getById(id));
    }


}
