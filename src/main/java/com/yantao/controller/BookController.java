package com.yantao.controller;

import com.yantao.pojo.Books;
import com.yantao.service.BookService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author YanTao
 * @date 2021/5/21
 * @time 20:04
 */
@Controller
@RequestMapping("/book")
public class BookController {
//    controller 调 service 层
    private BookService bookService;

    @Autowired
    @Qualifier("bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    //    查询全部书籍，并且返回到一个书籍展示页面
    @RequestMapping("/all")
    @RequiresPermissions("admin:select")
    public String selectAllBooks(Model model){
        List<Books> books = bookService.selectAll();
        model.addAttribute("books", books);
        return "allBooks";
    }

//    跳转到添加书籍页面
    @RequestMapping("/toAdd")
    @RequiresPermissions("/admin:add")
    public String toAddPage(){
        return "add";
    }

//    添加书籍，并跳转到书籍展示页面
    @RequestMapping("/add")
    @RequiresPermissions("/admin:add")
    public String insert(Books books){
        System.out.println("books==>" + books);
        bookService.insert(books);
        return "redirect:/book/all";    //使用redirect重东西，可以防止用户（使用f5刷新）重复提交表单
    }

//    跳转到修改书籍页面
    @RequestMapping("/toUpdate/{bookId}")
    @RequiresPermissions("admin:update")
    public String toUpdatePage(@PathVariable("bookId") int id, Model model){
        Books book = bookService.selectOneById(id);
        model.addAttribute("book", book);
        return "update";
    }

//    更改书籍，并跳转到书籍展示页面
    @RequestMapping("/update")
    @RequiresPermissions("admin:update")
    public String update(Books books){
        System.out.println("books==>" + books);
        bookService.update(books);
        return "redirect:/book/all";
    }

//    删除书籍，并跳转到书籍展示页面
    @RequestMapping("/delete")
    @RequiresPermissions("admin:delete")
    public String delete(@RequestParam("id") int bookId){
        bookService.delete(bookId);
        return "redirect:/book/all";
    }

//    按照名字查询书籍
    @RequestMapping("/search")
    @RequiresPermissions("user:select")
    public String selectBookByName(@RequestParam("bookName") String name, Model model){
        List<Books> books = bookService.selectByName(name);
        model.addAttribute("books", books);
        return "allBooks";
    }
}
