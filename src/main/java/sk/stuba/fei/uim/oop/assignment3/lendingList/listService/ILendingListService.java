package sk.stuba.fei.uim.oop.assignment3.lendingList.listService;

import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListController.LendingListRequest;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListData.LendingList;

import java.util.List;

public interface ILendingListService {
    List<LendingList> getAllLists();
    LendingList createList();
    LendingList getListById(Long id) throws NotFoundException;
    void deleteList(Long id) throws NotFoundException;
    LendingList addBookToList(Long id, LendingListRequest request) throws NotFoundException,IllegalOperationException;
    void removeBookFromList(Long id, LendingListRequest request) throws NotFoundException;
    void lendList(Long id) throws NotFoundException,IllegalOperationException;

}

