package sk.stuba.fei.uim.oop.assignment3.book.bookController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.bookService.BookService;

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
}
