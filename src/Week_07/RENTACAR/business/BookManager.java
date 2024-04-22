package Week_07.RENTACAR.business;

import Week_07.RENTACAR.dao.BookDao;
import Week_07.RENTACAR.entity.Book;

public class BookManager {
    private final BookDao bookDao;

    public BookManager() {
        this.bookDao = new BookDao();
    }

    public boolean save(Book book){
        return this.bookDao.save(book);
    }
}
