package sk.stuba.fei.uim.oop.assignment3.lendingList.listService;


import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListController.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListData.LendingList;

import java.util.List;

public interface ILendingListService {
    List<LendingList> getAll();

    LendingList createList();

    LendingList getListById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

  /*  LendingList addBookToList(Long id, BookIdRequest request) throws NotFoundException;

    Integer removeBookFromList(Long id, BookIdRequest request) throws NotFoundException;

    Integer lendList(Long id) throws NotFoundException;
*/
}

