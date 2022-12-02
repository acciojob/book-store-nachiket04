package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private HashMap <Integer, Book> bookHashMap = new HashMap<>();

    private int id = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookRepository(){
        
    }

    public Book save(Book book){
        book.setId(id);
        bookHashMap.put(book.getId(), book);
        this.id++;
        return book;
    }

    public Book findBookById(int id){
        return bookHashMap.get(id);
    }

    public List<Book> findAll(){
        List <Book> bookList = new ArrayList<>();
        for(int x: bookHashMap.keySet()){
            bookList.add(bookHashMap.get(x));
        }
        return bookList;
    }

    public void deleteBookById(int id){
        bookHashMap.remove(id);
    }

    public void deleteAll(){
        bookHashMap.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List <Book> bookList = new ArrayList<>();
        for(int x: bookHashMap.keySet()){
            if(bookHashMap.get(x).getAuthor().equals(author)){
                bookList.add(bookHashMap.get(x));
            }
        }
        return bookList;
    }

    public List<Book> findBooksByGenre(String genre){
        List <Book> bookList = new ArrayList<>();
        for(int x: bookHashMap.keySet()){
            if(bookHashMap.get(x).getGenre().equals(genre)){
                bookList.add(bookHashMap.get(x));
            }
        }
        return bookList;
    }
}
