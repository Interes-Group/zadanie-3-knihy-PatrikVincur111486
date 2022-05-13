package sk.stuba.fei.uim.oop.assignment3.lendingList.listService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.Book;
import sk.stuba.fei.uim.oop.assignment3.book.bookData.IBookRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListController.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListData.ILendingListRepository;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListData.LendingList;

import java.util.List;
import java.util.Objects;

@Service
public class LendingListService implements ILendingListService {

    @Autowired
    private ILendingListRepository repository;

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<LendingList> getAll() {
        return this.repository.findAll();
    }

    @Override
    public LendingList createList() {
        return this.repository.save(new LendingList());
    }

    @Override
    public LendingList getListById(Long id) throws NotFoundException {
        LendingList l = this.repository.findLendingListById(id);
        if (l == null) {
            throw new NotFoundException();
        }
        return l;
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        this.repository.delete(this.getListById(id));
    }

    /*@Override
    public Integer addBookToList(Long id, BookIdRequest request) throws NotFoundException {
        LendingList l = this.repository.findLendingListBy(id);
        Book b = this.bookRepository.findBookById(request.getId());
        if (l == null) {
            throw new NotFoundException();
        }
        for (Book book : l.getBooks()) {
            if (Objects.equals(book.getId(), request.getId())) {
                //throw new IllegalOperationException();
            }
        }

        if (l.isLended()) {
            // throw new IllegalOperationException();
        }
        if (b == null) {
            throw new NotFoundException();
        }
        return null;
    }

    @Override
    public Integer removeBookFromList(Long id, BookIdRequest request) throws NotFoundException {
        return null;
    }

    @Override
    public Integer lendList(Long id) throws NotFoundException {
        return null;
    }*/
}
