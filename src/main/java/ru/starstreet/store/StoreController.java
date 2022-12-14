package ru.starstreet.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    private ProductDaoImpl productDao;

    @Autowired
    public void setProductDao(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/products/find/{id}")
    public Product findById(@PathVariable Long id){
        System.out.println("hey there!");
        return productDao.findById(id);
    }


    @GetMapping("/products")
    public List<Product> getProductList() {
        return productDao.findAll();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productDao.deleteById(id);
    }


    @PostMapping("/products/saveOrUpdate")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product);
        productDao.saveOrUpdate(product);
    }
}
