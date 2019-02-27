package root.repository.BasketRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import root.DTO.BasketDto;
import root.model.Basket;
import root.model.BasketEmbeddedId;
import root.model.Order;
import root.model.User;
import root.model.UserDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomBasketRepositoryImpl implements CustomBasketRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public CustomBasketRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public Basket saveCustom(Basket basket) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(basket);
        entityManager.getTransaction().commit();
        entityManager.close();
        return basket;
    }


}
