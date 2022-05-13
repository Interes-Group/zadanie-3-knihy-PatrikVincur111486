package sk.stuba.fei.uim.oop.assignment3.book.bookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.authorData.Author;
import sk.stuba.fei.uim.oop.assignment3.author.authorData.IAuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.authorService.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.IBookRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository repository;

    //TODO @Autowired
    //TODO private IAuthorRepository authorRepository;

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
    public Book update(Long id, BookUpdateRequest request) throws NotFoundException {
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
        //TODO Author a = this.authorRepository.findAuthorById(Long.valueOf(getById(id).getAuthor()));
        this.repository.delete(this.getById(id));

    }

    @Override
    public Integer getAmount(Long id) throws NotFoundException {
        return this.getById(id).getAmount();
    }

    @Override
    public Integer addAmount(Long id, Integer increment) throws NotFoundException {
        Book b = this.getById(id);
        b.setAmount(b.getAmount() + increment);
        this.repository.save(b);
        return b.getAmount();
    }

    @Override
    public Integer getLendCount(Long id) throws NotFoundException {
        return this.getById(id).getLendCount();
    }


}
