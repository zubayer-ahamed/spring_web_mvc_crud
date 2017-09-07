package com.coderslab.controller;

import com.coderslab.dao.ProductDao;
import com.coderslab.model.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/editPage/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable("id") String id, ModelMap modelMap) {
        product = productDao.getProduct(Integer.parseInt(id));
        modelMap.addAttribute("product", product);
        return "edit";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(ModelMap modelMap, HttpServletRequest request) {
        product = new Product();
        product.setPid(Integer.parseInt(request.getParameter("pid")));
        product.setPname(request.getParameter("pname"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setQty(Integer.parseInt(request.getParameter("qty")));
        boolean status = productDao.updateProduct(product);
        if (status) {
            product = productDao.getProduct(product.getPid());
            modelMap.addAttribute("product", product);
            modelMap.addAttribute("sm", "Product Update Successfully");
        } else {
            product = productDao.getProduct(product.getPid());
            modelMap.addAttribute("product", product);
            modelMap.addAttribute("em", "Product not Update");
        }
        return "edit";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") String id, ModelMap modelMap) {

        boolean status = productDao.deleteProduct(Integer.parseInt(id));
        if (status) {
            List<Product> products = productDao.getAllProduct();
            modelMap.addAttribute("products", products);
            modelMap.addAttribute("sm", "Product deleted Successfully");
        } else {
            List<Product> products = productDao.getAllProduct();
            modelMap.addAttribute("products", products);
            modelMap.addAttribute("em", "Product not deleted");
        }
        return "index";
    }

}
