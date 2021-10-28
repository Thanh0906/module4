package com.codegym.repository;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Toyota Camry", 130000, "New", "Toyota"));
        products.put(2, new Product(2, "Hyundai Grand i10", 150000, "New", "Hyundai"));
        products.put(3, new Product(3, "Toyota Corolla Cross", 180000, "New", "Toyota"));
        products.put(4, new Product(4, "Honda Accord", 90000, "New", "Honda "));
        products.put(5, new Product(5, "Vinfast Lux A2.0", 320, "New", "Vinfast"));
        products.put(6, new Product(6, "Mazda 6", 40000, "New Like", "Mazda"));
        products.put(7, new Product(7, "BMW 750LI", 450000, "New", "BWM"));
        products.put(8, new Product(8, "Mercedes-AMG SLC43", 680000, "New", "Mercedes"));
        products.put(9, new Product(9, "Kia Soul", 620, "New", "Kia"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String string) {
        List<Product> productListSearch = new ArrayList<>();
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (product.getName().contains(string)) {
                productListSearch.add(product);
            }
        }
        return productListSearch;
    }
}
