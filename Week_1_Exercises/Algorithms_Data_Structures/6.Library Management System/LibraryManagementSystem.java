package libraryMangementSystem;

import java.util.ArrayList;
import java.util.List;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class SearchUtils {
    // Linear search method
    public static List<Book> linearSearch(List<Book> books, String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }

    // Binary search method
    public static Book binarySearch(List<Book> books, String title) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midTitle = books.get(mid).getTitle().toLowerCase();

            if (midTitle.equals(title.toLowerCase())) {
                return books.get(mid);
            } else if (midTitle.compareTo(title.toLowerCase()) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; 
    }
}

public class LibraryManagementSystem {
	public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Girl in Room 105", "Chetan Bhagat"));
        books.add(new Book(2, "It Starts with Us", "Colleen Hoover"));
        books.add(new Book(3, "It Ends with Us", "Colleen Hoover"));
        String titleToSearch = "Girl in Room 105";
        List<Book> foundBooksLinear = SearchUtils.linearSearch(books, titleToSearch);
        System.out.println("Linear Search Results: " + foundBooksLinear);
        Book foundBookBinary = SearchUtils.binarySearch(books, titleToSearch);
        System.out.println("Binary Search Result: " + foundBookBinary);
    }
}
