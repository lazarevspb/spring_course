package ru.lazarev.springcourse.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lazarev.springcourse.product_application.Product;
import ru.lazarev.springcourse.product_application.bean.ProductRepository;

import java.util.List;

@Controller
public class AllProductController {
    private final ProductRepository repository;

    @Autowired
    public AllProductController(ProductRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/all")
    public String allPage(Model model) {
//        System.out.println(repository.toString());

        System.out.println(repository.getList());

        List<Product> product = repository.getList();
//        model.addAttribute ("repository", repository);
        model.addAttribute ("product", product);
        return "products/products";
    }
}