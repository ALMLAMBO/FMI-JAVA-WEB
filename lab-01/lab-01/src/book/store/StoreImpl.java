package book.store;

import book.models.Book;
import book.service.Store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StoreImpl implements Store {
    private List<Book> books;

    public StoreImpl() {
        books = new ArrayList<>();
    }

    @Override
    public boolean add(Book o) {
        if(books.contains(o)) {
            return false;
        }

        books.add(o);
        return true;
    }

    @Override
    public void remove(Book o) {
        books.remove(o);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return books.stream()
                .filter(book -> book.getPublishedYear().isAfter(from))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return books.stream()
                .filter(book -> book.getPublishedYear().isAfter(from) && book.getPublishedYear().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        books.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return books.stream()
                .collect(Collectors
                        .toMap(Book::getAuthor,
                                book -> getAllBooksByAuthor(book.getAuthor())));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return books.stream().collect(Collectors.toMap(
                        Book::getPublisher,
                        book -> books.stream()
                                .filter(x -> x.getPublisher().equals(book.getPublisher()))
                                .collect(Collectors.toList())
                )
        );
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return books.stream()
                .filter(bookPredicate)
                .collect(Collectors.toList());
    }
}
