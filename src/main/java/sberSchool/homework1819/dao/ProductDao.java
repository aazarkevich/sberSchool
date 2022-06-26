package sberSchool.homework1819.dao;

import org.springframework.data.repository.CrudRepository;
import sberSchool.homework1819.models.Product;

import java.util.List;

public interface ProductDao {
    void save(Product product);
    List allProduct();
}
