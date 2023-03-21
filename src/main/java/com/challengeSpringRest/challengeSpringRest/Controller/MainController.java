package com.challengeSpringRest.challengeSpringRest.Controller;

import com.challengeSpringRest.challengeSpringRest.Entity.Book;
import com.challengeSpringRest.challengeSpringRest.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    BookRepository bookRepository;

@GetMapping("/books")
public List<Book> index(){
    return bookRepository.findAll();
}


@GetMapping("/books/{id}")
    public Book show(@PathVariable int id) {
return bookRepository.findById(id).get();
}
    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }



    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        // getting blog
        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setDescription(book.getDescription());
        return bookRepository.save(bookToUpdate);
    }

@DeleteMapping("books/{id}")
    public boolean delete(@PathVariable int id) {
    bookRepository.deleteById(id);
    return true;
}

}
