package ru.lazarev.springcourse.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.lazarev.springcourse.productapplication.Product;
import ru.lazarev.springcourse.productapplication.ProductRepository;

@Controller
@RequestMapping("/add")
public class AddProductController {
    private final ProductRepository repository;

    @Autowired
    public AddProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String getForm(Model uiModel) {
        uiModel.addAttribute("product", new Product());
        return "products/add_products";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String create(Product product) {
        repository.addProduct(product);
        return "products/add_products";
    }
}