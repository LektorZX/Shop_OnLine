package root.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.model.Product;
import root.repository.productRepo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ProductServiceImpl implements BaseService<Product, Long> {

    @Autowired
    ProductRepository productRepository;

    @Override
    public <S extends Product> S save(S entity) {
        return productRepository.save(entity);
    }

    @Override
    public Optional<Product> findById(Long primaryKey) {
        return productRepository.findById(primaryKey);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    public void update(Product product) {
        productRepository.update(product);
    }

}
