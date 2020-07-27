package com.sonan.booklibrary.controller;

import com.sonan.booklibrary.model.Book;
import com.sonan.booklibrary.model.Reader;
import com.sonan.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * reader jaeseong이 읽을 책 list이다.
 *
 * Created by Jaeseong on 2020/07/24
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@Controller
@RequestMapping(name = "/")
public class ReadingListController {

    private BookRepository bookRepo;

    @Autowired
    public ReadingListController(BookRepository bookRepository) {
        this.bookRepo = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Reader reader, Model model) {
        List<Book> readingList = bookRepo.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
        }
        // will check this str on view resolver
        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addOnReadingList(Reader reader, Book book) {
        book.setReader(reader);
        bookRepo.save(book);
        return "redirect:/";
    }
}
