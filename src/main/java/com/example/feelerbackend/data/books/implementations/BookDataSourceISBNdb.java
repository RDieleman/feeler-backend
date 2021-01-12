package com.example.feelerbackend.data.books.implementations;

import com.example.feelerbackend.domain.model.book.BookDAO;
import com.example.feelerbackend.data.books.BookDataSource;
import com.example.feelerbackend.web.api.exception.implementations.BookNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Profile("dev")
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
    public BookDAO getBookByISBN(String ISBN) {
        String requestBase = "/book/%s";
        String endpoint = String.format(requestBase, ISBN);

        try{
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = executeRequest(endpoint);

            return mapper.convertValue(map.get("book"), BookDAO.class);
        }catch (Exception ex){
            System.out.println(ex);
            throw new BookNotFoundException(ISBN);
        }
    }

    @Override
    public List<BookDAO> getBooksBySubject(int page, int size, String subject) {
        String requestBase = "/search/books?page=%s&pageSize=%s&subject=%s";
        String endpoint = String.format(requestBase, page, size, subject);
        try{
            Map<String, Object> map = executeRequest(endpoint);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.convertValue(map.get("data"), new TypeReference<List<BookDAO>>(){});

        }catch (Exception ex){
            System.out.println(ex);
            throw new BookNotFoundException("test"); //todo: implement custom exceptions
        }
    }

    private Map<String, Object> executeRequest(String endpoint) throws JsonProcessingException {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", key);

        HttpEntity<?> entity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                path + endpoint,
                HttpMethod.GET,
                entity,
                String.class
        );

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody(), Map.class);
    }
}
