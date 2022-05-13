package sk.stuba.fei.uim.oop.assignment3.book.bookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.authorData.Author;
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
    private IBookRepository bookRepository;

    @Autowired
    private IAuthorService authorService;

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book create(BookRequest request) throws NotFoundException {
        Book b = new Book(request);
        Author a = this.authorService.getById(request.getAuthor());
        if (a == null) {
            throw new NotFoundException();
        }
        a.getBooks().add(b);
        return this.bookRepository.save(b);
    }

    @Override
    public Book getById(Long id) throws NotFoundException {
        Book b = this.bookRepository.findBookById(id);
        if (b == null) {
            throw new NotFoundException();
        }
        return b;
    }

    @Override
    public Book update(Long id, BookUpdateRequest request) throws NotFoundException {
        Book b = this.bookRepository.findBookById(id);
        if (b == null) {
            throw new NotFoundException();
        }
        if (request.getName() != null) {
            b.setName(request.getName());
        }
        if (request.getDescription() != null) {
            b.setDescription(request.getDescription());
        }
        if (request.getAuthor() != 0) {
            b.setAuthor(request.getAuthor());
        }
        if (request.getPages() != 0) {
            b.setPages(request.getPages());
        }
        return this.bookRepository.save(b);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Book b = this.bookRepository.findBookById(id);
        if (b == null) {
            throw new NotFoundException();
        }
        this.authorService.deleteBook(b);
        this.bookRepository.delete(b);
    }

    @Override
    public Integer getAmount(Long id) throws NotFoundException {
        return this.getById(id).getAmount();
    }

    @Override
    public Integer addAmount(Long id, Integer increment) throws NotFoundException {
        Book b = this.getById(id);
        b.setAmount(b.getAmount() + increment);
        this.bookRepository.save(b);
        return b.getAmount();
    }

   @Override
    public Integer getLendCount(Long id) throws NotFoundException {
        Book b = this.bookRepository.findBookById(id);
        if(b == null){
            throw new NotFoundException();
        }
        return this.getById(id).getLendCount();
    }
}
