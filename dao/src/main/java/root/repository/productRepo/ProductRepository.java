package root.repository.productRepo;

import org.hibernate.type.CustomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import root.model.Product;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product,Long>,CustomProductRepository {

    @Override
    <S extends Product> S save(S s);

    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    @Override
    void deleteById(Long id);

    @Override
    void delete(Product product);


}
