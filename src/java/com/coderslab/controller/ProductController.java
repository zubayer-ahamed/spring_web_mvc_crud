package com.coderslab.controller;

import com.coderslab.dao.ProductDao;
import com.coderslab.model.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private Product product;

    @RequestMapping("/")
    public String loadFirstPage(ModelMap modelMap) {
        List<Product> products = productDao.getAllProduct();
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("message", "kutta");
        return "index";
    }

    @RequestMapping(value = "/insertPage")
    public String insertPage() {
        return "insert";
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(ModelMap modelMap, HttpServletRequest request) {
        product = new Product();
        product.setPname(request.getParameter("pname"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setQty(Integer.parseInt(request.getParameter("qty")));
        boolean status = productDao.saveProduct(product);
        if (status) {
            modelMap.addAttribute("sm", "Product Saved Successfully");
        } else {
            modelMap.addAttribute("em", "Product not Saved");
        }
        return "insert";
    }

}
