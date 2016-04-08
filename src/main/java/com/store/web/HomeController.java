package com.store.web;


import com.store.db.Category;
import com.store.db.Product;
import com.store.repository.CartRepository;
import com.store.repository.CategoryRepository;
import com.store.repository.ProductRepository;
import com.store.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CartRepository cartRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public HomeController(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          CartRepository cartRepository,
                          AuthenticationService authenticationService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.cartRepository = cartRepository;
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model) {
        List<Product> productList = productRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("cart", cartRepository);
        model.addAttribute("user", authenticationService.getUser());
        return "home";
    }
}
