package ru.lazarev.springcourse.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lazarev.springcourse.productapplication.Product;
import ru.lazarev.springcourse.productapplication.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository repository;

    @GetMapping("/")
    public String getProductPage(){
        return "products/main";
    }


    @Autowired
    public ProductsController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public String allPage(Model model) {
        List<Product> product = repository.getList();
        model.addAttribute("product", product);
        return "products/all";
    }

    /**
     * Метод getForm(...) - Создаёт пустой объект-сущность, добавляет его в объект модели и возвращает имя представления,
     * в котором содержится данная форма. Тогда DispatcherServlet добавит объект не по имени переменной EL,
     * а по наименованию, указанному в атрибуте th:object тега form. Данный механизм предоставляет доступ
     * к атрибутам объекта с возможностью их изменения.
     */
    @GetMapping("/add")
    public String getForm(Model uiModel) {
        uiModel.addAttribute("product", new Product());
        return "products/add";
    }

    /**
     * Метод create(...) вызывается после того, как клиент заполнил все поля формы и отправил ее
     * POST-запроcом. В метод create(...) DispatcherServlet передает объект, полям которого присвоены
     */
    @PostMapping("products/form")
    public String create(Product product) {
        repository.addProduct(product);
        return "products/complete";
    }


}
