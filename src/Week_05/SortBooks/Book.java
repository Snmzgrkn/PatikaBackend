package Week_05.SortBooks;

class Book implements Comparable<Book> {
    private String title;
    private int pageCount;

    // Constructor
    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    // Comparable interface'i için compareTo metodu
    @Override
    public int compareTo(Book otherBook) {
        return this.title.compareTo(otherBook.title);
    }

    // toString metodu
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}
