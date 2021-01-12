package com.example.feelerbackend.domain.model.bookshelf;

import com.example.feelerbackend.domain.model.bookshelf.item.BookshelfItem;
import com.example.feelerbackend.domain.model.bookshelf.item.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookshelfDAO {
    private List<BookshelfItem> content = new ArrayList<>();
}
