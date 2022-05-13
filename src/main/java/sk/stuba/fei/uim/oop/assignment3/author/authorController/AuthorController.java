package sk.stuba.fei.uim.oop.assignment3.author.authorController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.author.authorService.AuthorService;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    private AuthorService service;

    @GetMapping()
    public List<AuthorResponse> getAllAuthors() {
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest body){
        return new ResponseEntity<>(new AuthorResponse(this.service.create(body)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable("id") Long authorId) throws NotFoundException {
        return new AuthorResponse(this.service.getById(authorId));
    }

    @PutMapping("/{id}")
    public AuthorResponse updateAuthorById(@PathVariable("id") Long authorId, @RequestBody AuthorRequest body) throws NotFoundException {
        return new AuthorResponse(this.service.update(authorId, body));
    }

   @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable("id") Long authorId) throws NotFoundException {
        this.service.delete(authorId);
    }
}
