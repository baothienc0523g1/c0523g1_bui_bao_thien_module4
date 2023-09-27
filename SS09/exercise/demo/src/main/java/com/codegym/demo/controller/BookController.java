package com.codegym.demo.controller;

import com.codegym.demo.model.Book;
import com.codegym.demo.model.BookType;
import com.codegym.demo.model.Rent;
import com.codegym.demo.service.IBookService;
import com.codegym.demo.service.IBookTypeService;
import com.codegym.demo.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookTypeService bookTypeService;
    @Autowired
    private IRentService rentService;

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = this.bookService.findAll(false);
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    // book add
    @GetMapping("/bookAdd")
    public String addBookForm(Model model) {
        List<BookType> bookTypes = this.bookTypeService.findAll();
        model.addAttribute("book", new Book());
        model.addAttribute("bookTypes", bookTypes);
        return "book-add";
    }

    @PostMapping("/bookAdd")
    public String add(@ModelAttribute Book book,
                      RedirectAttributes redirectAttributes) {
        this.bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Thêm sách vào thư viện thành công");
        return "redirect:/";
    }

    // type add
    @GetMapping("/typeAdd")
    public String addTypeForm(Model model) {
        model.addAttribute("type", new BookType());
        return "type-add";
    }

    @PostMapping("/typeAdd")
    public String addType(@ModelAttribute BookType type,
                          RedirectAttributes redirectAttributes) {
        this.bookTypeService.add(type);
        redirectAttributes.addFlashAttribute("message", "Thêm danh mục mới vào thư viện thành công");
        return "redirect:/";
    }

    // rent
    @GetMapping("/showType")
    public String showTypeOfBook(Model model) {
        List<BookType> bookTypes = this.bookTypeService.findAll();
        model.addAttribute("bookTypes", bookTypes);
        return "book-rent";
    }

    @GetMapping("/rentShow/{typeId}")
    public String showRent(@PathVariable int typeId, Model model) {
        BookType bookType = this.bookTypeService.findById(typeId);
        List<Book> findBookByType = this.bookService.findAllByBookTypeAndStatusIsFalse(bookType);
        model.addAttribute("findBookByType", findBookByType);
        return "book-rent-show";
    }

    @GetMapping("/rent/{bookId}")
    public String rent(@PathVariable int bookId,
                       Model model) {
        Integer code = this.rentService.codeGeneration();
        Book book = this.bookService.findById(bookId);
        book.setStatus(true);
        Rent rent = new Rent(code, book);
        this.rentService.add(rent);
        model.addAttribute("code", code);
        model.addAttribute("book", book);
        return "rent-show-code";
    }
    // refund
    @GetMapping("/refund")
    public String showFormRefund() {
        return "refund";
    }

//    @PostMapping("/refund/{code}")
//    public String refund(@PathVariable Integer code, RedirectAttributes redirectAttributes) {
//        if (!this.rentService.findByCode(code)) {
//            redirectAttributes.addFlashAttribute("message", "Sai mã mượn sách, vui lòng nhập lại");
//            return "error";
//        }
//
//        this.rentService.remove();
//    }
}
