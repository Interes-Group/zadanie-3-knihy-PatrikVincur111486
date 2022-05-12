package sk.stuba.fei.uim.oop.assignment3.book.bookController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.bookService.BookService;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookService service;
    @GetMapping
    public List<BookResponse> getAllBooks(){
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest body){
        return new ResponseEntity<>(new BookResponse(this.service.create(body)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable("id") Long bookId) throws NotFoundException {
        return new BookResponse(this.service.getById(bookId));
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable("id") Long bookId, @RequestBody BookUpdateRequest body) throws NotFoundException {
        return new BookResponse(this.service.update(bookId, body));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long bookId) throws NotFoundException {
        this.service.delete(bookId);
    }

}
