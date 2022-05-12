package sk.stuba.fei.uim.oop.assignment3.book.bookController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.book.bookService.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookService service;

    @GetMapping


}
