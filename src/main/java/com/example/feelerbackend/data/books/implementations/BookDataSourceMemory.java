package com.example.feelerbackend.data.books.implementations;

import com.example.feelerbackend.data.books.BookDataSource;
import com.example.feelerbackend.data.books.dao.BookDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("test")
public class BookDataSourceMemory extends BookDataSource {

    @Override
    public BookDAO getBookByISBN(String ISBN) {
        return generateBooks(1).remove(0);
    }

    @Override
    public List<BookDAO> getBooksBySubject(int page, int size, String subject) {
        return generateBooks(size);
    }

    private List<BookDAO> generateBooks(int amount) {
        List<BookDAO> books = new ArrayList<>();

        for (int i = 1; i <= amount; i++) {
            books.add(
                    new BookDAO(
                            "isbn " + i,
                            "title " + i,
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris id mollis enim, in varius leo. In vel nulla vitae dui tristique luctus. Nam laoreet tortor condimentum lacus feugiat molestie. Vestibulum ante enim, lobortis in facilisis sit amet, posuere quis ipsum. Fusce scelerisque viverra rutrum. Nullam tincidunt ipsum dolor, eget cursus lorem malesuada nec. Nullam eleifend arcu dui, ut dictum arcu facilisis id. Sed augue enim, fringilla in orci et, ultrices varius ante. Quisque non consequat nisl. ",
                            "https://college.indiana.edu/images/publications/book-cover-placeholder.jpg"
                    ));
        }

        return books;
    }
}
