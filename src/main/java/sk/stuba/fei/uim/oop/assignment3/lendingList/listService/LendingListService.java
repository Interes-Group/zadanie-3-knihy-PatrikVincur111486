package sk.stuba.fei.uim.oop.assignment3.lendingList.listService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;
import sk.stuba.fei.uim.oop.assignment3.book.bookService.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListController.LendingListRequest;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListData.ILendingListRepository;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListData.LendingList;

import java.util.List;
import java.util.Objects;

@Service
public class LendingListService implements ILendingListService {

    @Autowired
    private ILendingListRepository repository;

    @Autowired
    private IBookService bookService;

    @Override
    public List<LendingList> getAllLists() {
        return this.repository.findAll();
    }

    @Override
    public LendingList createList() {
        return this.repository.save(new LendingList());
    }

    @Override
    public LendingList getListById(Long id) throws NotFoundException {
        LendingList list = this.repository.findLendingListById(id);
        if (list == null) {
            throw new NotFoundException();
        }
        return list;
    }

    @Override
    public void deleteList(Long id) throws NotFoundException {
        if(this.repository.findLendingListById(id) == null){
            throw new NotFoundException();
        }
        if(!getListById(id).isLended()){
            this.repository.delete(this.getListById(id));
        }
    }

    @Override
    public LendingList addBookToList(Long id, LendingListRequest request) throws IllegalOperationException,NotFoundException {
        LendingList list = this.repository.findLendingListById(id);
        Book book = this.bookService.getById(request.getId());
        if (list == null || book == null) {
            throw new NotFoundException();
        }
        for (Book books : list.getBooks()) {
            if (Objects.equals(books.getId(), request.getId())) {
                throw new IllegalOperationException();
            }
        }
        if (list.isLended()) {
            throw new IllegalOperationException();
        }
        list.getBooks().add(book);
        return this.repository.save(list);
    }

    @Override
    public void removeBookFromList(Long id, LendingListRequest request) throws NotFoundException {
        LendingList list = this.repository.findLendingListById(id);
        Book book = this.bookService.getById(request.getId());
        if (list == null || book == null) {
            throw new NotFoundException();
        }
        list.getBooks().remove(book);
        book.setLendCount(book.getLendCount()-1);
        this.repository.save(list);
}

    @Override
    public void lendList(Long id) throws NotFoundException,IllegalOperationException {
        LendingList list = this.repository.findLendingListById(id);
        if (list == null) {
            throw new NotFoundException();
        }
        if (list.isLended()) {
            throw new IllegalOperationException();
        }
        list.setLended(true);
        for (Book books : list.getBooks()) {
            books.setLendCount(books.getLendCount() + 1);
        }
        this.repository.save(list);
    }
}

