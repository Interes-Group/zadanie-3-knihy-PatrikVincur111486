package sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.listService.ILendingListService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class LendingListController {

    @Autowired
    private ILendingListService service;

    @GetMapping()
    public List<LendingListResponse> getAllLists() {
        return this.service.getAllLists().stream().map(LendingListResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<LendingListResponse> createList(){
        return new ResponseEntity<>(new LendingListResponse(this.service.createList()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public LendingListResponse getListById(@PathVariable("id") Long listId) throws NotFoundException {
        return new LendingListResponse(this.service.getListById(listId));
    }

   @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long listId) throws NotFoundException {
        this.service.deleteList(listId);
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<LendingListResponse>  addBookToList(@PathVariable("id") Long id, @RequestBody LendingListRequest request) throws NotFoundException, IllegalOperationException {
        return new ResponseEntity<>(new LendingListResponse(this.service.addBookToList(id,request)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}/remove")
    public void removeBookFromList(@PathVariable("id") Long id, @RequestBody LendingListRequest request) throws NotFoundException {
        this.service.removeBookFromList(id,request);
    }

    @GetMapping("/{id}/lend")
    public void lendList(@PathVariable("id") Long id) throws NotFoundException,IllegalOperationException {
        this.service.lendList(id);
    }
}
