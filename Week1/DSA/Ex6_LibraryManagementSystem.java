package DSA;

public class Ex6_LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager(10);
        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("B002", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("B003", "1984", "George Orwell"));
        library.addBook(new Book("B004", "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book("B005", "The Catcher in the Rye", "J.D. Salinger"));

        System.out.println("Searching for '1984' using linear search:");
        Book book1 = library.linearSearchByTitle("1984");
        if (book1 != null) {
            System.out.println("Found: " + book1);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nSearching for 'Pride and Prejudice' using binary search:");
        library.sortBooksByTitle(); // Ensuring the list is sorted for binary search
        Book book2 = library.binarySearchByTitle("Pride and Prejudice");
        if (book2 != null) {
            System.out.println("Found: " + book2);
        } else {
            System.out.println("Book not found.");
        }
    }

    static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    // Class for managing the library
    static class LibraryManager {
        private Book[] books;
        private int size;

        public LibraryManager(int capacity) {
            books = new Book[capacity];
            size = 0;
        }

        // Add a new book
        public void addBook(Book book) {
            if (size < books.length) {
                books[size] = book;
                size++;
            } else {
                System.out.println("Library is full. Cannot add more books.");
            }
        }

        // Linear search by title
        public Book linearSearchByTitle(String title) {
            for (int i = 0; i < size; i++) {
                if (books[i].getTitle().equalsIgnoreCase(title)) {
                    return books[i];
                }
            }
            return null;
        }

        // Binary search by title (assuming the array is sorted)
        public Book binarySearchByTitle(String title) {
            int left = 0;
            int right = size - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int comparison = books[mid].getTitle().compareToIgnoreCase(title);
                if (comparison == 0) {
                    return books[mid];
                }
                if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null;
        }

        // Sort books by title using a simple sorting algorithm
        public void sortBooksByTitle() {
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (books[i].getTitle().compareToIgnoreCase(books[j].getTitle()) > 0) {
                        // Swap books[i] and books[j]
                        Book temp = books[i];
                        books[i] = books[j];
                        books[j] = temp;
                    }
                }
            }
        }
    }
}

