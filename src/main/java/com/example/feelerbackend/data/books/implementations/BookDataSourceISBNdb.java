package com.example.feelerbackend.data.books.implementations;

import com.example.feelerbackend.domain.model.book.BookDAO;
import com.example.feelerbackend.data.books.BookDataSource;
import com.example.feelerbackend.web.api.exception.BookNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@Profile({"dev", "prod"})
public class BookDataSourceISBNdb extends BookDataSource {
    private final RestTemplate restTemplate;
    @Value("${ISBNdb.path}")
    private String path;
    @Value("${ISBNdb.key}")
    private String key;

    public BookDataSourceISBNdb() {
        restTemplate = new RestTemplate();
    }

    @Override
    public BookDAO getBookInfoByISBN(String ISBN) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", key);
        HttpEntity<?> entity = new HttpEntity<Object>(headers);
        try{
            ResponseEntity<String> response = restTemplate.exchange(
                    path + ISBN,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(response.getBody(), Map.class);
            return mapper.convertValue(map.get("book"), BookDAO.class);
        }catch (Exception ex){
            System.out.println("An error occurred while using the ISBNdb api.");
            throw new BookNotFoundException(ISBN);
        }
    }
}
