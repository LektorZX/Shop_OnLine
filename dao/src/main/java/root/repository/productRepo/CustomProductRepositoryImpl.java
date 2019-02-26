package root.repository.productRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import root.model.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public CustomProductRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void update(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
