package sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListController;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.bookController.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.lendingList.lendingListData.LendingList;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LendingListResponse {
    private Long id;
    private List<BookResponse> lendingList;
    private boolean lended;

    public LendingListResponse(LendingList list) {
        this.id = list.getId();
        this.lendingList = list.getBooks().stream().map(BookResponse::new).collect(Collectors.toList());
        this.lended = list.isLended();
    }
}
