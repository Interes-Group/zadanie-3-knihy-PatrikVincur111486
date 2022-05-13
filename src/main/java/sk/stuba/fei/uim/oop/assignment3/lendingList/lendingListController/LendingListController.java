package sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Amount;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.listService.LendingListService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class LendingListController {

    @Autowired
    private LendingListService service;

    @GetMapping()
    public List<LendingListResponse> getAllLendingLists() {
        return this.service.getAll().stream().map(LendingListResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<LendingListResponse> addLendingList(){
        return new ResponseEntity<>(new LendingListResponse(this.service.createList()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public LendingListResponse getLendingListById(@PathVariable("id") Long listId) throws NotFoundException {
        return new LendingListResponse(this.service.getListById(listId));
    }

   @DeleteMapping("/{id}")
    public void deleteLendingList(@PathVariable("id") Long listId) throws NotFoundException {
        this.service.delete(listId);
    }

    /*@GetMapping("/{id}/add")
    public Amount getAmount(@PathVariable("id") Long bookId) throws NotFoundException {
        return new Amount(this.service.getAmount(bookId));
    }

    @PostMapping("/{id}/remove")
    public Amount addAmount(@PathVariable("id") Long bookId, @RequestBody Amount body) throws NotFoundException {
        return new Amount(this.service.addAmount(bookId, body.getAmount()));
    }

    @PostMapping("/{id}/lend")
    public Integer getLendCunt(@PathVariable("id") Long bookId) throws NotFoundException {
        return this.service.getLendCount(bookId);
    }*/
}
