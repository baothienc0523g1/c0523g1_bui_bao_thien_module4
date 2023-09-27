package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BookType;
import com.codegym.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.codegym.service.IBookService;
import com.codegym.service.IBookTypeService;
import com.codegym.service.IRentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookTypeService bookTypeService;
    @Autowired
    private IRentService rentService;

    // ----------MAIN PAGE----------
    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = this.bookService.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    // ----------BACK----------
    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    // ----------BOOK ADD----------
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

    //    ----------BOOK TYPE ADD----------
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

    // ----------RENT----------
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
    // ----------REFUND----------
    @GetMapping("/refund")
    public String showFormRefund() {
        return "refund";
    }
    @PostMapping("/refund")
    public String refund(@RequestParam(name = "code") Integer code,
                         RedirectAttributes redirectAttributes) {
        boolean flag = this.rentService.existedCode(code);
        if (!flag) {
            redirectAttributes.addFlashAttribute("message","Sai mã mượn sách, vui lòng nhập đúng mã đã được cung cấp");
            return "errors";
        }
        Rent rent = this.rentService.findByCode(code);
        this.rentService.remove(rent.getId());
        int bookId = rent.getBook().getId();
        Book book = this.bookService.findById(bookId);
        book.setStatus(false);
        this.bookService.save(book);
        redirectAttributes.addFlashAttribute("message","Trả sách thành công");
        return "redirect:/";
    }
}