package sberSchool.homework1819.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sberSchool.homework1819.dao.ProductDao;
import sberSchool.homework1819.models.Product;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        productDao.save(product);
    }

    public List allProduct() {
        return productDao.allProduct();
    }
}
