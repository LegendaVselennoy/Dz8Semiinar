package com.example.aop.service;

import com.example.aop.aspects.TrackUserAction;
import com.example.aop.model.Product;
import com.example.aop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;



    @TrackUserAction
    public Product addProduct(Product note) {
        return productRepo.save(note);
    }

    @TrackUserAction
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    public Product productUpdate(Long id,Product product) {
        Optional<Product> current=productRepo.findById(id);
        if (current.isPresent()){
            Product changePro=current.get();
            changePro.setName(product.getName());
            changePro.setPrice(product.getPrice());
        }
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
